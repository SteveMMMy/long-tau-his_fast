package com.ruoyi.project.his.plans.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 采购计划单对象 his_procurement_plans
 * 
 * @author SteveMMMy
 * @date 2024-05-01
 */
public class HisProcurementPlans extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 采购计划表ID */
    private Long prcpId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 采购单ID */
    @Excel(name = "采购单ID")
    private Long purId;

    /** 采购计划单据号 */
    @Excel(name = "采购计划单据号")
    private String prcpDocNum;

    /** 制单日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "制单日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date prcpDate;

    /** 预计采购日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预计采购日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date prcpPurDate;

    /** 最迟到货日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最迟到货日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date prcpArvDate;

    /** 计划单状态 */
    @Excel(name = "计划单状态")
    private Long prcpStatus;

    /** 采购计划明细信息 */
    private List<HisProcurementSchedules> hisProcurementSchedulesList;

    public void setPrcpId(Long prcpId)
    {
        this.prcpId = prcpId;
    }

    public Long getPrcpId()
    {
        return prcpId;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setPurId(Long purId)
    {
        this.purId = purId;
    }

    public Long getPurId()
    {
        return purId;
    }
    public void setPrcpDocNum(String prcpDocNum)
    {
        this.prcpDocNum = prcpDocNum;
    }

    public String getPrcpDocNum()
    {
        return prcpDocNum;
    }
    public void setPrcpDate(Date prcpDate)
    {
        this.prcpDate = prcpDate;
    }

    public Date getPrcpDate()
    {
        return prcpDate;
    }
    public void setPrcpPurDate(Date prcpPurDate)
    {
        this.prcpPurDate = prcpPurDate;
    }

    public Date getPrcpPurDate()
    {
        return prcpPurDate;
    }
    public void setPrcpArvDate(Date prcpArvDate)
    {
        this.prcpArvDate = prcpArvDate;
    }

    public Date getPrcpArvDate()
    {
        return prcpArvDate;
    }
    public void setPrcpStatus(Long prcpStatus)
    {
        this.prcpStatus = prcpStatus;
    }

    public Long getPrcpStatus()
    {
        return prcpStatus;
    }

    public List<HisProcurementSchedules> getHisProcurementSchedulesList()
    {
        return hisProcurementSchedulesList;
    }

    public void setHisProcurementSchedulesList(List<HisProcurementSchedules> hisProcurementSchedulesList)
    {
        this.hisProcurementSchedulesList = hisProcurementSchedulesList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("prcpId", getPrcpId())
            .append("userId", getUserId())
            .append("purId", getPurId())
            .append("prcpDocNum", getPrcpDocNum())
            .append("prcpDate", getPrcpDate())
            .append("prcpPurDate", getPrcpPurDate())
            .append("prcpArvDate", getPrcpArvDate())
            .append("prcpStatus", getPrcpStatus())
            .append("hisProcurementSchedulesList", getHisProcurementSchedulesList())
            .toString();
    }
}
