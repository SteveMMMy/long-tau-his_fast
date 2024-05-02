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
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pschId", getPschId())
            .append("prcpId", getPrcpId())
            .append("catId", getCatId())
            .append("pschPrice", getPschPrice())
            .append("pschNumber", getPschNumber())
            .toString();
    }
}
