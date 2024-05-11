package com.ruoyi.project.his.catalogue.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.his.catalogue.domain.HisDrugCatalogue;
import com.ruoyi.project.his.catalogue.service.IHisDrugCatalogueService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 药品目录Controller
 * 
 * @author SteveMMMy
 * @date 2024-05-01
 */
@Controller
@RequestMapping("/his/catalogue")
public class HisDrugCatalogueController extends BaseController
{
    private String prefix = "his/catalogue";

    @Autowired
    private IHisDrugCatalogueService hisDrugCatalogueService;

    @RequiresPermissions("his:catalogue:view")
    @GetMapping()
    public String catalogue()
    {
        return prefix + "/catalogue";
    }

    /**
     * 查询药品目录列表
     */
    @RequiresPermissions("his:catalogue:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HisDrugCatalogue hisDrugCatalogue)
    {
        startPage();
        List<HisDrugCatalogue> list = hisDrugCatalogueService.selectHisDrugCatalogueList(hisDrugCatalogue);
        return getDataTable(list);
    }

    /**
     * 查询药品目录列表（返回数据）
     */
    @PostMapping("/search_list")
    public ResponseEntity<List<HisDrugCatalogue>> searchList() {
        HisDrugCatalogue hisDrugCatalogue = new HisDrugCatalogue();
        List<HisDrugCatalogue> list = hisDrugCatalogueService.selectHisDrugCatalogueList(hisDrugCatalogue);

        return ResponseEntity.ok(list);
    }

    /**
     * 导出药品目录列表
     */
    @RequiresPermissions("his:catalogue:export")
    @Log(title = "药品目录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HisDrugCatalogue hisDrugCatalogue)
    {
        List<HisDrugCatalogue> list = hisDrugCatalogueService.selectHisDrugCatalogueList(hisDrugCatalogue);
        ExcelUtil<HisDrugCatalogue> util = new ExcelUtil<HisDrugCatalogue>(HisDrugCatalogue.class);
        return util.exportExcel(list, "药品目录数据");
    }

    /**
     * 新增药品目录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存药品目录
     */
    @RequiresPermissions("his:catalogue:add")
    @Log(title = "药品目录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HisDrugCatalogue hisDrugCatalogue)
    {
        return toAjax(hisDrugCatalogueService.insertHisDrugCatalogue(hisDrugCatalogue));
    }

    /**
     * 修改药品目录
     */
    @RequiresPermissions("his:catalogue:edit")
    @GetMapping("/edit/{catId}")
    public String edit(@PathVariable("catId") Long catId, ModelMap mmap)
    {
        HisDrugCatalogue hisDrugCatalogue = hisDrugCatalogueService.selectHisDrugCatalogueByCatId(catId);
        mmap.put("hisDrugCatalogue", hisDrugCatalogue);
        return prefix + "/edit";
    }

    /**
     * 修改保存药品目录
     */
    @RequiresPermissions("his:catalogue:edit")
    @Log(title = "药品目录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HisDrugCatalogue hisDrugCatalogue)
    {
        return toAjax(hisDrugCatalogueService.updateHisDrugCatalogue(hisDrugCatalogue));
    }

    /**
     * 删除药品目录
     */
    @RequiresPermissions("his:catalogue:remove")
    @Log(title = "药品目录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hisDrugCatalogueService.deleteHisDrugCatalogueByCatIds(ids));
    }
}
