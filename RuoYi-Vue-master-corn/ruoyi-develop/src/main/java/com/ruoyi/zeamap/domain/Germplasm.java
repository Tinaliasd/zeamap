package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产品详情对象 germplasm
 * 
 * @author ruoyi
 * @date 2023-03-14
 */
public class Germplasm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @Excel(name = "主键")
    private Long germplasmId;

    /** $column.columnComment */
    @Excel(name = "种质名称")
    private String name;

    /** $column.columnComment */
    @Excel(name = "属")
    private String genus;

    /** $column.columnComment */
    @Excel(name = "品种")
    private String species;

    /** $column.columnComment */
    @Excel(name = "其他名称")
    private String commonName;

    /** $column.columnComment */
    @Excel(name = "描述")
    private String comment;

    /** $column.columnComment */
    @Excel(name = "subGroup表主键")
    private Long groupId;

    /** $column.columnComment */
    @Excel(name = "population表主键")
    private Long populationId;

    /** $column.columnComment */
    @Excel(name = "经度")
    private Long latitude;

    /** $column.columnComment */
    @Excel(name = "纬度")
    private Long longtitude;

    /** $column.columnComment */
    @Excel(name = "name统一编号")
    private String ngbId;

    /** $column.columnComment */
    @Excel(name = "地区")
    private String origin;

    public void setGermplasmId(Long germplasmId) 
    {
        this.germplasmId = germplasmId;
    }

    public Long getGermplasmId() 
    {
        return germplasmId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setGenus(String genus) 
    {
        this.genus = genus;
    }

    public String getGenus() 
    {
        return genus;
    }
    public void setSpecies(String species) 
    {
        this.species = species;
    }

    public String getSpecies() 
    {
        return species;
    }
    public void setCommonName(String commonName) 
    {
        this.commonName = commonName;
    }

    public String getCommonName() 
    {
        return commonName;
    }
    public void setComment(String comment) 
    {
        this.comment = comment;
    }

    public String getComment() 
    {
        return comment;
    }
    public void setGroupId(Long groupId) 
    {
        this.groupId = groupId;
    }

    public Long getGroupId() 
    {
        return groupId;
    }
    public void setPopulationId(Long populationId) 
    {
        this.populationId = populationId;
    }

    public Long getPopulationId() 
    {
        return populationId;
    }
    public void setLatitude(Long latitude) 
    {
        this.latitude = latitude;
    }

    public Long getLatitude() 
    {
        return latitude;
    }
    public void setLongtitude(Long longtitude) 
    {
        this.longtitude = longtitude;
    }

    public Long getLongtitude() 
    {
        return longtitude;
    }
    public void setNgbId(String ngbId) 
    {
        this.ngbId = ngbId;
    }

    public String getNgbId() 
    {
        return ngbId;
    }
    public void setOrigin(String origin) 
    {
        this.origin = origin;
    }

    public String getOrigin() 
    {
        return origin;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("germplasmId", getGermplasmId())
            .append("name", getName())
            .append("genus", getGenus())
            .append("species", getSpecies())
            .append("commonName", getCommonName())
            .append("comment", getComment())
            .append("groupId", getGroupId())
            .append("populationId", getPopulationId())
            .append("latitude", getLatitude())
            .append("longtitude", getLongtitude())
            .append("ngbId", getNgbId())
            .append("origin", getOrigin())
            .toString();
    }
}
