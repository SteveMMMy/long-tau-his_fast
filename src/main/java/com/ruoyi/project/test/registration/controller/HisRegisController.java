package com.ruoyi.project.test.registration.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.test.registration.domain.HisAppointment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 新增挂号Controller
 */
@Controller
@RequestMapping("/test/registration")
public class HisRegisController extends BaseController {

    private final String prefix = "test/registration";

    /**
     * 访问"/test/registration"时跳转到"/add"
     */
    @GetMapping()
    public String add()
    {
        return prefix + "/add";
    }

    @PostMapping("/add/appointment")
    public AjaxResult addAppointment(@RequestBody HisAppointment hisAppointment) {

        return toAjax(0);
    }
}
