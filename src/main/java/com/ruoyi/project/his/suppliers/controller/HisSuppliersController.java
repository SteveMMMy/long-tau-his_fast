package com.ruoyi.project.his.suppliers.controller;

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
import com.ruoyi.project.his.suppliers.domain.HisSuppliers;
import com.ruoyi.project.his.suppliers.service.IHisSuppliersService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 供应商Controller
 *
 * @author SteveMMMy
 * @date 2024-05-01
 */
@Controller
@RequestMapping("/his/suppliers")
public class HisSuppliersController extends BaseController {
    private String prefix = "his/suppliers";

    @Autowired
    private IHisSuppliersService hisSuppliersService;

    @RequiresPermissions("his:suppliers:view")
    @GetMapping()
    public String suppliers() {
        return prefix + "/suppliers";
    }

    /**
     * 查询供应商列表
     */
    @RequiresPermissions("his:suppliers:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HisSuppliers hisSuppliers) {
        startPage();
        List<HisSuppliers> list = hisSuppliersService.selectHisSuppliersList(hisSuppliers);
        return getDataTable(list);
    }

    /**
     * 查询供应商列表（返回数据）
     */
    @RequiresPermissions("his:suppliers:list")
    @PostMapping("/search_list")
    public ResponseEntity<List<HisSuppliers>> searchList() {
        HisSuppliers hisSuppliers = new HisSuppliers();
        List<HisSuppliers> list = hisSuppliersService.selectHisSuppliersList(hisSuppliers);

        return ResponseEntity.ok(list);
    }

    /**
     * 导出供应商列表
     */
    @RequiresPermissions("his:suppliers:export")
    @Log(title = "供应商", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HisSuppliers hisSuppliers) {
        List<HisSuppliers> list = hisSuppliersService.selectHisSuppliersList(hisSuppliers);
        ExcelUtil<HisSuppliers> util = new ExcelUtil<HisSuppliers>(HisSuppliers.class);
        return util.exportExcel(list, "供应商数据");
    }

    /**
     * 新增供应商
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存供应商
     */
    @RequiresPermissions("his:suppliers:add")
    @Log(title = "供应商", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HisSuppliers hisSuppliers) {
        return toAjax(hisSuppliersService.insertHisSuppliers(hisSuppliers));
    }

    /**
     * 修改供应商
     */
    @RequiresPermissions("his:suppliers:edit")
    @GetMapping("/edit/{splId}")
    public String edit(@PathVariable("splId") Long splId, ModelMap mmap) {
        HisSuppliers hisSuppliers = hisSuppliersService.selectHisSuppliersBySplId(splId);
        mmap.put("hisSuppliers", hisSuppliers);
        return prefix + "/edit";
    }

    /**
     * 修改保存供应商
     */
    @RequiresPermissions("his:suppliers:edit")
    @Log(title = "供应商", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HisSuppliers hisSuppliers) {
        return toAjax(hisSuppliersService.updateHisSuppliers(hisSuppliers));
    }

    /**
     * 删除供应商
     */
    @RequiresPermissions("his:suppliers:remove")
    @Log(title = "供应商", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(hisSuppliersService.deleteHisSuppliersBySplIds(ids));
    }
}
