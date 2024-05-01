package com.ruoyi.project.his.catalogue.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 药品目录对象 his_drug_catalogue
 * 
 * @author SteveMMMy
 * @date 2024-05-01
 */
public class HisDrugCatalogue extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 药品ID */
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

    /** 销售单价 */
    @Excel(name = "销售单价")
    private Long catUnitPrice;

    public void setCatId(Long catId)
    {
        this.catId = catId;
    }

    public Long getCatId()
    {
        return catId;
    }
    public void setCatApprovalNumber(String catApprovalNumber)
    {
        this.catApprovalNumber = catApprovalNumber;
    }

    public String getCatApprovalNumber()
    {
        return catApprovalNumber;
    }
    public void setCatDrugNum(String catDrugNum)
    {
        this.catDrugNum = catDrugNum;
    }

    public String getCatDrugNum()
    {
        return catDrugNum;
    }
    public void setCatName(String catName)
    {
        this.catName = catName;
    }

    public String getCatName()
    {
        return catName;
    }
    public void setCatEnglishName(String catEnglishName)
    {
        this.catEnglishName = catEnglishName;
    }

    public String getCatEnglishName()
    {
        return catEnglishName;
    }
    public void setCatProducer(String catProducer)
    {
        this.catProducer = catProducer;
    }

    public String getCatProducer()
    {
        return catProducer;
    }
    public void setCatSpecs(String catSpecs)
    {
        this.catSpecs = catSpecs;
    }

    public String getCatSpecs()
    {
        return catSpecs;
    }
    public void setCatDosageForm(Long catDosageForm)
    {
        this.catDosageForm = catDosageForm;
    }

    public Long getCatDosageForm()
    {
        return catDosageForm;
    }
    public void setCatPackage(String catPackage)
    {
        this.catPackage = catPackage;
    }

    public String getCatPackage()
    {
        return catPackage;
    }
    public void setCatUnit(Long catUnit)
    {
        this.catUnit = catUnit;
    }

    public Long getCatUnit()
    {
        return catUnit;
    }
    public void setCatUnitPrice(Long catUnitPrice)
    {
        this.catUnitPrice = catUnitPrice;
    }

    public Long getCatUnitPrice()
    {
        return catUnitPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("catId", getCatId())
            .append("catApprovalNumber", getCatApprovalNumber())
            .append("catDrugNum", getCatDrugNum())
            .append("catName", getCatName())
            .append("catEnglishName", getCatEnglishName())
            .append("catProducer", getCatProducer())
            .append("catSpecs", getCatSpecs())
            .append("catDosageForm", getCatDosageForm())
            .append("catPackage", getCatPackage())
            .append("catUnit", getCatUnit())
            .append("catUnitPrice", getCatUnitPrice())
            .toString();
    }
}
