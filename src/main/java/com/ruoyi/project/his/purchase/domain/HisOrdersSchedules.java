package com.ruoyi.project.his.purchase.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 采购订单明细对象 his_orders_schedules
 *
 * @author SteveMMMy
 * @date 2024-05-01
 */
public class HisOrdersSchedules extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 明细号 */
    private Long orderSchId;

    /** 采购单ID */
    @Excel(name = "采购单ID")
    private Long purId;

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

    /** 采购数量 */
    @Excel(name = "采购数量")
    private Long orderSchNumber;

    /** 金额 */
    @Excel(name = "金额")
    private Long orderSchPrice;

    public Long getOrderSchId() {
        return orderSchId;
    }

    public void setOrderSchId(Long orderSchId) {
        this.orderSchId = orderSchId;
    }

    public Long getPurId() {
        return purId;
    }

    public void setPurId(Long purId) {
        this.purId = purId;
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

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public Long getOrderSchNumber() {
        return orderSchNumber;
    }

    public void setOrderSchNumber(Long orderSchNumber) {
        this.orderSchNumber = orderSchNumber;
    }

    public Long getOrderSchPrice() {
        return orderSchPrice;
    }

    public void setOrderSchPrice(Long orderSchPrice) {
        this.orderSchPrice = orderSchPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("orderSchId", getOrderSchId())
                .append("purId", getPurId())
                .append("catId", getCatId())
                .append("orderSchNumber", getOrderSchNumber())
                .append("orderSchPrice", getOrderSchPrice())
                .toString();
    }
}
