package com.ruoyi.project.his.entry.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 入库单对象 his_warehousing_entry
 * 
 * @author SteveMMMy
 * @date 2024-05-14
 */
public class HisWarehousingEntry extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 入库单ID */
    private Long entId;

    /** 制单人ID */
    @Excel(name = "制单人ID")
    private Long userId;

    /** 制单人 */
    @Excel(name = "制单人")
    private String userName;

    /** 入库单据号 */
    @Excel(name = "入库单据号")
    private String entDocNum;

    /** 入库日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入库日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date entDate;

    /** 入库单明细信息 */
    private List<HisEntrySchedules> hisEntrySchedulesList;

    public void setEntId(Long entId)
    {
        this.entId = entId;
    }

    public Long getEntId()
    {
        return entId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setEntDocNum(String entDocNum)
    {
        this.entDocNum = entDocNum;
    }

    public String getEntDocNum()
    {
        return entDocNum;
    }
    public void setEntDate(Date entDate)
    {
        this.entDate = entDate;
    }

    public Date getEntDate()
    {
        return entDate;
    }

    public List<HisEntrySchedules> getHisEntrySchedulesList()
    {
        return hisEntrySchedulesList;
    }

    public void setHisEntrySchedulesList(List<HisEntrySchedules> hisEntrySchedulesList)
    {
        this.hisEntrySchedulesList = hisEntrySchedulesList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("entId", getEntId())
            .append("userId", getUserId())
            .append("entDocNum", getEntDocNum())
            .append("entDate", getEntDate())
            .append("hisEntrySchedulesList", getHisEntrySchedulesList())
            .toString();
    }
}
