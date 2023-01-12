package com.ruoyi.zeamap.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.DbxrefMapper;
import com.ruoyi.zeamap.domain.Dbxref;
import com.ruoyi.zeamap.service.IDbxrefService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
@Service
public class DbxrefServiceImpl implements IDbxrefService 
{
    @Autowired
    private DbxrefMapper dbxrefMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param dbxrefId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Dbxref selectDbxrefByDbxrefId(Long dbxrefId)
    {
        return dbxrefMapper.selectDbxrefByDbxrefId(dbxrefId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param dbxref 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Dbxref> selectDbxrefList(Dbxref dbxref)
    {
        return dbxrefMapper.selectDbxrefList(dbxref);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param dbxref 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertDbxref(Dbxref dbxref)
    {
        return dbxrefMapper.insertDbxref(dbxref);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param dbxref 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateDbxref(Dbxref dbxref)
    {
        return dbxrefMapper.updateDbxref(dbxref);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param dbxrefIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDbxrefByDbxrefIds(Long[] dbxrefIds)
    {
        return dbxrefMapper.deleteDbxrefByDbxrefIds(dbxrefIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param dbxrefId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDbxrefByDbxrefId(Long dbxrefId)
    {
        return dbxrefMapper.deleteDbxrefByDbxrefId(dbxrefId);
    }
}
