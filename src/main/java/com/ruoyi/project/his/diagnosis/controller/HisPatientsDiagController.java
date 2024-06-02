package com.ruoyi.project.his.diagnosis.controller;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.ruoyi.framework.interceptor.annotation.RepeatSubmit;
import com.ruoyi.project.his.diagnosis.domain.HisMedicalRecord;
import com.ruoyi.project.his.diagnosis.domain.HisPatientRecord;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.his.diagnosis.domain.HisPatientsDiag;
import com.ruoyi.project.his.diagnosis.service.IHisPatientsDiagService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 患者病历Controller
 * 
 * @author SteveMMMy
 * @date 2024-05-17
 */
@Controller
@RequestMapping("/his/diagnosis")
public class HisPatientsDiagController extends BaseController
{
    private String prefix = "his/diagnosis";

    @Autowired
    private IHisPatientsDiagService hisPatientsDiagService;

    @RequiresPermissions("his:diagnosis:view")
    @GetMapping()
    public String diagnosis()
    {
        return prefix + "/diagnosis";
    }

    /**
     * 查询患者病历列表
     */
    @RequiresPermissions("his:diagnosis:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HisPatientsDiag hisPatientsDiag)
    {
        startPage();
        List<HisPatientsDiag> list = hisPatientsDiagService.selectHisPatientsDiagList(hisPatientsDiag);
        return getDataTable(list);
    }

    /**
     * 导出患者病历列表
     */
    @RequiresPermissions("his:diagnosis:export")
    @Log(title = "患者病历", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HisPatientsDiag hisPatientsDiag)
    {
        List<HisPatientsDiag> list = hisPatientsDiagService.selectHisPatientsDiagList(hisPatientsDiag);
        ExcelUtil<HisPatientsDiag> util = new ExcelUtil<HisPatientsDiag>(HisPatientsDiag.class);
        return util.exportExcel(list, "患者病历数据");
    }

    /**
     * 新增患者病历
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存患者病历
     */
    @RequiresPermissions("his:diagnosis:add")
    @Log(title = "患者病历", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HisPatientsDiag hisPatientsDiag)
    {
        return toAjax(hisPatientsDiagService.insertHisPatientsDiag(hisPatientsDiag));
    }

    /**
     * 新增已有患者诊断（用于处方录入面板）
     */
    @RepeatSubmit
    @RequiresPermissions("his:diagnosis:add")
    @Log(title = "患者诊断", businessType = BusinessType.INSERT)
    @PostMapping("/add_rec")
    @ResponseBody
    public AjaxResult addRecord(@RequestBody HisPatientRecord hisPatientRecord) {

        HisPatientsDiag hisPatientsDiag = new HisPatientsDiag();
        hisPatientsDiag.setPatientId(hisPatientRecord.getPatientId());
        hisPatientsDiag.setPatientName(hisPatientRecord.getPatientName());
        hisPatientsDiag.setPatientPhoneNum(hisPatientRecord.getPatientPhoneNum());
        hisPatientsDiag.setPatientSex(hisPatientRecord.getPatientSex());
        hisPatientsDiag.setPatientIdCardNum(hisPatientRecord.getPatientIdCardNum());
        hisPatientsDiag.setPatientBirthDate(hisPatientRecord.getPatientBirthDate());
        hisPatientsDiag.setPatientAge(hisPatientRecord.getPatientAge());
        hisPatientsDiag.setPatientMedCardNum(hisPatientRecord.getPatientMedCardNum());

        HisMedicalRecord hisMedicalRecord = new HisMedicalRecord();
        hisMedicalRecord.setPatientId(hisPatientRecord.getPatientId());
        hisMedicalRecord.setRecTime(new Date());
        hisMedicalRecord.setRecChiefComplaint(hisPatientRecord.getRecChiefComplaint());
        hisMedicalRecord.setRegDiagnosis(hisPatientRecord.getRegDiagnosis());
        hisMedicalRecord.setRegNotes(hisPatientRecord.getRegNotes());

        // 将 HisMedicalRecord 对象添加到 HisPatientsDiag 对象的记录列表中
        hisPatientsDiag.setHisMedicalRecordList(Collections.singletonList(hisMedicalRecord));

        hisPatientsDiagService.insertHisDiagByPatient(hisPatientsDiag);
        return success();
    }

    /**
     * 修改患者病历
     */
    @RequiresPermissions("his:diagnosis:edit")
    @GetMapping("/edit/{patientId}")
    public String edit(@PathVariable("patientId") Long patientId, ModelMap mmap)
    {
        HisPatientsDiag hisPatientsDiag = hisPatientsDiagService.selectHisPatientsDiagByPatientId(patientId);
        mmap.put("hisPatientsDiag", hisPatientsDiag);
        return prefix + "/edit";
    }

    /**
     * 修改保存患者病历
     */
    @RequiresPermissions("his:diagnosis:edit")
    @Log(title = "患者病历", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HisPatientsDiag hisPatientsDiag)
    {
        return toAjax(hisPatientsDiagService.updateHisPatientsDiag(hisPatientsDiag));
    }

    /**
     * 删除患者病历
     */
    @RequiresPermissions("his:diagnosis:remove")
    @Log(title = "患者病历", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hisPatientsDiagService.deleteHisPatientsDiagByPatientIds(ids));
    }
}
