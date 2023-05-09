package com.ruoyi.develop.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2023-03-15
 */
@Mapper
public interface DbxrefMapper
{
    /**
     * 通过dbxrefId在dbxref表里查询accession
     *
     * @param dbxrefId
     * @return dbxrefId对应的accession
     */
    public String selectAccessionByDbxrefId(String dbxrefId);

    /**
     * 通过accession在dbxref表里查询version
     *
     * @param accession
     * @return version的list
     */
    public List<String> selectVersionByAccession(String accession);
}
