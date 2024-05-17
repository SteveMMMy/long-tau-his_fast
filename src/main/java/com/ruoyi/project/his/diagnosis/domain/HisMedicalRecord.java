package com.ruoyi.project.his.diagnosis.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 病历对象 his_medical_record
 * 
 * @author SteveMMMy
 * @date 2024-05-17
 */
public class HisMedicalRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录ID */
    private Long recId;

    /** 患者编号 */
    @Excel(name = "患者编号")
    private Long patientId;

    /** 时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recTime;

    /** 主诉 */
    @Excel(name = "主诉")
    private String recChiefComplaint;

    /** 诊断 */
    @Excel(name = "诊断")
    private String regDiagnosis;

    /** 处理意见 */
    @Excel(name = "处理意见")
    private String regNotes;

    public void setRecId(Long recId) 
    {
        this.recId = recId;
    }

    public Long getRecId() 
    {
        return recId;
    }
    public void setPatientId(Long patientId) 
    {
        this.patientId = patientId;
    }

    public Long getPatientId() 
    {
        return patientId;
    }
    public void setRecTime(Date recTime) 
    {
        this.recTime = recTime;
    }

    public Date getRecTime() 
    {
        return recTime;
    }
    public void setRecChiefComplaint(String recChiefComplaint) 
    {
        this.recChiefComplaint = recChiefComplaint;
    }

    public String getRecChiefComplaint() 
    {
        return recChiefComplaint;
    }
    public void setRegDiagnosis(String regDiagnosis) 
    {
        this.regDiagnosis = regDiagnosis;
    }

    public String getRegDiagnosis() 
    {
        return regDiagnosis;
    }
    public void setRegNotes(String regNotes) 
    {
        this.regNotes = regNotes;
    }

    public String getRegNotes() 
    {
        return regNotes;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recId", getRecId())
            .append("patientId", getPatientId())
            .append("recTime", getRecTime())
            .append("recChiefComplaint", getRecChiefComplaint())
            .append("regDiagnosis", getRegDiagnosis())
            .append("regNotes", getRegNotes())
            .toString();
    }
}
