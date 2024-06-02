package com.ruoyi.project.his.prescriptions.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 处方明细对象 his_prescriptions_schedules
 * 
 * @author SteveMMMy
 * @date 2024-05-17
 */
public class HisPrescriptionsSchedules extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 明细号 */
    private Long prscSchId;

    /** 处方ID */
    @Excel(name = "处方ID")
    private Long prscId;

    /** 药品ID */
    @Excel(name = "药品ID")
    private Long catId;

    /** 批准文号 */
    @Excel(name = "批准文号")
    private String catApprovalNumber;

    /** 药品编号 */
    @Excel(name = "药品编号")
    private String catDrugNum;

    /** 通用名或商品名 */
    @Excel(name = "通用名或商品名")
    private String catName;

    /** 英文名称 */
    @Excel(name = "英文名称")
    private String catEnglishName;

    /** 生产单位 */
    @Excel(name = "生产单位")
    private String catProducer;

    /** 规格 */
    @Excel(name = "规格")
    private String catSpecs;

    /** 剂型 */
    @Excel(name = "剂型")
    private Long catDosageForm;

    /** 包装 */
    @Excel(name = "包装")
    private String catPackage;

    /** 单位 */
    @Excel(name = "单位")
    private Long catUnit;

    /** 数量 */
    @Excel(name = "数量")
    private Long prscSchQuantity;

    /** 用法 */
    @Excel(name = "用法")
    private Long prscSchUsage;

    /** 频次 */
    @Excel(name = "频次")
    private Long prscSchFreq;

    /** 自备 */
    @Excel(name = "自备")
    private Integer prscSchIsSelfPrepared;

    /** 单价 */
    @Excel(name = "单价")
    private Long prscSchUnitPrice;

    /** 生产批号 */
    @Excel(name = "生产批号")
    private String invBatchNumber;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private Long invNumber;

    public void setPrscSchId(Long prscSchId) 
    {
        this.prscSchId = prscSchId;
    }

    public Long getPrscSchId() 
    {
        return prscSchId;
    }
    public void setPrscId(Long prscId) 
    {
        this.prscId = prscId;
    }

    public Long getPrscId() 
    {
        return prscId;
    }
    public void setCatId(Long catId) 
    {
        this.catId = catId;
    }

    public Long getCatId() 
    {
        return catId;
    }

    public String getCatApprovalNumber() {
        return catApprovalNumber;
    }

    public void setCatApprovalNumber(String catApprovalNumber) {
        this.catApprovalNumber = catApprovalNumber;
    }

    public String getCatDrugNum() {
        return catDrugNum;
    }

    public void setCatDrugNum(String catDrugNum) {
        this.catDrugNum = catDrugNum;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatEnglishName() {
        return catEnglishName;
    }

    public void setCatEnglishName(String catEnglishName) {
        this.catEnglishName = catEnglishName;
    }

    public String getCatProducer() {
        return catProducer;
    }

    public void setCatProducer(String catProducer) {
        this.catProducer = catProducer;
    }

    public String getCatSpecs() {
        return catSpecs;
    }

    public void setCatSpecs(String catSpecs) {
        this.catSpecs = catSpecs;
    }

    public Long getCatDosageForm() {
        return catDosageForm;
    }

    public void setCatDosageForm(Long catDosageForm) {
        this.catDosageForm = catDosageForm;
    }

    public String getCatPackage() {
        return catPackage;
    }

    public void setCatPackage(String catPackage) {
        this.catPackage = catPackage;
    }

    public String getInvBatchNumber() {
        return invBatchNumber;
    }

    public void setInvBatchNumber(String invBatchNumber) {
        this.invBatchNumber = invBatchNumber;
    }

    public Long getCatUnit() {
        return catUnit;
    }

    public void setCatUnit(Long catUnit) {
        this.catUnit = catUnit;
    }
    public void setPrscSchQuantity(Long prscSchQuantity) 
    {
        this.prscSchQuantity = prscSchQuantity;
    }

    public Long getPrscSchQuantity() 
    {
        return prscSchQuantity;
    }
    public void setPrscSchUsage(Long prscSchUsage) 
    {
        this.prscSchUsage = prscSchUsage;
    }

    public Long getPrscSchUsage() 
    {
        return prscSchUsage;
    }
    public void setPrscSchFreq(Long prscSchFreq) 
    {
        this.prscSchFreq = prscSchFreq;
    }

    public Long getPrscSchFreq() 
    {
        return prscSchFreq;
    }
    public void setPrscSchIsSelfPrepared(Integer prscSchIsSelfPrepared) 
    {
        this.prscSchIsSelfPrepared = prscSchIsSelfPrepared;
    }

    public Integer getPrscSchIsSelfPrepared() 
    {
        return prscSchIsSelfPrepared;
    }
    public void setPrscSchUnitPrice(Long prscSchUnitPrice) 
    {
        this.prscSchUnitPrice = prscSchUnitPrice;
    }

    public Long getPrscSchUnitPrice() 
    {
        return prscSchUnitPrice;
    }

    public Long getInvNumber() {
        return invNumber;
    }

    public void setInvNumber(Long invNumber) {
        this.invNumber = invNumber;
    }

    @Override
    public String toString() {
        return "HisPrescriptionsSchedules{" +
                "prscSchId=" + prscSchId +
                ", prscId=" + prscId +
                ", catId=" + catId +
                ", catApprovalNumber='" + catApprovalNumber + '\'' +
                ", catDrugNum='" + catDrugNum + '\'' +
                ", catName='" + catName + '\'' +
                ", catEnglishName='" + catEnglishName + '\'' +
                ", catProducer='" + catProducer + '\'' +
                ", catSpecs='" + catSpecs + '\'' +
                ", catDosageForm=" + catDosageForm +
                ", catPackage='" + catPackage + '\'' +
                ", catUnit=" + catUnit +
                ", prscSchQuantity=" + prscSchQuantity +
                ", prscSchUsage=" + prscSchUsage +
                ", prscSchFreq=" + prscSchFreq +
                ", prscSchIsSelfPrepared=" + prscSchIsSelfPrepared +
                ", prscSchUnitPrice=" + prscSchUnitPrice +
                ", invBatchNumber='" + invBatchNumber + '\'' +
                ", invNumber=" + invNumber +
                '}';
    }
}
