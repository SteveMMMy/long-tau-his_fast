package com.ruoyi.project.his.prescriptions.controller;

import java.util.List;

import com.ruoyi.project.his.prescriptions.domain.HisPrescriptionsSchedules;
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
import com.ruoyi.project.his.prescriptions.domain.HisPrescriptions;
import com.ruoyi.project.his.prescriptions.service.IHisPrescriptionsService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 处方Controller
 * 
 * @author SteveMMMy
 * @date 2024-05-17
 */
@Controller
@RequestMapping("/his/prescriptions")
public class HisPrescriptionsController extends BaseController
{
    private String prefix = "his/prescriptions";

    @Autowired
    private IHisPrescriptionsService hisPrescriptionsService;

    @RequiresPermissions("his:prescriptions:view")
    @GetMapping()
    public String prescriptions()
    {
        return prefix + "/prescriptions";
    }

    @GetMapping("/entry")
    public String prescriptionsEntry()
    {
        return prefix + "/entry";
    }

    /**
     * 查询处方列表
     */
    @RequiresPermissions("his:prescriptions:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HisPrescriptions hisPrescriptions)
    {
        startPage();
        List<HisPrescriptions> list = hisPrescriptionsService.selectHisPrescriptionsList(hisPrescriptions);
        return getDataTable(list);
    }

    /**
     * 查询某处方明细
     */
    @RequiresPermissions("his:prescriptions:list")
    @PostMapping("/list/{prscId}")
    @ResponseBody
    public TableDataInfo listByPrscId(@PathVariable("prscId") Long prscId)
    {
        startPage();
        List<HisPrescriptionsSchedules> list = hisPrescriptionsService.selectHisPrescriptionsSchedulesList(prscId);
        return getDataTable(list);
    }

    /**
     * 导出处方列表
     */
    @RequiresPermissions("his:prescriptions:export")
    @Log(title = "处方", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HisPrescriptions hisPrescriptions)
    {
        List<HisPrescriptions> list = hisPrescriptionsService.selectHisPrescriptionsList(hisPrescriptions);
        ExcelUtil<HisPrescriptions> util = new ExcelUtil<HisPrescriptions>(HisPrescriptions.class);
        return util.exportExcel(list, "处方数据");
    }

    /**
     * 新增处方
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存处方
     */
    @RequiresPermissions("his:prescriptions:add")
    @Log(title = "处方", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HisPrescriptions hisPrescriptions)
    {
        return toAjax(hisPrescriptionsService.insertHisPrescriptions(hisPrescriptions));
    }

    /**
     * 修改处方
     */
    @RequiresPermissions("his:prescriptions:edit")
    @GetMapping("/edit/{prscId}")
    public String edit(@PathVariable("prscId") Long prscId, ModelMap mmap)
    {
        HisPrescriptions hisPrescriptions = hisPrescriptionsService.selectHisPrescriptionsByPrscId(prscId);
        mmap.put("hisPrescriptions", hisPrescriptions);
        return prefix + "/edit";
    }

    /**
     * 修改保存处方
     */
    @RequiresPermissions("his:prescriptions:edit")
    @Log(title = "处方", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HisPrescriptions hisPrescriptions)
    {
        return toAjax(hisPrescriptionsService.updateHisPrescriptions(hisPrescriptions));
    }

    /**
     * 修改处方状态为已配药
     */
    @RequiresPermissions("his:prescriptions:edit")
    @Log(title = "处方", businessType = BusinessType.UPDATE)
    @PostMapping("/edit_status/{prscId}")
    @ResponseBody
    public AjaxResult editStatus(@PathVariable("prscId") Long prscId)
    {
        // 处方状态为2
        Long status = 2L;

        HisPrescriptions hisPrescriptions = new HisPrescriptions();
        hisPrescriptions.setPrscId(prscId);
        hisPrescriptions.setPrscStatus(status);

        return toAjax(hisPrescriptionsService.updateHisPrescriptionsInfo(hisPrescriptions));
    }

    /**
     * 修改保存处方明细
     */
    @RequiresPermissions("his:prescriptions:edit")
    @Log(title = "处方明细", businessType = BusinessType.UPDATE)
    @PostMapping("/edit_sch")
    @ResponseBody
    public AjaxResult editSch(HisPrescriptions hisPrescriptions)
    {
        return toAjax(hisPrescriptionsService.updateHisPrescriptionsSchedulesList(hisPrescriptions));
    }

    /**
     * 删除处方
     */
    @RequiresPermissions("his:prescriptions:remove")
    @Log(title = "处方", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hisPrescriptionsService.deleteHisPrescriptionsByPrscIds(ids));
    }
}
