package com.ruoyi.develop.service.impl;

import com.ruoyi.develop.mapper.DbxrefMapper;
import com.ruoyi.develop.service.IDbxrefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-15
 */
@Service
public class DbxrefServiceImpl implements IDbxrefService
{
    @Autowired
    private DbxrefMapper dbxrefMapper;

    /**
     * 通过dbxrefId在dbxref表里查询accession
     *
     * @param dbxrefId
     * @return dbxrefId对应的accession
     */
    public String selectAccessionByDbxrefId(String dbxrefId){
        return dbxrefMapper.selectAccessionByDbxrefId(dbxrefId);
    }

    /**
     * 通过accession在dbxref表里查询version
     *
     * @param accession
     * @return version的list
     */
    public List<String> selectVersionByAccession(String accession){
        return dbxrefMapper.selectVersionByAccession(accession);
    }
}
