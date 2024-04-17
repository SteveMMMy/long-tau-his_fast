package com.ruoyi.project.test.batchNumbers.controller;

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
import com.ruoyi.project.test.batchNumbers.domain.HisBatchNumbers;
import com.ruoyi.project.test.batchNumbers.service.IHisBatchNumbersService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 生产批号Controller
 * 
 * @author SteveMMMy
 * @date 2024-04-13
 */
@Controller
@RequestMapping("/test/batchNumbers")
public class HisBatchNumbersController extends BaseController
{
    private String prefix = "test/batchNumbers";

    @Autowired
    private IHisBatchNumbersService hisBatchNumbersService;

    @RequiresPermissions("test:batchNumbers:view")
    @GetMapping()
    public String batchNumbers()
    {
        return prefix + "/batchNumbers";
    }

    /**
     * 查询生产批号列表
     */
    @RequiresPermissions("test:batchNumbers:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HisBatchNumbers hisBatchNumbers)
    {
        startPage();
        List<HisBatchNumbers> list = hisBatchNumbersService.selectHisBatchNumbersList(hisBatchNumbers);
        return getDataTable(list);
    }

    /**
     * 导出生产批号列表
     */
    @RequiresPermissions("test:batchNumbers:export")
    @Log(title = "生产批号", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HisBatchNumbers hisBatchNumbers)
    {
        List<HisBatchNumbers> list = hisBatchNumbersService.selectHisBatchNumbersList(hisBatchNumbers);
        ExcelUtil<HisBatchNumbers> util = new ExcelUtil<HisBatchNumbers>(HisBatchNumbers.class);
        return util.exportExcel(list, "生产批号数据");
    }

    /**
     * 新增生产批号
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存生产批号
     */
    @RequiresPermissions("test:batchNumbers:add")
    @Log(title = "生产批号", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HisBatchNumbers hisBatchNumbers)
    {
        return toAjax(hisBatchNumbersService.insertHisBatchNumbers(hisBatchNumbers));
    }

    /**
     * 修改生产批号
     */
    @RequiresPermissions("test:batchNumbers:edit")
    @GetMapping("/edit/{batchNumber}")
    public String edit(@PathVariable("batchNumber") String batchNumber, ModelMap mmap)
    {
        HisBatchNumbers hisBatchNumbers = hisBatchNumbersService.selectHisBatchNumbersByBatchNumber(batchNumber);
        mmap.put("hisBatchNumbers", hisBatchNumbers);
        return prefix + "/edit";
    }

    /**
     * 修改保存生产批号
     */
    @RequiresPermissions("test:batchNumbers:edit")
    @Log(title = "生产批号", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HisBatchNumbers hisBatchNumbers)
    {
        return toAjax(hisBatchNumbersService.updateHisBatchNumbers(hisBatchNumbers));
    }

    /**
     * 删除生产批号
     */
    @RequiresPermissions("test:batchNumbers:remove")
    @Log(title = "生产批号", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hisBatchNumbersService.deleteHisBatchNumbersByBatchNumbers(ids));
    }
}
