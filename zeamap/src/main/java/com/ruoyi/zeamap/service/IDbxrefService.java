package com.ruoyi.zeamap.service;

import java.util.List;
import com.ruoyi.zeamap.domain.Dbxref;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
public interface IDbxrefService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param dbxrefId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Dbxref selectDbxrefByDbxrefId(Long dbxrefId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param dbxref 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Dbxref> selectDbxrefList(Dbxref dbxref);

    /**
     * 新增【请填写功能名称】
     * 
     * @param dbxref 【请填写功能名称】
     * @return 结果
     */
    public int insertDbxref(Dbxref dbxref);

    /**
     * 修改【请填写功能名称】
     * 
     * @param dbxref 【请填写功能名称】
     * @return 结果
     */
    public int updateDbxref(Dbxref dbxref);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param dbxrefIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteDbxrefByDbxrefIds(Long[] dbxrefIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param dbxrefId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteDbxrefByDbxrefId(Long dbxrefId);
}
