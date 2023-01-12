package com.ruoyi.zeamap.vo;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;
import java.util.Map;

/**
 * @program: ruoyi
 * @description:
 * @author: Tinaliasd
 **/
public class ExpressionVo {
    private String reference;

    private String version;

    private List<String> geneIds;

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    private String analysis;

    private String environment;

    //Tissue
    private String germplasm;

    //Germplasm
    private String population;

    private String tissue;

    //Analysis
    private String subgroup;

    private int flag;//判断是哪一种

    private Map<String, List<String>> selector;

    private List<String> selects;

    public List<String> getSelects() {
        return selects;
    }

    public void setSelects(List<String> selects) {
        this.selects = selects;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getVersion() {
        return version ;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<String> getGeneIds() {
        return this.geneIds;
    }

    public void setGeneIds(List<String> geneIds) {
        this.geneIds = geneIds;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getGermplasm() {
        return germplasm;
    }

    public void setGermplasm(String germplasm) {
        this.germplasm = germplasm;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getTissue() {
        return tissue;
    }

    public void setTissue(String tissue) {
        this.tissue = tissue;
    }

    public String getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(String subgroup) {
        this.subgroup = subgroup;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Map<String, List<String>> getSelector() {
        return selector;
    }

    public void setSelector(Map<String, List<String>> selector) {
        this.selector = selector;
    }

    public ExpressionVo(String reference, String version, List<String> geneIds, String analysis,
                        String environment, String germplasm, String population, String tissue,
                        String subgroup, int flag, Map<String, List<String>> selector, List<String> selects) {
        this.reference = reference;
        this.version = version;
        this.geneIds = geneIds;
        this.analysis = analysis;
        this.environment = environment;
        this.germplasm = germplasm;
        this.population = population;
        this.tissue = tissue;
        this.subgroup = subgroup;
        this.flag = flag;
        this.selector = selector;
        this.selects = selects;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("reference", getReference())
                .append("version", getVersion())
                .append("geneIds", getGeneIds())
                .append("analysis", getAnalysis())
                .append("environment", getEnvironment())
                .append("germplasm", getGermplasm())
                .append("population", getPopulation())
                .append("tissue",getTissue())
                .append("subgroup",getSubgroup())
                .append("flag",getFlag())
                .append("selector",getSelector())
                .append("selects",getSelects())
                .toString();
    }
}
