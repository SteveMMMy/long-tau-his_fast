package com.ruoyi.project.his.registration.controller;

import com.ruoyi.framework.interceptor.annotation.RepeatSubmit;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.his.registration.domain.HisAppointment;
import com.ruoyi.project.his.registration.domain.HisPatients;
import com.ruoyi.project.his.registration.domain.HisRegisters;
import com.ruoyi.project.his.registration.service.IHisPatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 新增挂号Controller
 *
 * @author SteveMMMy
 */
@Controller
@RequestMapping("/his/registration")
public class HisRegisController extends BaseController {

    private final String prefix = "his/registration";

    @Autowired
    private IHisPatientsService hisPatientsService;

    /**
     * 访问"/his/registration"时跳转到"/add"
     */
    @GetMapping()
    public String add()
    {
        return prefix + "/registration";
    }

    /**
     * 新增挂号：
     * 插入患者信息和挂号信息
     */
    @RepeatSubmit
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addAppointment(@RequestBody HisAppointment hisAppointment) {
        // 插入患者信息和挂号信息
        HisPatients hisPatients = getHisPatientsInfo(hisAppointment);

        // 若是已存在的患者信息，则直接插入挂号信息
        if (hisPatients.getPatientId() != null) {
            hisPatientsService.insertHisRegistersByPatient(hisPatients);
            return success();
        }

        // 若是新信息，检验身份证号是否唯一
        if (!hisPatientsService.checkIdCardNumUnique(hisPatients)) {
            return error("失败，身份证号已存在");
        }

        // 若唯一，则插入信息
        return toAjax(hisPatientsService.insertHisPatients(hisPatients));
    }

    private static HisPatients getHisPatientsInfo(HisAppointment hisAppointment) {
        // 给hisPatients对象插入患者信息
        HisPatients hisPatients = new HisPatients();
        hisPatients.setPatientId(hisAppointment.getPatientId());
        hisPatients.setPatientName(hisAppointment.getPatientName());
        hisPatients.setPatientSex(hisAppointment.getPatientSex());
        hisPatients.setPatientBirthDate(hisAppointment.getPatientBirthDate());
        hisPatients.setPatientAge(hisAppointment.getPatientAge());
        hisPatients.setPatientIdCardNum(hisAppointment.getPatientIdCardNum());
        hisPatients.setPatientMedCardNum(hisAppointment.getPatientMedCardNum());
        hisPatients.setPatientPhoneNum(hisAppointment.getPatientPhoneNum());

        // 给hisPatients对象插入挂号信息
        HisRegisters hisRegisters = new HisRegisters();
        hisRegisters.setWorkerId(hisAppointment.getWorkerId());
        hisRegisters.setRegTime(new Date());
        hisRegisters.setRegPeriod(hisAppointment.getRegPeriod());
        hisRegisters.setRegStatus(1L);

        List<HisRegisters> hisRegistersList = new ArrayList<>();
        hisRegistersList.add(hisRegisters);
        hisPatients.setHisRegistersList(hisRegistersList);

        return hisPatients;
    }
}
