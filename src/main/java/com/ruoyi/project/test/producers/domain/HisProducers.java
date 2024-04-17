package com.ruoyi.project.test.producers.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 生产商对象 his_producers
 * 
 * @author SteveMMMy
 * @date 2024-04-13
 */
public class HisProducers extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 生产商编号 */
    @Excel(name = "生产商编号")
    private Long pdcNumber;

    /** 生产商名称 */
    @Excel(name = "生产商名称")
    private String pdcName;

    public void setPdcNumber(Long pdcNumber)
    {
        this.pdcNumber = pdcNumber;
    }

    public Long getPdcNumber()
    {
        return pdcNumber;
    }
    public void setPdcName(String pdcName)
    {
        this.pdcName = pdcName;
    }

    public String getPdcName()
    {
        return pdcName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pdcNumber", getPdcNumber())
            .append("pdcName", getPdcName())
            .toString();
    }
}
