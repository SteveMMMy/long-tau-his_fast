package com.ruoyi.project.test.producers.controller;

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
import com.ruoyi.project.test.producers.domain.HisProducers;
import com.ruoyi.project.test.producers.service.IHisProducersService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 生产商Controller
 * 
 * @author SteveMMMy
 * @date 2024-04-13
 */
@Controller
@RequestMapping("/test/producers")
public class HisProducersController extends BaseController
{
    private String prefix = "test/producers";

    @Autowired
    private IHisProducersService hisProducersService;

    @RequiresPermissions("test:producers:view")
    @GetMapping()
    public String producers()
    {
        return prefix + "/producers";
    }

    /**
     * 查询生产商列表
     */
    @RequiresPermissions("test:producers:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HisProducers hisProducers)
    {
        startPage();
        List<HisProducers> list = hisProducersService.selectHisProducersList(hisProducers);
        return getDataTable(list);
    }

    /**
     * 导出生产商列表
     */
    @RequiresPermissions("test:producers:export")
    @Log(title = "生产商", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HisProducers hisProducers)
    {
        List<HisProducers> list = hisProducersService.selectHisProducersList(hisProducers);
        ExcelUtil<HisProducers> util = new ExcelUtil<HisProducers>(HisProducers.class);
        return util.exportExcel(list, "生产商数据");
    }

    /**
     * 新增生产商
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存生产商
     */
    @RequiresPermissions("test:producers:add")
    @Log(title = "生产商", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HisProducers hisProducers)
    {
        return toAjax(hisProducersService.insertHisProducers(hisProducers));
    }

    /**
     * 修改生产商
     */
    @RequiresPermissions("test:producers:edit")
    @GetMapping("/edit/{pdcNumber}")
    public String edit(@PathVariable("pdcNumber") Long pdcNumber, ModelMap mmap)
    {
        HisProducers hisProducers = hisProducersService.selectHisProducersByPdcNumber(pdcNumber);
        mmap.put("hisProducers", hisProducers);
        return prefix + "/edit";
    }

    /**
     * 修改保存生产商
     */
    @RequiresPermissions("test:producers:edit")
    @Log(title = "生产商", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HisProducers hisProducers)
    {
        return toAjax(hisProducersService.updateHisProducers(hisProducers));
    }

    /**
     * 删除生产商
     */
    @RequiresPermissions("test:producers:remove")
    @Log(title = "生产商", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hisProducersService.deleteHisProducersByPdcNumbers(ids));
    }
}
