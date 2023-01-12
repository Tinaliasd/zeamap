package com.ruoyi.zeamap.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.AnalysisMapper;
import com.ruoyi.zeamap.domain.Analysis;
import com.ruoyi.zeamap.service.IAnalysisService;

/**
 * analysisService业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-08
 */
@Service
public class AnalysisServiceImpl implements IAnalysisService 
{
    @Autowired
    private AnalysisMapper analysisMapper;

    /**
     * 查询analysis
     * 
     * @param analysisId analysis主键
     * @return analysis
     */
    @Override
    public Analysis selectAnalysisByAnalysisId(Long analysisId)
    {
        return analysisMapper.selectAnalysisByAnalysisId(analysisId);
    }

    /**
     * 查询analysis列表
     * 
     * @param analysis analysis
     * @return analysis
     */
    @Override
    public List<Analysis> selectAnalysisList(Analysis analysis)
    {
        return analysisMapper.selectAnalysisList(analysis);
    }

    /**
     * 新增analysis
     * 
     * @param analysis analysis
     * @return 结果
     */
    @Override
    public int insertAnalysis(Analysis analysis)
    {
        return analysisMapper.insertAnalysis(analysis);
    }

    /**
     * 修改analysis
     * 
     * @param analysis analysis
     * @return 结果
     */
    @Override
    public int updateAnalysis(Analysis analysis)
    {
        return analysisMapper.updateAnalysis(analysis);
    }

    /**
     * 批量删除analysis
     * 
     * @param analysisIds 需要删除的analysis主键
     * @return 结果
     */
    @Override
    public int deleteAnalysisByAnalysisIds(Long[] analysisIds)
    {
        return analysisMapper.deleteAnalysisByAnalysisIds(analysisIds);
    }

    /**
     * 删除analysis信息
     * 
     * @param analysisId analysis主键
     * @return 结果
     */
    @Override
    public int deleteAnalysisByAnalysisId(Long analysisId)
    {
        return analysisMapper.deleteAnalysisByAnalysisId(analysisId);
    }
}
