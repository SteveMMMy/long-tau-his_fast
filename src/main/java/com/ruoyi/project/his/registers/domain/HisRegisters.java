package com.ruoyi.project.his.registers.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 挂号记录对象 his_registers
 *
 * @author SteveMMMy
 * @date 2024-04-20
 */
public class HisRegisters extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录编号 */
    private Long regId;

    /** 患者编号 */
    @Excel(name = "患者编号")
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

    /** 医生编号 */
    @Excel(name = "医生编号")
    private Long workerId;

    /** 医生名称 */
    @Excel(name = "医生名称")
    private String workerName;

    /** 科室ID */
    @Excel(name = "科室ID")
    private Long deptId;

    /** 科室 */
    @Excel(name = "科室")
    private String deptName;

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
    public void setWorkerId(Long workerId)
    {
        this.workerId = workerId;
    }

    public Long getWorkerId()
    {
        return workerId;
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

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Long getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(Long patientSex) {
        this.patientSex = patientSex;
    }

    public Date getPatientBirthDate() {
        return patientBirthDate;
    }

    public void setPatientBirthDate(Date patientBirthDate) {
        this.patientBirthDate = patientBirthDate;
    }

    public Long getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Long patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientIdCardNum() {
        return patientIdCardNum;
    }

    public void setPatientIdCardNum(String patientIdCardNum) {
        this.patientIdCardNum = patientIdCardNum;
    }

    public String getPatientMedCardNum() {
        return patientMedCardNum;
    }

    public void setPatientMedCardNum(String patientMedCardNum) {
        this.patientMedCardNum = patientMedCardNum;
    }

    public String getPatientPhoneNum() {
        return patientPhoneNum;
    }

    public void setPatientPhoneNum(String patientPhoneNum) {
        this.patientPhoneNum = patientPhoneNum;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "HisRegisters{" +
                "regId=" + regId +
                ", patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", patientSex=" + patientSex +
                ", patientBirthDate=" + patientBirthDate +
                ", patientAge=" + patientAge +
                ", patientIdCardNum='" + patientIdCardNum + '\'' +
                ", patientMedCardNum='" + patientMedCardNum + '\'' +
                ", patientPhoneNum='" + patientPhoneNum + '\'' +
                ", workerId=" + workerId +
                ", workerName='" + workerName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", regTime=" + regTime +
                ", regPeriod=" + regPeriod +
                ", regStatus=" + regStatus +
                '}';
    }
}
