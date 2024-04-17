package com.ruoyi.project.test.batchNumbers.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 生产批号对象 his_batch_numbers
 * 
 * @author SteveMMMy
 * @date 2024-04-13
 */
public class HisBatchNumbers extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 生产批号 */
    @Excel(name = "生产批号")
    private String batchNumber;

    /** 生产商编号 */
    @Excel(name = "生产商编号")
    private Long pdcNumber;

    public void setBatchNumber(String batchNumber)
    {
        this.batchNumber = batchNumber;
    }

    public String getBatchNumber()
    {
        return batchNumber;
    }
    public void setPdcNumber(Long pdcNumber)
    {
        this.pdcNumber = pdcNumber;
    }

    public Long getPdcNumber()
    {
        return pdcNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("batchNumber", getBatchNumber())
            .append("pdcNumber", getPdcNumber())
            .toString();
    }
}
