package com.ruoyi.project.his.purchase.controller;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.his.entry.domain.HisEntrySchedules;
import com.ruoyi.project.his.purchase.domain.HisOrdersSchedules;
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
import com.ruoyi.project.his.purchase.domain.HisPurchaseOrders;
import com.ruoyi.project.his.purchase.service.IHisPurchaseOrdersService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 采购订单Controller
 * 
 * @author SteveMMMy
 * @date 2024-05-01
 */
@Controller
@RequestMapping("/his/purchase")
public class HisPurchaseOrdersController extends BaseController
{
    private String prefix = "his/purchase";

    @Autowired
    private IHisPurchaseOrdersService hisPurchaseOrdersService;

    @RequiresPermissions("his:purchase:view")
    @GetMapping()
    public String purchase()
    {
        return prefix + "/purchase";
    }

    @GetMapping("/select")
    public String selectProcPlans() {
        return prefix + "/select";
    }

    /**
     * 查询采购订单列表
     */
    @RequiresPermissions("his:purchase:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HisPurchaseOrders hisPurchaseOrders)
    {
        startPage();
        List<HisPurchaseOrders> list = hisPurchaseOrdersService.selectHisPurchaseOrdersList(hisPurchaseOrders);
        return getDataTable(list);
    }

    /**
     * 查询采购单列表（根据多个id），返回入库单明细
     */
    @RequiresPermissions("his:purchase:list")
    @PostMapping("/list_ids")
    @ResponseBody
    public TableDataInfo listIds(String orderIdsStr)
    {
        startPage();
        Long[] orderIds = Convert.toLongArray(orderIdsStr);

        // 返回查询结果列表
        List<HisEntrySchedules> resultsList = new ArrayList<>();
        for (Long orderId : orderIds) {
            // 得到采购单明细
            HisPurchaseOrders hisPurchaseOrders = hisPurchaseOrdersService.selectHisPurchaseOrdersByPurId(orderId);
            List<HisOrdersSchedules> hisOrdersSchedulesList = hisPurchaseOrders.getHisOrdersSchedulesList();

            // 将数据给入库单明细对象
            for (HisOrdersSchedules hisOrdersSchedules : hisOrdersSchedulesList) {
                HisEntrySchedules hisEntrySchedules = getHisEntrySchedules(hisOrdersSchedules);

                resultsList.add(hisEntrySchedules);
            }
        }

        return getDataTable(resultsList);
    }

    private static HisEntrySchedules getHisEntrySchedules(HisOrdersSchedules hisOrdersSchedules) {
        HisEntrySchedules hisEntrySchedules = new HisEntrySchedules();
        hisEntrySchedules.setCatId(hisOrdersSchedules.getCatId());
        hisEntrySchedules.setCatApprovalNumber(hisOrdersSchedules.getCatApprovalNumber());
        hisEntrySchedules.setCatDrugNum(hisOrdersSchedules.getCatDrugNum());
        hisEntrySchedules.setCatName(hisOrdersSchedules.getCatName());
        hisEntrySchedules.setCatEnglishName(hisOrdersSchedules.getCatEnglishName());
        hisEntrySchedules.setCatProducer(hisOrdersSchedules.getCatProducer());
        hisEntrySchedules.setCatSpecs(hisOrdersSchedules.getCatSpecs());
        hisEntrySchedules.setCatDosageForm(hisOrdersSchedules.getCatDosageForm());
        hisEntrySchedules.setCatPackage(hisOrdersSchedules.getCatPackage());
        hisEntrySchedules.setCatUnit(hisOrdersSchedules.getCatUnit());
        hisEntrySchedules.setEntSchNum(hisOrdersSchedules.getOrderSchNumber());  // 入库数量等于采购数量
        return hisEntrySchedules;
    }

    /**
     * 导出采购订单列表
     */
    @RequiresPermissions("his:purchase:export")
    @Log(title = "采购订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HisPurchaseOrders hisPurchaseOrders)
    {
        List<HisPurchaseOrders> list = hisPurchaseOrdersService.selectHisPurchaseOrdersList(hisPurchaseOrders);
        ExcelUtil<HisPurchaseOrders> util = new ExcelUtil<HisPurchaseOrders>(HisPurchaseOrders.class);
        return util.exportExcel(list, "采购订单数据");
    }

    /**
     * 新增采购订单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存采购订单
     */
    @RequiresPermissions("his:purchase:add")
    @Log(title = "采购订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HisPurchaseOrders hisPurchaseOrders)
    {
        // 获取当前用户ID
        hisPurchaseOrders.setUserId(ShiroUtils.getSysUser().getUserId());

        return toAjax(hisPurchaseOrdersService.insertHisPurchaseOrders(hisPurchaseOrders));
    }

    /**
     * 修改采购订单
     */
    @RequiresPermissions("his:purchase:edit")
    @GetMapping("/edit/{purId}")
    public String edit(@PathVariable("purId") Long purId, ModelMap mmap)
    {
        HisPurchaseOrders hisPurchaseOrders = hisPurchaseOrdersService.selectHisPurchaseOrdersByPurId(purId);
        mmap.put("hisPurchaseOrders", hisPurchaseOrders);
        return prefix + "/edit";
    }

    /**
     * 修改保存采购订单
     */
    @RequiresPermissions("his:purchase:edit")
    @Log(title = "采购订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HisPurchaseOrders hisPurchaseOrders)
    {
        return toAjax(hisPurchaseOrdersService.updateHisPurchaseOrders(hisPurchaseOrders));
    }

    /**
     * 删除采购订单
     */
    @RequiresPermissions("his:purchase:remove")
    @Log(title = "采购订单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hisPurchaseOrdersService.deleteHisPurchaseOrdersByPurIds(ids));
    }
}
