package com.ruoyi.project.his.purchase_orders.domain;

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
public class HisOrdersSchedules extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 明细号 */
    private Long orderSchId;

    /** 采购单ID */
    @Excel(name = "采购单ID")
    private Long purId;

    /** 药品ID */
    @Excel(name = "药品ID")
    private Long catId;

    /** 采购数量 */
    @Excel(name = "采购数量")
    private Long orderSchNumber;

    public void setOrderSchId(Long orderSchId) 
    {
        this.orderSchId = orderSchId;
    }

    public Long getOrderSchId() 
    {
        return orderSchId;
    }
    public void setPurId(Long purId) 
    {
        this.purId = purId;
    }

    public Long getPurId() 
    {
        return purId;
    }
    public void setCatId(Long catId) 
    {
        this.catId = catId;
    }

    public Long getCatId() 
    {
        return catId;
    }
    public void setOrderSchNumber(Long orderSchNumber) 
    {
        this.orderSchNumber = orderSchNumber;
    }

    public Long getOrderSchNumber() 
    {
        return orderSchNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderSchId", getOrderSchId())
            .append("purId", getPurId())
            .append("catId", getCatId())
            .append("orderSchNumber", getOrderSchNumber())
            .toString();
    }
}
