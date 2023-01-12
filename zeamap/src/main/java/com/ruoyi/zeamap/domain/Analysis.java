package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * analysis对象 analysis
 * 
 * @author ruoyi
 * @date 2023-01-08
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
    private String program;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String programversion;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String doi;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String url;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String source;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String dbxrefId;

    /** $column.columnComment */
    private String populationId;

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
    public void setProgram(String program) 
    {
        this.program = program;
    }

    public String getProgram() 
    {
        return program;
    }
    public void setProgramversion(String programversion) 
    {
        this.programversion = programversion;
    }

    public String getProgramversion() 
    {
        return programversion;
    }
    public void setDoi(String doi) 
    {
        this.doi = doi;
    }

    public String getDoi() 
    {
        return doi;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }
    public void setSource(String source) 
    {
        this.source = source;
    }

    public String getSource() 
    {
        return source;
    }
    public void setDbxrefId(String dbxrefId) 
    {
        this.dbxrefId = dbxrefId;
    }

    public String getDbxrefId() 
    {
        return dbxrefId;
    }
    public void setPopulationId(String populationId) 
    {
        this.populationId = populationId;
    }

    public String getPopulationId() 
    {
        return populationId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("analysisId", getAnalysisId())
            .append("name", getName())
            .append("description", getDescription())
            .append("program", getProgram())
            .append("programversion", getProgramversion())
            .append("doi", getDoi())
            .append("url", getUrl())
            .append("source", getSource())
            .append("dbxrefId", getDbxrefId())
            .append("populationId", getPopulationId())
            .toString();
    }
}
