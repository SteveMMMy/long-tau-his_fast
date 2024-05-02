package com.ruoyi.project.his.catalogue.domain;

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
