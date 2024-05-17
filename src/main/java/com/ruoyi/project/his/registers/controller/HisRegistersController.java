package com.ruoyi.project.his.registers.controller;

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
import com.ruoyi.project.his.registers.domain.HisRegisters;
import com.ruoyi.project.his.registers.service.IHisRegistersService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 挂号记录Controller
 * 
 * @author SteveMMMy
 * @date 2024-05-17
 */
@Controller
@RequestMapping("/his/registers")
public class HisRegistersController extends BaseController
{
    private String prefix = "his/registers";

    @Autowired
    private IHisRegistersService hisRegistersService;

    @RequiresPermissions("his:registers:view")
    @GetMapping()
    public String registers()
    {
        return prefix + "/registers";
    }

    /**
     * 查询挂号记录列表
     */
    @RequiresPermissions("his:registers:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HisRegisters hisRegisters)
    {
        startPage();
        List<HisRegisters> list = hisRegistersService.selectHisRegistersList(hisRegisters);
        return getDataTable(list);
    }

    /**
     * 导出挂号记录列表
     */
    @RequiresPermissions("his:registers:export")
    @Log(title = "挂号记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HisRegisters hisRegisters)
    {
        List<HisRegisters> list = hisRegistersService.selectHisRegistersList(hisRegisters);
        ExcelUtil<HisRegisters> util = new ExcelUtil<HisRegisters>(HisRegisters.class);
        return util.exportExcel(list, "挂号记录数据");
    }

    /**
     * 新增挂号记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存挂号记录
     */
    @RequiresPermissions("his:registers:add")
    @Log(title = "挂号记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HisRegisters hisRegisters)
    {
        return toAjax(hisRegistersService.insertHisRegisters(hisRegisters));
    }

    /**
     * 修改挂号记录
     */
    @RequiresPermissions("his:registers:edit")
    @GetMapping("/edit/{regId}")
    public String edit(@PathVariable("regId") Long regId, ModelMap mmap)
    {
        HisRegisters hisRegisters = hisRegistersService.selectHisRegistersByRegId(regId);
        mmap.put("hisRegisters", hisRegisters);
        return prefix + "/edit";
    }

    /**
     * 修改保存挂号记录
     */
    @RequiresPermissions("his:registers:edit")
    @Log(title = "挂号记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HisRegisters hisRegisters)
    {
        return toAjax(hisRegistersService.updateHisRegisters(hisRegisters));
    }

    /**
     * 删除挂号记录
     */
    @RequiresPermissions("his:registers:remove")
    @Log(title = "挂号记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hisRegistersService.deleteHisRegistersByRegIds(ids));
    }
}
