package com.ruoyi.project.test.patients.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 挂号记录对象 his_registers
 * 
 * @author SteveMMMy
 * @date 2024-04-19
 */
public class HisRegisters extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录编号 */
    private Long regId;

    /** 患者编号 */
    @Excel(name = "患者编号")
    private Long patientId;

    /** 挂号日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "挂号日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date regTime;

    /** 挂号时段 */
    @Excel(name = "挂号时段")
    private Long regPeriod;

    /** 挂号状态 */
    @Excel(name = "挂号状态")
    private Long regStatus;

    public void setRegId(Long regId) 
    {
        this.regId = regId;
    }

    public Long getRegId() 
    {
        return regId;
    }
    public void setPatientId(Long patientId) 
    {
        this.patientId = patientId;
    }

    public Long getPatientId() 
    {
        return patientId;
    }
    public void setRegTime(Date regTime) 
    {
        this.regTime = regTime;
    }

    public Date getRegTime() 
    {
        return regTime;
    }
    public void setRegPeriod(Long regPeriod) 
    {
        this.regPeriod = regPeriod;
    }

    public Long getRegPeriod() 
    {
        return regPeriod;
    }
    public void setRegStatus(Long regStatus) 
    {
        this.regStatus = regStatus;
    }

    public Long getRegStatus() 
    {
        return regStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("regId", getRegId())
            .append("patientId", getPatientId())
            .append("regTime", getRegTime())
            .append("regPeriod", getRegPeriod())
            .append("regStatus", getRegStatus())
            .toString();
    }
}
