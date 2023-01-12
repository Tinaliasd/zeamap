package com.ruoyi.zeamap.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.PopulationMapper;
import com.ruoyi.zeamap.domain.Population;
import com.ruoyi.zeamap.service.IPopulationService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
@Service
public class PopulationServiceImpl implements IPopulationService 
{
    @Autowired
    private PopulationMapper populationMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param populationId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Population selectPopulationByPopulationId(Long populationId)
    {
        return populationMapper.selectPopulationByPopulationId(populationId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param population 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Population> selectPopulationList(Population population)
    {
        return populationMapper.selectPopulationList(population);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param population 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertPopulation(Population population)
    {
        return populationMapper.insertPopulation(population);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param population 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updatePopulation(Population population)
    {
        return populationMapper.updatePopulation(population);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param populationIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deletePopulationByPopulationIds(Long[] populationIds)
    {
        return populationMapper.deletePopulationByPopulationIds(populationIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param populationId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deletePopulationByPopulationId(Long populationId)
    {
        return populationMapper.deletePopulationByPopulationId(populationId);
    }
}
