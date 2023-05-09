package com.ruoyi.develop.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2023-03-15
 */
@Service
public interface IDbxrefService
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
