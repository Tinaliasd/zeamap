package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * feature对象 feature
 * 
 * @author ruoyi
 * @date 2022-10-30
 */
public class Feature extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long featureId;

    /** expression表关联的id */
    @Excel(name = "expression表关联的id")
    private String uniquename;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String residues;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String seqlen;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long dbxrefId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long typeId;

    /** Single expression viewer 的基因ID，查询字段 */
    @Excel(name = "Single expression viewer 的基因ID，查询字段")
    private String commonname;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setFeatureId(Long featureId) 
    {
        this.featureId = featureId;
    }

    public Long getFeatureId() 
    {
        return featureId;
    }
    public void setUniquename(String uniquename) 
    {
        this.uniquename = uniquename;
    }

    public String getUniquename() 
    {
        return uniquename;
    }
    public void setResidues(String residues) 
    {
        this.residues = residues;
    }

    public String getResidues() 
    {
        return residues;
    }
    public void setSeqlen(String seqlen) 
    {
        this.seqlen = seqlen;
    }

    public String getSeqlen() 
    {
        return seqlen;
    }
    public void setDbxrefId(Long dbxrefId) 
    {
        this.dbxrefId = dbxrefId;
    }

    public Long getDbxrefId() 
    {
        return dbxrefId;
    }
    public void setTypeId(Long typeId) 
    {
        this.typeId = typeId;
    }

    public Long getTypeId() 
    {
        return typeId;
    }
    public void setCommonname(String commonname) 
    {
        this.commonname = commonname;
    }

    public String getCommonname() 
    {
        return commonname;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("featureId", getFeatureId())
            .append("uniquename", getUniquename())
            .append("residues", getResidues())
            .append("seqlen", getSeqlen())
            .append("dbxrefId", getDbxrefId())
            .append("typeId", getTypeId())
            .append("commonname", getCommonname())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
