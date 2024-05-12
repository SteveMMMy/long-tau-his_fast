package com.ruoyi.project.his.plans.controller;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.his.plans.domain.HisProcurementSchedules;
import com.ruoyi.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.his.plans.domain.HisProcurementPlans;
import com.ruoyi.project.his.plans.service.IHisProcurementPlansService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 采购计划单Controller
 * 
 * @author SteveMMMy
 * @date 2024-05-01
 */
@Controller
@RequestMapping("/his/plans")
public class HisProcurementPlansController extends BaseController
{
    private String prefix = "his/plans";

    @Autowired
    private IHisProcurementPlansService hisProcurementPlansService;

    @RequiresPermissions("his:plans:view")
    @GetMapping()
    public String plans()
    {
        return prefix + "/plans";
    }

    /**
     * 查询采购计划单列表
     */
    @RequiresPermissions("his:plans:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HisProcurementPlans hisProcurementPlans)
    {
        startPage();
        List<HisProcurementPlans> list = hisProcurementPlansService.selectHisProcurementPlansList(hisProcurementPlans);
        return getDataTable(list);
    }

    /**
     * 查询采购计划单列表（根据多个id）
     */
    @RequiresPermissions("his:plans:list")
    @PostMapping("/list_ids")
    @ResponseBody
    public TableDataInfo listIds(String prcpIdsStr)
    {
        startPage();
        Long[] prcpIds = Convert.toLongArray(prcpIdsStr);

        // 返回查询结果列表
        List<HisProcurementPlans> resultsList = new ArrayList<>();
        for (Long prcpId : prcpIds) {
            HisProcurementPlans hisProcurementPlans = hisProcurementPlansService.selectHisProcurementPlansByPrcpId(prcpId);
            hisProcurementPlans.setPrcpId(prcpId);
            resultsList.add(hisProcurementPlans);
        }
        return getDataTable(resultsList);
    }

    /**
     * 根据ID查询采购计划单明细
     */
    @RequiresPermissions("his:plans:list")
    @PostMapping("/list_sch")
    @ResponseBody
    public TableDataInfo listSchedules(Long prcpId) {
        startPage();
        HisProcurementPlans hisProcurementPlans = hisProcurementPlansService.selectHisProcurementPlansByPrcpId(prcpId);
        List<HisProcurementSchedules> hisProcurementSchedulesList = hisProcurementPlans.getHisProcurementSchedulesList();

        return getDataTable(hisProcurementSchedulesList);
    }

    /**
     * 导出采购计划单列表
     */
    @RequiresPermissions("his:plans:export")
    @Log(title = "采购计划单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HisProcurementPlans hisProcurementPlans)
    {
        List<HisProcurementPlans> list = hisProcurementPlansService.selectHisProcurementPlansList(hisProcurementPlans);
        ExcelUtil<HisProcurementPlans> util = new ExcelUtil<HisProcurementPlans>(HisProcurementPlans.class);
        return util.exportExcel(list, "采购计划单数据");
    }

    /**
     * 新增采购计划单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存采购计划单
     */
    @RequiresPermissions("his:plans:add")
    @Log(title = "采购计划单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HisProcurementPlans hisProcurementPlans)
    {
        // 获取当前用户ID
        hisProcurementPlans.setUserId(ShiroUtils.getSysUser().getUserId());

        return toAjax(hisProcurementPlansService.insertHisProcurementPlans(hisProcurementPlans));
    }

    /**
     * 修改采购计划单
     */
    @RequiresPermissions("his:plans:edit")
    @GetMapping("/edit/{prcpId}")
    public String edit(@PathVariable("prcpId") Long prcpId, ModelMap mmap)
    {
        HisProcurementPlans hisProcurementPlans = hisProcurementPlansService.selectHisProcurementPlansByPrcpId(prcpId);
        hisProcurementPlans.setPrcpId(prcpId);
        mmap.put("hisProcurementPlans", hisProcurementPlans);
        return prefix + "/edit";
    }

    /**
     * 修改保存采购计划单
     */
    @RequiresPermissions("his:plans:edit")
    @Log(title = "采购计划单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HisProcurementPlans hisProcurementPlans)
    {
        return toAjax(hisProcurementPlansService.updateHisProcurementPlans(hisProcurementPlans));
    }

    /**
     * 批量修改保存采购计划单状态
     * TODO 插入采购单ID
     *
     * @param prcpIdsStr 采购计划单id列表字符串
     * @param prcpStatus 采购计划单状态
     * @return 结果
     */
    @RequiresPermissions("his:plans:edit")
    @Log(title = "采购计划单状态", businessType = BusinessType.UPDATE)
    @PostMapping("/edit_status")
    @ResponseBody
    public AjaxResult editSaveStatus(String prcpIdsStr, Long prcpStatus) {
        Long[] prcpIds = Convert.toLongArray(prcpIdsStr);
        int rows = 0;
        for (Long prcpId : prcpIds) {
            rows += hisProcurementPlansService.updateHisProcurementPlansStatus(prcpId, prcpStatus);
        }

        return toAjax(rows);
    }

    /**
     * 删除采购计划单
     */
    @RequiresPermissions("his:plans:remove")
    @Log(title = "采购计划单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hisProcurementPlansService.deleteHisProcurementPlansByPrcpIds(ids));
    }
}
