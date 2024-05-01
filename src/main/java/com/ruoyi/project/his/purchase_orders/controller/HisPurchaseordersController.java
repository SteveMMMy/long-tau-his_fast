package com.ruoyi.project.his.purchase_orders.controller;

import java.util.List;
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
import com.ruoyi.project.his.purchase_orders.domain.HisPurchaseorders;
import com.ruoyi.project.his.purchase_orders.service.IHisPurchaseordersService;
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
@RequestMapping("/his/purchase_orders")
public class HisPurchaseordersController extends BaseController
{
    private String prefix = "his/purchase_orders";

    @Autowired
    private IHisPurchaseordersService hisPurchaseordersService;

    @RequiresPermissions("his:purchase_orders:view")
    @GetMapping()
    public String purchase_orders()
    {
        return prefix + "/purchase_orders";
    }

    /**
     * 查询采购订单列表
     */
    @RequiresPermissions("his:purchase_orders:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HisPurchaseorders hisPurchaseorders)
    {
        startPage();
        List<HisPurchaseorders> list = hisPurchaseordersService.selectHisPurchaseordersList(hisPurchaseorders);
        return getDataTable(list);
    }

    /**
     * 导出采购订单列表
     */
    @RequiresPermissions("his:purchase_orders:export")
    @Log(title = "采购订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HisPurchaseorders hisPurchaseorders)
    {
        List<HisPurchaseorders> list = hisPurchaseordersService.selectHisPurchaseordersList(hisPurchaseorders);
        ExcelUtil<HisPurchaseorders> util = new ExcelUtil<HisPurchaseorders>(HisPurchaseorders.class);
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
    @RequiresPermissions("his:purchase_orders:add")
    @Log(title = "采购订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HisPurchaseorders hisPurchaseorders)
    {
        return toAjax(hisPurchaseordersService.insertHisPurchaseorders(hisPurchaseorders));
    }

    /**
     * 修改采购订单
     */
    @RequiresPermissions("his:purchase_orders:edit")
    @GetMapping("/edit/{purId}")
    public String edit(@PathVariable("purId") Long purId, ModelMap mmap)
    {
        HisPurchaseorders hisPurchaseorders = hisPurchaseordersService.selectHisPurchaseordersByPurId(purId);
        mmap.put("hisPurchaseorders", hisPurchaseorders);
        return prefix + "/edit";
    }

    /**
     * 修改保存采购订单
     */
    @RequiresPermissions("his:purchase_orders:edit")
    @Log(title = "采购订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HisPurchaseorders hisPurchaseorders)
    {
        return toAjax(hisPurchaseordersService.updateHisPurchaseorders(hisPurchaseorders));
    }

    /**
     * 删除采购订单
     */
    @RequiresPermissions("his:purchase_orders:remove")
    @Log(title = "采购订单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hisPurchaseordersService.deleteHisPurchaseordersByPurIds(ids));
    }
}
