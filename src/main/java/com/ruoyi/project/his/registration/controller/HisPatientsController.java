package com.ruoyi.project.his.registration.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.his.registration.domain.HisPatients;
import com.ruoyi.project.his.registration.service.IHisPatientsService;
import com.ruoyi.project.his.suppliers.domain.HisSuppliers;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 患者信息Controller
 * 
 * @author SteveMMMy
 * @date 2024-04-26
 */
@Controller
@RequestMapping("/his/patients")
public class HisPatientsController extends BaseController
{
    private final String prefix = "his/patients";

    @Autowired
    private IHisPatientsService hisPatientsService;

    @RequiresPermissions("his:patients:view")
    @GetMapping()
    public String patients()
    {
        return prefix + "/patients";
    }

    /**
     * 查询患者信息列表
     */
    @RequiresPermissions("his:patients:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HisPatients hisPatients)
    {
        startPage();
        List<HisPatients> list = hisPatientsService.selectHisPatientsList(hisPatients);
        return getDataTable(list);
    }

    /**
     * 查询患者信息列表（返回数据）
     */
    @RequiresPermissions("his:patients:list")
    @PostMapping("/search_list")
    public ResponseEntity<List<HisPatients>> searchList() {
        HisPatients hisPatients = new HisPatients();
        List<HisPatients> list = hisPatientsService.selectHisPatientsList(hisPatients);

        return ResponseEntity.ok(list);
    }

    /**
     * 查询患者信息列表（返回List）
     */
    @RequiresPermissions("his:patients:list")
    @PostMapping("/search")
    @ResponseBody
    public List<HisPatients> search(HisPatients hisPatients) {
        return hisPatientsService.selectHisPatientsList(hisPatients);
    }

    /**
     * 导出患者信息列表
     */
    @RequiresPermissions("his:patients:export")
    @Log(title = "患者信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HisPatients hisPatients)
    {
        List<HisPatients> list = hisPatientsService.selectHisPatientsList(hisPatients);
        ExcelUtil<HisPatients> util = new ExcelUtil<HisPatients>(HisPatients.class);
        return util.exportExcel(list, "患者信息数据");
    }

    /**
     * 新增患者信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存患者信息
     */
    @RequiresPermissions("his:patients:add")
    @Log(title = "患者信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HisPatients hisPatients)
    {
        return toAjax(hisPatientsService.insertHisPatients(hisPatients));
    }

    /**
     * 修改患者信息
     */
    @RequiresPermissions("his:patients:edit")
    @GetMapping("/edit/{patientId}")
    public String edit(@PathVariable("patientId") Long patientId, ModelMap mmap)
    {
        HisPatients hisPatients = hisPatientsService.selectHisPatientsByPatientId(patientId);
        mmap.put("hisPatients", hisPatients);
        return prefix + "/edit";
    }

    /**
     * 修改保存患者信息
     */
    @RequiresPermissions("his:patients:edit")
    @Log(title = "患者信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HisPatients hisPatients)
    {
        return toAjax(hisPatientsService.updateHisPatients(hisPatients));
    }

    /**
     * 删除患者信息
     */
    @RequiresPermissions("his:patients:remove")
    @Log(title = "患者信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hisPatientsService.deleteHisPatientsByPatientIds(ids));
    }
}
