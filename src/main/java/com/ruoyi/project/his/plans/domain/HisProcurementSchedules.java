package com.ruoyi.project.his.plans.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 采购计划明细对象 his_procurement_schedules
 * 
 * @author SteveMMMy
 * @date 2024-05-01
 */
public class HisProcurementSchedules extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 明细号 */
    private Long pschId;

    /** 采购计划表ID */
    @Excel(name = "采购计划表ID")
    private Long prcpId;

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

    /** 药品英文名 */
    @Excel(name = "药品英文名")
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

    /** 参考单价 */
    @Excel(name = "参考单价")
    private Long pschPrice;

    /** 采购数量 */
    @Excel(name = "采购数量")
    private Long pschNumber;

    public void setPschId(Long pschId) 
    {
        this.pschId = pschId;
    }

    public Long getPschId() 
    {
        return pschId;
    }
    public void setPrcpId(Long prcpId) 
    {
        this.prcpId = prcpId;
    }

    public Long getPrcpId() 
    {
        return prcpId;
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

    public Long getCatUnit() {
        return catUnit;
    }
    public void setCatUnit(Long catUnit) {
        this.catUnit = catUnit;
    }

    public void setPschPrice(Long pschPrice) 
    {
        this.pschPrice = pschPrice;
    }

    public Long getPschPrice() 
    {
        return pschPrice;
    }
    public void setPschNumber(Long pschNumber) 
    {
        this.pschNumber = pschNumber;
    }

    public Long getPschNumber() 
    {
        return pschNumber;
    }

    @Override
    public String toString() {
        return "HisProcurementSchedules{" +
                "pschId=" + pschId +
                ", prcpId=" + prcpId +
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
                ", pschPrice=" + pschPrice +
                ", pschNumber=" + pschNumber +
                '}';
    }
}
