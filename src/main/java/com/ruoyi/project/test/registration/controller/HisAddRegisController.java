package com.ruoyi.project.test.registration.controller;

import com.ruoyi.framework.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 新增挂号Controller
 */
@Controller
@RequestMapping("/test/registration")
public class HisAddRegisController extends BaseController {

    private final String prefix = "test/registration";

    /**
     * 访问"/test/registration"时跳转到"/add"
     */
    @GetMapping()
    public String add()
    {
        return prefix + "/add";
    }


}
