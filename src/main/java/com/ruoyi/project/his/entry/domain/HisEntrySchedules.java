package com.ruoyi.project.his.entry.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 入库单明细对象 his_entry_schedules
 * 
 * @author SteveMMMy
 * @date 2024-05-14
 */
public class HisEntrySchedules extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 明细号 */
    private Long entSchId;

    /** 入库单ID */
    @Excel(name = "入库单ID")
    private Long entId;

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

    /** 生产批号 */
    @Excel(name = "生产批号")
    private String entSchBatchNumber;

    /** 生产日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date entSchProdDate;

    /** 有效期至 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "有效期至", width = 30, dateFormat = "yyyy-MM-dd")
    private Date entSchValidTo;

    /** 单价 */
    @Excel(name = "单价")
    private Long entSchUnitPrice;

    /** 入库数量 */
    @Excel(name = "入库数量")
    private Long entSchNum;

    public void setEntSchId(Long entSchId) 
    {
        this.entSchId = entSchId;
    }

    public Long getEntSchId() 
    {
        return entSchId;
    }
    public void setEntId(Long entId) 
    {
        this.entId = entId;
    }

    public Long getEntId() 
    {
        return entId;
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

    public void setEntSchBatchNumber(String entSchBatchNumber)
    {
        this.entSchBatchNumber = entSchBatchNumber;
    }

    public String getEntSchBatchNumber() 
    {
        return entSchBatchNumber;
    }
    public void setEntSchProdDate(Date entSchProdDate) 
    {
        this.entSchProdDate = entSchProdDate;
    }

    public Date getEntSchProdDate() 
    {
        return entSchProdDate;
    }
    public void setEntSchValidTo(Date entSchValidTo) 
    {
        this.entSchValidTo = entSchValidTo;
    }

    public Date getEntSchValidTo() 
    {
        return entSchValidTo;
    }

    public Long getEntSchUnitPrice() {
        return entSchUnitPrice;
    }

    public void setEntSchUnitPrice(Long entSchUnitPrice) {
        this.entSchUnitPrice = entSchUnitPrice;
    }

    public void setEntSchNum(Long entSchNum)
    {
        this.entSchNum = entSchNum;
    }

    public Long getEntSchNum() 
    {
        return entSchNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("entSchId", getEntSchId())
            .append("entId", getEntId())
            .append("catId", getCatId())
            .append("entSchBatchNumber", getEntSchBatchNumber())
            .append("entSchProdDate", getEntSchProdDate())
            .append("entSchValidTo", getEntSchValidTo())
            .append("entSchNum", getEntSchNum())
            .toString();
    }
}
