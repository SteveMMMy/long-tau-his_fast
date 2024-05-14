package com.ruoyi.project.his.registration.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 挂号记录（包含患者信息和医生信息）,
 * 用于接收从前端传回的挂号信息
 *
 * @author SteveMMMy
 */
public class HisAppointment extends BaseEntity {

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

    /** 医生编号 */
    @Excel(name = "医生编号")
    private Long workerId;

    /** 挂号时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Excel(name = "挂号时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date regTime;

    /** 挂号时段 */
    @Excel(name = "挂号时段")
    private Long regPeriod;

    /** 挂号状态 */
    @Excel(name = "挂号状态")
    private Long regStatus;

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
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

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Long getRegPeriod() {
        return regPeriod;
    }

    public void setRegPeriod(Long regPeriod) {
        this.regPeriod = regPeriod;
    }

    public Long getRegStatus() {
        return regStatus;
    }

    public void setRegStatus(Long regStatus) {
        this.regStatus = regStatus;
    }

    @Override
    public String toString() {
        return "HisAppointment{" +
                "patientName='" + patientName + '\'' +
                ", patientSex=" + patientSex +
                ", patientBirthDate=" + patientBirthDate +
                ", patientAge=" + patientAge +
                ", patientIdCardNum='" + patientIdCardNum + '\'' +
                ", patientMedCardNum='" + patientMedCardNum + '\'' +
                ", patientPhoneNum='" + patientPhoneNum + '\'' +
                ", workerId=" + workerId +
                ", regTime=" + regTime +
                ", regPeriod=" + regPeriod +
                ", regStatus=" + regStatus +
                '}';
    }
}
