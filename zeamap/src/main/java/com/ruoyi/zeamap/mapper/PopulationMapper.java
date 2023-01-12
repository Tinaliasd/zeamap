package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.Population;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
public interface PopulationMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param populationId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Population selectPopulationByPopulationId(Long populationId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param population 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Population> selectPopulationList(Population population);

    /**
     * 新增【请填写功能名称】
     * 
     * @param population 【请填写功能名称】
     * @return 结果
     */
    public int insertPopulation(Population population);

    /**
     * 修改【请填写功能名称】
     * 
     * @param population 【请填写功能名称】
     * @return 结果
     */
    public int updatePopulation(Population population);

    /**
     * 删除【请填写功能名称】
     * 
     * @param populationId 【请填写功能名称】主键
     * @return 结果
     */
    public int deletePopulationByPopulationId(Long populationId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param populationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePopulationByPopulationIds(Long[] populationIds);
}
