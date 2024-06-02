package com.ruoyi.project.his.diagnosis.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 诊断信息,
 * 用于接收从处方录入面板传回的信息
 *
 * @author SteveMMMy
 */
public class HisPatientRecord extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 患者编号 */
    private Long patientId;

    /** 姓名 */
    private String patientName;

    /** 手机号 */
    private String patientPhoneNum;

    /** 性别 */
    private Long patientSex;

    /** 身份证号 */
    private String patientIdCardNum;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date patientBirthDate;

    /** 年龄 */
    private Long patientAge;

    /** 医保卡号 */
    private String patientMedCardNum;

    /** 主诉 */
    private String recChiefComplaint;

    /** 诊断 */
    private String regDiagnosis;

    /** 处理意见 */
    private String regNotes;

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

    public String getPatientPhoneNum() {
        return patientPhoneNum;
    }

    public void setPatientPhoneNum(String patientPhoneNum) {
        this.patientPhoneNum = patientPhoneNum;
    }

    public Long getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(Long patientSex) {
        this.patientSex = patientSex;
    }

    public String getPatientIdCardNum() {
        return patientIdCardNum;
    }

    public void setPatientIdCardNum(String patientIdCardNum) {
        this.patientIdCardNum = patientIdCardNum;
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

    public String getPatientMedCardNum() {
        return patientMedCardNum;
    }

    public void setPatientMedCardNum(String patientMedCardNum) {
        this.patientMedCardNum = patientMedCardNum;
    }

    public String getRecChiefComplaint() {
        return recChiefComplaint;
    }

    public void setRecChiefComplaint(String recChiefComplaint) {
        this.recChiefComplaint = recChiefComplaint;
    }

    public String getRegDiagnosis() {
        return regDiagnosis;
    }

    public void setRegDiagnosis(String regDiagnosis) {
        this.regDiagnosis = regDiagnosis;
    }

    public String getRegNotes() {
        return regNotes;
    }

    public void setRegNotes(String regNotes) {
        this.regNotes = regNotes;
    }

    @Override
    public String toString() {
        return "HisPatientRecord{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", patientPhoneNum='" + patientPhoneNum + '\'' +
                ", patientSex=" + patientSex +
                ", patientIdCardNum='" + patientIdCardNum + '\'' +
                ", patientBirthDate=" + patientBirthDate +
                ", patientAge=" + patientAge +
                ", patientMedCardNum='" + patientMedCardNum + '\'' +
                ", recChiefComplaint='" + recChiefComplaint + '\'' +
                ", regDiagnosis='" + regDiagnosis + '\'' +
                ", regNotes='" + regNotes + '\'' +
                '}';
    }
}
