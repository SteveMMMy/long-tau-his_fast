package com.ruoyi.project.test.registration.controller;

import com.ruoyi.framework.interceptor.annotation.RepeatSubmit;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.test.registration.domain.HisAppointment;
import com.ruoyi.project.test.registration.domain.HisPatients;
import com.ruoyi.project.test.registration.domain.HisRegisters;
import com.ruoyi.project.test.registration.service.IHisPatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 新增挂号Controller
 */
@Controller
@RequestMapping("/test/registration")
public class HisRegisController extends BaseController {

    private final String prefix = "test/registration";

    @Autowired
    private IHisPatientsService hisPatientsService;

    /**
     * 访问"/test/registration"时跳转到"/add"
     */
    @GetMapping()
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增挂号：
     * 插入患者信息和挂号信息
     */
    @RepeatSubmit
    @PostMapping("/add/appointment")
    public ResponseEntity<Map<String, Object>> addAppointment(@RequestBody HisAppointment hisAppointment) {
        // 插入患者信息和挂号信息
        HisPatients hisPatients = getHisPatientsInfo(hisAppointment);

        Map<String, Object> response = new HashMap<>();
        try {
            hisPatientsService.insertHisPatients(hisPatients);
            response.put("status", "success");
            response.put("message", "挂号成功");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "挂号失败: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    private static HisPatients getHisPatientsInfo(HisAppointment hisAppointment) {
        // 给hisPatients对象插入患者信息
        HisPatients hisPatients = new HisPatients();
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
