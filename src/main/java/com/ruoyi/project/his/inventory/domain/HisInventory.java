package com.ruoyi.project.his.inventory.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 库存信息对象 his_inventory
 * 
 * @author SteveMMMy
 * @date 2024-05-01
 */
public class HisInventory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 库存编号 */
    private Long invId;

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
    private String invBatchNumber;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private Long invNumber;

    /** 销售单价 */
    @Excel(name = "销售单价")
    private Long invUnitPrice;

    /** 生产日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date invProdDate;

    /** 有效期至 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "有效期至", width = 30, dateFormat = "yyyy-MM-dd")
    private Date invValidTo;

    public void setInvId(Long invId) 
    {
        this.invId = invId;
    }

    public Long getInvId() 
    {
        return invId;
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
    public void setInvBatchNumber(String invBatchNumber) 
    {
        this.invBatchNumber = invBatchNumber;
    }

    public String getInvBatchNumber() 
    {
        return invBatchNumber;
    }
    public void setInvNumber(Long invNumber) 
    {
        this.invNumber = invNumber;
    }

    public Long getInvNumber() 
    {
        return invNumber;
    }
    public void setInvUnitPrice(Long invUnitPrice) 
    {
        this.invUnitPrice = invUnitPrice;
    }

    public Long getInvUnitPrice() 
    {
        return invUnitPrice;
    }
    public void setInvProdDate(Date invProdDate) 
    {
        this.invProdDate = invProdDate;
    }

    public Date getInvProdDate() 
    {
        return invProdDate;
    }
    public void setInvValidTo(Date invValidTo) 
    {
        this.invValidTo = invValidTo;
    }

    public Date getInvValidTo() 
    {
        return invValidTo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("invId", getInvId())
            .append("catId", getCatId())
            .append("invBatchNumber", getInvBatchNumber())
            .append("invNumber", getInvNumber())
            .append("invUnitPrice", getInvUnitPrice())
            .append("invProdDate", getInvProdDate())
            .append("invValidTo", getInvValidTo())
            .toString();
    }
}
