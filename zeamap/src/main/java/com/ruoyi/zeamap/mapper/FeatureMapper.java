package com.ruoyi.zeamap.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.zeamap.domain.Feature;
import com.ruoyi.zeamap.domain.Tissue;

/**
 * featureMapper接口
 * 
 * @author ruoyi
 * @date 2022-11-19
 */
public interface FeatureMapper 
{
    /**
     * 查询feature
     * 
     * @param featureId feature主键
     * @return feature
     */
    public Feature selectFeatureByFeatureId(Long featureId);

    /**
     * 查询feature列表
     * 
     * @param feature feature
     * @return feature集合
     */
    public List<Feature> selectFeatureList(Feature feature);

    /**
     * 新增feature
     * 
     * @param feature feature
     * @return 结果
     */
    public int insertFeature(Feature feature);

    /**
     * 修改feature
     * 
     * @param feature feature
     * @return 结果
     */
    public int updateFeature(Feature feature);

    /**
     * 删除feature
     * 
     * @param featureId feature主键
     * @return 结果
     */
    public int deleteFeatureByFeatureId(Long featureId);

    /**
     * 批量删除feature
     * 
     * @param featureIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFeatureByFeatureIds(Long[] featureIds);

    public int selectByUniquename(String uniquename);

    public List<Tissue> selectMapTissue(int feature_id);
}
