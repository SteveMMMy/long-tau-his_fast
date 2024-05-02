package com.ruoyi.project.his.purchase.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 采购订单对象 his_purchase_orders
 * 
 * @author SteveMMMy
 * @date 2024-05-01
 */
public class HisPurchaseOrders extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 采购单ID */
    private Long purId;

    /** 供应商编号 */
    @Excel(name = "供应商编号")
    private Long splId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 采购单据号 */
    @Excel(name = "采购单据号")
    private String purDocNum;

    /** 订单日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "订单日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date purDate;

    /** 计划到货日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划到货日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date purArrDate;

    /** 预计付款日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预计付款日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date purPayDate;

    /** 采购单状态 */
    @Excel(name = "采购单状态")
    private Long purStatus;

    /** 采购订单明细信息 */
    private List<HisOrdersSchedules> hisOrdersSchedulesList;

    public void setPurId(Long purId)
    {
        this.purId = purId;
    }

    public Long getPurId()
    {
        return purId;
    }
    public void setSplId(Long splId)
    {
        this.splId = splId;
    }

    public Long getSplId()
    {
        return splId;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setPurDocNum(String purDocNum)
    {
        this.purDocNum = purDocNum;
    }

    public String getPurDocNum()
    {
        return purDocNum;
    }
    public void setPurDate(Date purDate)
    {
        this.purDate = purDate;
    }

    public Date getPurDate()
    {
        return purDate;
    }
    public void setPurArrDate(Date purArrDate)
    {
        this.purArrDate = purArrDate;
    }

    public Date getPurArrDate()
    {
        return purArrDate;
    }
    public void setPurPayDate(Date purPayDate)
    {
        this.purPayDate = purPayDate;
    }

    public Date getPurPayDate()
    {
        return purPayDate;
    }
    public void setPurStatus(Long purStatus)
    {
        this.purStatus = purStatus;
    }

    public Long getPurStatus()
    {
        return purStatus;
    }

    public List<HisOrdersSchedules> getHisOrdersSchedulesList()
    {
        return hisOrdersSchedulesList;
    }

    public void setHisOrdersSchedulesList(List<HisOrdersSchedules> hisOrdersSchedulesList)
    {
        this.hisOrdersSchedulesList = hisOrdersSchedulesList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("purId", getPurId())
            .append("splId", getSplId())
            .append("userId", getUserId())
            .append("purDocNum", getPurDocNum())
            .append("purDate", getPurDate())
            .append("purArrDate", getPurArrDate())
            .append("purPayDate", getPurPayDate())
            .append("purStatus", getPurStatus())
            .append("hisOrdersSchedulesList", getHisOrdersSchedulesList())
            .toString();
    }
}
