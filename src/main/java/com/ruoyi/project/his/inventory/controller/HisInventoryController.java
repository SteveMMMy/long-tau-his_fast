package com.ruoyi.project.his.inventory.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.his.inventory.domain.HisInventory;
import com.ruoyi.project.his.inventory.service.IHisInventoryService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 库存管理Controller
 * 
 * @author SteveMMMy
 * @date 2024-05-14
 */
@Controller
@RequestMapping("/his/inventory")
public class HisInventoryController extends BaseController
{
    private String prefix = "his/inventory";

    @Autowired
    private IHisInventoryService hisInventoryService;

    @RequiresPermissions("his:inventory:view")
    @GetMapping()
    public String inventory()
    {
        return prefix + "/inventory";
    }

    @GetMapping("/dispensing")
    public String dispensing() {
        return prefix + "/dispensing";
    }

    /**
     * 查询库存管理列表
     */
    @RequiresPermissions("his:inventory:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HisInventory hisInventory)
    {
        startPage();
        List<HisInventory> list = hisInventoryService.selectHisInventoryList(hisInventory);
        return getDataTable(list);
    }

    /**
     * 导出库存管理列表
     */
    @RequiresPermissions("his:inventory:export")
    @Log(title = "库存管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HisInventory hisInventory)
    {
        List<HisInventory> list = hisInventoryService.selectHisInventoryList(hisInventory);
        ExcelUtil<HisInventory> util = new ExcelUtil<HisInventory>(HisInventory.class);
        return util.exportExcel(list, "库存管理数据");
    }

    /**
     * 新增库存管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存库存管理
     */
    @RequiresPermissions("his:inventory:add")
    @Log(title = "库存管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HisInventory hisInventory)
    {
        // 查找要插入的药品ID和生产批号
        HisInventory inv = new HisInventory();
        inv.setCatId(hisInventory.getCatId());
        inv.setInvBatchNumber(hisInventory.getInvBatchNumber());
        List<HisInventory> inventoryList = hisInventoryService.selectHisInventoryList(inv);

        int rows = 0;
        if (inventoryList.isEmpty()) {
            // 若生产批号唯一，直接插入
            rows += hisInventoryService.insertHisInventory(hisInventory);
        } else {
            // 若生产批号存在，增加数量，删除其他属性
            HisInventory presentInv = hisInventoryService.selectHisInventoryList(inv).get(0);  // 得到当前库存
            HisInventory newInv = new HisInventory();
            newInv.setInvId(presentInv.getInvId());
            newInv.setInvNumber(presentInv.getInvNumber() + hisInventory.getInvNumber());

            rows += hisInventoryService.updateHisInventory(newInv);
        }

        return toAjax(rows);
    }

    /**
     * 修改库存管理
     */
    @RequiresPermissions("his:inventory:edit")
    @GetMapping("/edit/{invId}")
    public String edit(@PathVariable("invId") Long invId, ModelMap mmap)
    {
        HisInventory hisInventory = hisInventoryService.selectHisInventoryByInvId(invId);
        mmap.put("hisInventory", hisInventory);
        return prefix + "/edit";
    }

    /**
     * 修改保存库存管理
     */
    @RequiresPermissions("his:inventory:edit")
    @Log(title = "库存管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HisInventory hisInventory)
    {
        return toAjax(hisInventoryService.updateHisInventory(hisInventory));
    }

    /**
     * 更新库存（出库）
     */
    @RequiresPermissions("his:inventory:edit")
    @Log(title = "更新库存", businessType = BusinessType.UPDATE)
    @PostMapping("/deliver")
    @ResponseBody
    public AjaxResult deliver(@RequestBody HisInventory delInv)
    {
        // 查找要插入的药品ID和生产批号，得到之前的库存
        HisInventory inv = new HisInventory();
        inv.setCatId(delInv.getCatId());
        inv.setInvBatchNumber(delInv.getInvBatchNumber());

        List<HisInventory> inventoryList = hisInventoryService.selectHisInventoryList(inv);
        HisInventory invOld = inventoryList.get(0);

        // 新的库存
        HisInventory newInv = new HisInventory();
        newInv.setInvId(invOld.getInvId());
        newInv.setInvNumber(invOld.getInvNumber() - delInv.getInvNumber());  // 减去出库数量

        return toAjax(hisInventoryService.updateHisInventory(newInv));
    }

    /**
     * 删除库存管理
     */
    @RequiresPermissions("his:inventory:remove")
    @Log(title = "库存管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hisInventoryService.deleteHisInventoryByInvIds(ids));
    }
}
