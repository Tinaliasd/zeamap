package com.ruoyi.zeamap.service;

import java.util.List;
import com.ruoyi.zeamap.domain.Feature;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2022-10-30
 */
public interface IFeatureService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param featureId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Feature selectFeatureByFeatureId(Long featureId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param feature 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Feature> selectFeatureList(Feature feature);

    /**
     * 新增【请填写功能名称】
     * 
     * @param feature 【请填写功能名称】
     * @return 结果
     */
    public int insertFeature(Feature feature);

    /**
     * 修改【请填写功能名称】
     * 
     * @param feature 【请填写功能名称】
     * @return 结果
     */
    public int updateFeature(Feature feature);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param featureIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteFeatureByFeatureIds(Long[] featureIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param featureId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteFeatureByFeatureId(Long featureId);
}
