package com.ruoyi.develop.service.impl;

import com.ruoyi.develop.domain.FunctionAnnotation;
import com.ruoyi.develop.domain.QueryCriteria;
import com.ruoyi.develop.domain.QueryResult;
import com.ruoyi.develop.domain.SkipResult;
import com.ruoyi.develop.mapper.FeatureMapper;
import com.ruoyi.develop.service.IFeatureService;
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
public class FeatureServiceImpl implements IFeatureService
{
    @Autowired
    private FeatureMapper featureMapper;

    /**
     * 在feature表里查询dbxrefId
     *
     * @return dbxrefId的list
     */
    public List<String> selectDbxrefId(){
        return featureMapper.selectDbxrefId();
    }

    /**
     * 在feature表里查询uniqueName
     *
     * @return uniqueName的list
     */
    public List<String> selectUniqueName(){
        return featureMapper.selectUniqueName();
    }

    /**
     * 通过queryCriteria的五个条件查询featureId集合,再通过featureId集合在feature和featureloc和dbxref表里查询queryResult
     *
     * @param queryCriteria
     * @return queryResult的list
     */
    public List<QueryResult> selectQueryResult(QueryCriteria queryCriteria){
        return featureMapper.selectQueryResult(queryCriteria);
    }

    /**
     * 通过featureId集合在feature和featureloc和dbxref表里查询queryResult并下载
     *
     * @param feature_id
     * @return queryResult
     */
    public QueryResult download(String feature_id){
        return featureMapper.download(feature_id);
    }

    /**
     * 通过featureId在feature,cvterm,dbxref,featureloc,feature_dbxref和cv表里查询skipResult
     *
     * @param feature_id
     * @return Summary
     */
    public SkipResult selectSummary(String feature_id){
        return featureMapper.selectSummary(feature_id);
    }

    /**
     * 通过featureId在feature,cvterm,dbxref,featureloc,feature_dbxref和cv表里查询functionAnnotation
     *
     * @param feature_id
     * @return functionAnnotation的list
     */
    public List<FunctionAnnotation> selectFunctionAnnotation(String feature_id) {
        return featureMapper.selectFunctionAnnotation(feature_id);
    }

    /**
     * 通过featureId在feature表里查询sequences
     *
     * @param feature_id
     * @return String
     */
    public String selectSequences(String feature_id) {
        return featureMapper.selectSequences(feature_id);
    }
}
