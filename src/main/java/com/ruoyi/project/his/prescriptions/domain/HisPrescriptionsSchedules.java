package com.ruoyi.project.his.prescriptions.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("prscSchId", getPrscSchId())
            .append("prscId", getPrscId())
            .append("catId", getCatId())
            .append("prscSchQuantity", getPrscSchQuantity())
            .append("prscSchUsage", getPrscSchUsage())
            .append("prscSchFreq", getPrscSchFreq())
            .append("prscSchIsSelfPrepared", getPrscSchIsSelfPrepared())
            .append("prscSchUnitPrice", getPrscSchUnitPrice())
            .toString();
    }
}
