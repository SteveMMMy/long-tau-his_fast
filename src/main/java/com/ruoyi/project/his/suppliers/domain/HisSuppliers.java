package com.ruoyi.project.his.suppliers.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 供应商对象 his_suppliers
 * 
 * @author SteveMMMy
 * @date 2024-05-01
 */
public class HisSuppliers extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 供应商编号 */
    private Long splId;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String splName;

    /** 供应商地址 */
    @Excel(name = "供应商地址")
    private String splAddr;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String splContact;

    /** 法人代表 */
    @Excel(name = "法人代表")
    private String splLegalPerson;

    /** 许可证编号 */
    @Excel(name = "许可证编号")
    private String splPermitId;

    /** 质量认证情况 */
    @Excel(name = "质量认证情况")
    private String splCertification;

    /** 营业执照编号 */
    @Excel(name = "营业执照编号")
    private String splBusinessLicenseId;

    public void setSplId(Long splId)
    {
        this.splId = splId;
    }

    public Long getSplId()
    {
        return splId;
    }
    public void setSplName(String splName)
    {
        this.splName = splName;
    }

    public String getSplName()
    {
        return splName;
    }
    public void setSplAddr(String splAddr)
    {
        this.splAddr = splAddr;
    }

    public String getSplAddr()
    {
        return splAddr;
    }
    public void setSplContact(String splContact)
    {
        this.splContact = splContact;
    }

    public String getSplContact()
    {
        return splContact;
    }
    public void setSplLegalPerson(String splLegalPerson)
    {
        this.splLegalPerson = splLegalPerson;
    }

    public String getSplLegalPerson()
    {
        return splLegalPerson;
    }
    public void setSplPermitId(String splPermitId)
    {
        this.splPermitId = splPermitId;
    }

    public String getSplPermitId()
    {
        return splPermitId;
    }
    public void setSplCertification(String splCertification)
    {
        this.splCertification = splCertification;
    }

    public String getSplCertification()
    {
        return splCertification;
    }
    public void setSplBusinessLicenseId(String splBusinessLicenseId)
    {
        this.splBusinessLicenseId = splBusinessLicenseId;
    }

    public String getSplBusinessLicenseId()
    {
        return splBusinessLicenseId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("splId", getSplId())
            .append("splName", getSplName())
            .append("splAddr", getSplAddr())
            .append("splContact", getSplContact())
            .append("splLegalPerson", getSplLegalPerson())
            .append("splPermitId", getSplPermitId())
            .append("splCertification", getSplCertification())
            .append("splBusinessLicenseId", getSplBusinessLicenseId())
            .toString();
    }
}
