package com.ruoyi.zeamap.domain;

        import org.apache.commons.lang3.builder.ToStringBuilder;
        import org.apache.commons.lang3.builder.ToStringStyle;
        import com.ruoyi.common.annotation.Excel;
        import com.ruoyi.common.core.domain.BaseEntity;

/**
 * analysis对象 analysis
 *
 * @author ruoyi
 * @date 2023-03-13
 */
public class Analysis extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long analysisId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String name;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String description;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long dbxrefId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long populationId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String detailed;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String methods;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String omics;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String reference;

    public void setAnalysisId(Long analysisId)
    {
        this.analysisId = analysisId;
    }

    public Long getAnalysisId()
    {
        return analysisId;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
    public void setDbxrefId(Long dbxrefId)
    {
        this.dbxrefId = dbxrefId;
    }

    public Long getDbxrefId()
    {
        return dbxrefId;
    }
    public void setPopulationId(Long populationId)
    {
        this.populationId = populationId;
    }

    public Long getPopulationId()
    {
        return populationId;
    }
    public void setDetailed(String detailed)
    {
        this.detailed = detailed;
    }

    public String getDetailed()
    {
        return detailed;
    }
    public void setMethods(String methods)
    {
        this.methods = methods;
    }

    public String getMethods()
    {
        return methods;
    }
    public void setOmics(String omics)
    {
        this.omics = omics;
    }

    public String getOmics()
    {
        return omics;
    }
    public void setReference(String reference)
    {
        this.reference = reference;
    }

    public String getReference()
    {
        return reference;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("analysisId", getAnalysisId())
                .append("name", getName())
                .append("description", getDescription())
                .append("dbxrefId", getDbxrefId())
                .append("populationId", getPopulationId())
                .append("detailed", getDetailed())
                .append("methods", getMethods())
                .append("omics", getOmics())
                .append("reference", getReference())
                .toString();
    }
}
