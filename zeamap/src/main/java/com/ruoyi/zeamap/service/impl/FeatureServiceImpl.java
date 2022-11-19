package com.ruoyi.zeamap.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.FeatureMapper;
import com.ruoyi.zeamap.domain.Feature;
import com.ruoyi.zeamap.service.IFeatureService;

/**
 * featureService业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-30
 */
@Service
public class FeatureServiceImpl implements IFeatureService 
{
    @Autowired
    private FeatureMapper featureMapper;

    /**
     * 查询feature
     * 
     * @param featureId feature主键
     * @return feature
     */
    @Override
    public Feature selectFeatureByFeatureId(Long featureId)
    {
        return featureMapper.selectFeatureByFeatureId(featureId);
    }

    /**
     * 查询feature列表
     * 
     * @param feature feature
     * @return feature
     */
    @Override
    public List<Feature> selectFeatureList(Feature feature)
    {
        return featureMapper.selectFeatureList(feature);
    }

    /**
     * 新增feature
     * 
     * @param feature feature
     * @return 结果
     */
    @Override
    public int insertFeature(Feature feature)
    {
        feature.setCreateTime(DateUtils.getNowDate());
        return featureMapper.insertFeature(feature);
    }

    /**
     * 修改feature
     * 
     * @param feature feature
     * @return 结果
     */
    @Override
    public int updateFeature(Feature feature)
    {
        feature.setUpdateTime(DateUtils.getNowDate());
        return featureMapper.updateFeature(feature);
    }

    /**
     * 批量删除feature
     * 
     * @param featureIds 需要删除的feature主键
     * @return 结果
     */
    @Override
    public int deleteFeatureByFeatureIds(Long[] featureIds)
    {
        return featureMapper.deleteFeatureByFeatureIds(featureIds);
    }

    /**
     * 删除feature信息
     * 
     * @param featureId feature主键
     * @return 结果
     */
    @Override
    public int deleteFeatureByFeatureId(Long featureId)
    {
        return featureMapper.deleteFeatureByFeatureId(featureId);
    }
}
