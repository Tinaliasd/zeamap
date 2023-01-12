package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.Analysis;

/**
 * analysisMapper接口
 * 
 * @author ruoyi
 * @date 2023-01-08
 */
public interface AnalysisMapper 
{
    /**
     * 查询analysis
     * 
     * @param analysisId analysis主键
     * @return analysis
     */
    public Analysis selectAnalysisByAnalysisId(Long analysisId);

    /**
     * 查询analysis列表
     * 
     * @param analysis analysis
     * @return analysis集合
     */
    public List<Analysis> selectAnalysisList(Analysis analysis);

    /**
     * 新增analysis
     * 
     * @param analysis analysis
     * @return 结果
     */
    public int insertAnalysis(Analysis analysis);

    /**
     * 修改analysis
     * 
     * @param analysis analysis
     * @return 结果
     */
    public int updateAnalysis(Analysis analysis);

    /**
     * 删除analysis
     * 
     * @param analysisId analysis主键
     * @return 结果
     */
    public int deleteAnalysisByAnalysisId(Long analysisId);

    /**
     * 批量删除analysis
     * 
     * @param analysisIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAnalysisByAnalysisIds(Long[] analysisIds);
}
