package com.ruoyi.project.his.procurement_plans.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    /** 预计采购日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预计采购日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date pschPurDate;

    /** 最迟到货日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最迟到货日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date pschArvDate;

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
    public void setPschPurDate(Date pschPurDate) 
    {
        this.pschPurDate = pschPurDate;
    }

    public Date getPschPurDate() 
    {
        return pschPurDate;
    }
    public void setPschArvDate(Date pschArvDate) 
    {
        this.pschArvDate = pschArvDate;
    }

    public Date getPschArvDate() 
    {
        return pschArvDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pschId", getPschId())
            .append("prcpId", getPrcpId())
            .append("catId", getCatId())
            .append("pschPrice", getPschPrice())
            .append("pschNumber", getPschNumber())
            .append("pschPurDate", getPschPurDate())
            .append("pschArvDate", getPschArvDate())
            .toString();
    }
}
