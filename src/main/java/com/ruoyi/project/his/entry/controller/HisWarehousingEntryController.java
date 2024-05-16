package com.ruoyi.project.his.entry.controller;

import java.util.List;

import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.his.entry.domain.HisEntrySchedules;
import com.ruoyi.project.his.inventory.controller.HisInventoryController;
import com.ruoyi.project.his.inventory.domain.HisInventory;
import com.ruoyi.project.his.inventory.service.IHisInventoryService;
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
import com.ruoyi.project.his.entry.domain.HisWarehousingEntry;
import com.ruoyi.project.his.entry.service.IHisWarehousingEntryService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 入库单Controller
 * 
 * @author SteveMMMy
 * @date 2024-05-14
 */
@Controller
@RequestMapping("/his/entry")
public class HisWarehousingEntryController extends BaseController
{
    private String prefix = "his/entry";

    @Autowired
    private IHisWarehousingEntryService hisWarehousingEntryService;

    @Autowired
    private IHisInventoryService hisInventoryService;

    @RequiresPermissions("his:entry:view")
    @GetMapping()
    public String entry()
    {
        return prefix + "/entry";
    }

    @GetMapping("/select")
    public String selectPurOrders() {
        return prefix + "/select";
    }

    /**
     * 查询入库单列表
     */
    @RequiresPermissions("his:entry:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HisWarehousingEntry hisWarehousingEntry)
    {
        startPage();
        List<HisWarehousingEntry> list = hisWarehousingEntryService.selectHisWarehousingEntryList(hisWarehousingEntry);
        return getDataTable(list);
    }

    /**
     * 导出入库单列表
     */
    @RequiresPermissions("his:entry:export")
    @Log(title = "入库单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HisWarehousingEntry hisWarehousingEntry)
    {
        List<HisWarehousingEntry> list = hisWarehousingEntryService.selectHisWarehousingEntryList(hisWarehousingEntry);
        ExcelUtil<HisWarehousingEntry> util = new ExcelUtil<HisWarehousingEntry>(HisWarehousingEntry.class);
        return util.exportExcel(list, "入库单数据");
    }

    /**
     * 新增入库单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存入库单
     */
    @RequiresPermissions("his:entry:add")
    @Log(title = "入库单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HisWarehousingEntry hisWarehousingEntry)
    {
        // 插入入库单和明细
        hisWarehousingEntry.setUserId(ShiroUtils.getSysUser().getUserId());
        int rows = hisWarehousingEntryService.insertHisWarehousingEntry(hisWarehousingEntry);

        // 插入库存
        List<HisEntrySchedules> hisEntrySchedulesList = hisWarehousingEntry.getHisEntrySchedulesList();
        for (HisEntrySchedules hisEntrySchedules : hisEntrySchedulesList) {
            HisInventory hisInventory = getHisInventory(hisEntrySchedules);

            // 查找要插入的药品ID和生产批号
            HisInventory inv = new HisInventory();
            inv.setCatId(hisInventory.getCatId());
            inv.setInvBatchNumber(hisInventory.getInvBatchNumber());
            List<HisInventory> inventoryList = hisInventoryService.selectHisInventoryList(inv);

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
        }

        return toAjax(rows);
    }

    private static HisInventory getHisInventory(HisEntrySchedules hisEntrySchedules) {
        HisInventory hisInventory = new HisInventory();
        hisInventory.setCatId(hisEntrySchedules.getCatId());
        hisInventory.setInvBatchNumber(hisEntrySchedules.getEntSchBatchNumber());
        hisInventory.setInvNumber(hisEntrySchedules.getEntSchNum());
        hisInventory.setInvUnitPrice(hisEntrySchedules.getEntSchUnitPrice());
        hisInventory.setInvProdDate(hisEntrySchedules.getEntSchProdDate());
        hisInventory.setInvValidTo(hisEntrySchedules.getEntSchValidTo());
        return hisInventory;
    }

    /**
     * 修改入库单
     */
    @RequiresPermissions("his:entry:edit")
    @GetMapping("/edit/{entId}")
    public String edit(@PathVariable("entId") Long entId, ModelMap mmap)
    {
        HisWarehousingEntry hisWarehousingEntry = hisWarehousingEntryService.selectHisWarehousingEntryByEntId(entId);
        mmap.put("hisWarehousingEntry", hisWarehousingEntry);
        return prefix + "/edit";
    }

    /**
     * 修改保存入库单
     */
    @RequiresPermissions("his:entry:edit")
    @Log(title = "入库单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HisWarehousingEntry hisWarehousingEntry)
    {
        return toAjax(hisWarehousingEntryService.updateHisWarehousingEntry(hisWarehousingEntry));
    }

    /**
     * 删除入库单
     */
    @RequiresPermissions("his:entry:remove")
    @Log(title = "入库单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hisWarehousingEntryService.deleteHisWarehousingEntryByEntIds(ids));
    }
}
