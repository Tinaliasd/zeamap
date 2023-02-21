package com.ruoyi.zeamap.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.zeamap.domain.Expression;
import com.ruoyi.zeamap.domain.Tissue;
import com.ruoyi.zeamap.mapper.ExpressionMapper;
import com.ruoyi.zeamap.mapper.TissueMapper;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.FeatureMapper;
import com.ruoyi.zeamap.domain.Feature;
import com.ruoyi.zeamap.service.IFeatureService;

/**
 * featureService业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-19
 */
@Service
public class FeatureServiceImpl implements IFeatureService
{
    @Autowired
    private FeatureMapper featureMapper;
    @Autowired
    private TissueMapper tissueMapper;
    @Autowired
    private ExpressionMapper expressionMapper;

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

    /**
     *  通过unquename 查找id
     * @param
     * @return
     */
    @Override
    public Long selectId(String uniquename) {

        return featureMapper.selectByUniquename(uniquename);
    }

    @Override
    public Map<String, String> selectByUniquenameToExpression(String uniquename) {
        Long featureId = selectId(uniquename);//查找id
        if (featureId == null) {
            return null;
        }

        List<Tissue> res = tissueMapper.selectMapTissue(featureId);//查找组织然后转化
        Map<String, String> tissueMap = res.stream().distinct().collect(Collectors.toMap(item -> item.getTissueDesc(), item -> item.getTissueSvgclass()));
        return tissueMap;
    }


    public Map<String,Double> selectByUniquenameToTissue(String unquename) {
        Long featureId = selectId(unquename);

        if (featureId == null) {
            return null;
        }
        List<Expression> res = expressionMapper.selectMapExpression(featureId);

        Map<String, Double> expressMap = res.stream().collect(Collectors.toMap(item -> (item.getTissue().getTissueDesc()), item -> item.getExpressionValue()));

        return expressMap;
    }

}
