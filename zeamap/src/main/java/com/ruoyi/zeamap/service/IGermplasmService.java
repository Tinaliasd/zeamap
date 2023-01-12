package com.ruoyi.zeamap.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.zeamap.domain.Germplasm;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
public interface IGermplasmService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param germplasmId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Germplasm selectGermplasmByGermplasmId(Long germplasmId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param germplasm 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Germplasm> selectGermplasmList(Germplasm germplasm);

    /**
     * 新增【请填写功能名称】
     * 
     * @param germplasm 【请填写功能名称】
     * @return 结果
     */
    public int insertGermplasm(Germplasm germplasm);

    /**
     * 修改【请填写功能名称】
     * 
     * @param germplasm 【请填写功能名称】
     * @return 结果
     */
    public int updateGermplasm(Germplasm germplasm);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param germplasmIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteGermplasmByGermplasmIds(Long[] germplasmIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param germplasmId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteGermplasmByGermplasmId(Long germplasmId);

    public Map<String,List<String>> SelectorSubGroupGermplasm();
}
