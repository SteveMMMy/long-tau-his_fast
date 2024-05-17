package com.ruoyi.project.his.prescriptions.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 处方对象 his_prescriptions
 * 
 * @author SteveMMMy
 * @date 2024-05-17
 */
public class HisPrescriptions extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 处方ID */
    private Long prscId;

    /** 记录编号 */
    @Excel(name = "记录编号")
    private Long regId;

    /** 处方单据号 */
    @Excel(name = "处方单据号")
    private String prscDocNum;

    /** 处方类型 */
    @Excel(name = "处方类型")
    private Long prscType;

    /** 处方状态 */
    @Excel(name = "处方状态")
    private Long prscStatus;

    /** 备注 */
    @Excel(name = "备注")
    private String prscComments;

    /** 处方明细信息 */
    private List<HisPrescriptionsSchedules> hisPrescriptionsSchedulesList;

    public void setPrscId(Long prscId)
    {
        this.prscId = prscId;
    }

    public Long getPrscId()
    {
        return prscId;
    }
    public void setRegId(Long regId)
    {
        this.regId = regId;
    }

    public Long getRegId()
    {
        return regId;
    }
    public void setPrscDocNum(String prscDocNum)
    {
        this.prscDocNum = prscDocNum;
    }

    public String getPrscDocNum()
    {
        return prscDocNum;
    }
    public void setPrscType(Long prscType)
    {
        this.prscType = prscType;
    }

    public Long getPrscType()
    {
        return prscType;
    }
    public void setPrscStatus(Long prscStatus)
    {
        this.prscStatus = prscStatus;
    }

    public Long getPrscStatus()
    {
        return prscStatus;
    }
    public void setPrscComments(String prscComments)
    {
        this.prscComments = prscComments;
    }

    public String getPrscComments()
    {
        return prscComments;
    }

    public List<HisPrescriptionsSchedules> getHisPrescriptionsSchedulesList()
    {
        return hisPrescriptionsSchedulesList;
    }

    public void setHisPrescriptionsSchedulesList(List<HisPrescriptionsSchedules> hisPrescriptionsSchedulesList)
    {
        this.hisPrescriptionsSchedulesList = hisPrescriptionsSchedulesList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("prscId", getPrscId())
            .append("regId", getRegId())
            .append("prscDocNum", getPrscDocNum())
            .append("prscType", getPrscType())
            .append("prscStatus", getPrscStatus())
            .append("prscComments", getPrscComments())
            .append("hisPrescriptionsSchedulesList", getHisPrescriptionsSchedulesList())
            .toString();
    }
}
