package com.ruoyi.project.test.patients.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 患者信息对象 his_patients
 * 
 * @author SteveMMMy
 * @date 2024-04-17
 */
public class HisPatients extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 患者编号 */
    private Long patientId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String patientName;

    /** 性别 */
    @Excel(name = "性别")
    private Long patientSex;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date patientBirthDate;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long patientAge;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String patientIdCardNum;

    /** 医保卡号 */
    @Excel(name = "医保卡号")
    private String patientMedCardNum;

    /** 手机号 */
    @Excel(name = "手机号")
    private String patientPhoneNum;

    public void setPatientId(Long patientId)
    {
        this.patientId = patientId;
    }

    public Long getPatientId()
    {
        return patientId;
    }
    public void setPatientName(String patientName)
    {
        this.patientName = patientName;
    }

    public String getPatientName()
    {
        return patientName;
    }
    public void setPatientSex(Long patientSex)
    {
        this.patientSex = patientSex;
    }

    public Long getPatientSex()
    {
        return patientSex;
    }
    public void setPatientBirthDate(Date patientBirthDate)
    {
        this.patientBirthDate = patientBirthDate;
    }

    public Date getPatientBirthDate()
    {
        return patientBirthDate;
    }
    public void setPatientAge(Long patientAge)
    {
        this.patientAge = patientAge;
    }

    public Long getPatientAge()
    {
        return patientAge;
    }
    public void setPatientIdCardNum(String patientIdCardNum)
    {
        this.patientIdCardNum = patientIdCardNum;
    }

    public String getPatientIdCardNum()
    {
        return patientIdCardNum;
    }
    public void setPatientMedCardNum(String patientMedCardNum)
    {
        this.patientMedCardNum = patientMedCardNum;
    }

    public String getPatientMedCardNum()
    {
        return patientMedCardNum;
    }
    public void setPatientPhoneNum(String patientPhoneNum)
    {
        this.patientPhoneNum = patientPhoneNum;
    }

    public String getPatientPhoneNum()
    {
        return patientPhoneNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("patientId", getPatientId())
            .append("patientName", getPatientName())
            .append("patientSex", getPatientSex())
            .append("patientBirthDate", getPatientBirthDate())
            .append("patientAge", getPatientAge())
            .append("patientIdCardNum", getPatientIdCardNum())
            .append("patientMedCardNum", getPatientMedCardNum())
            .append("patientPhoneNum", getPatientPhoneNum())
            .toString();
    }
}
