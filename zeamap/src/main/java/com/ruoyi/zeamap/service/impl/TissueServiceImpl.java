package com.ruoyi.zeamap.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.TissueMapper;
import com.ruoyi.zeamap.domain.Tissue;
import com.ruoyi.zeamap.service.ITissueService;

/**
 * 组织Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-19
 */
@Service
public class TissueServiceImpl implements ITissueService 
{
    @Autowired
    private TissueMapper tissueMapper;

    /**
     * 查询组织
     * 
     * @param tissueId 组织主键
     * @return 组织
     */
    @Override
    public Tissue selectTissueByTissueId(Long tissueId)
    {
        return tissueMapper.selectTissueByTissueId(tissueId);
    }

    /**
     * 查询组织列表
     * 
     * @param tissue 组织
     * @return 组织
     */
    @Override
    public List<Tissue> selectTissueList(Tissue tissue)
    {
        return tissueMapper.selectTissueList(tissue);
    }

    /**
     * 新增组织
     * 
     * @param tissue 组织
     * @return 结果
     */
    @Override
    public int insertTissue(Tissue tissue)
    {
        tissue.setCreateTime(DateUtils.getNowDate());
        return tissueMapper.insertTissue(tissue);
    }

    /**
     * 修改组织
     * 
     * @param tissue 组织
     * @return 结果
     */
    @Override
    public int updateTissue(Tissue tissue)
    {
        tissue.setUpdateTime(DateUtils.getNowDate());
        return tissueMapper.updateTissue(tissue);
    }

    /**
     * 批量删除组织
     * 
     * @param tissueIds 需要删除的组织主键
     * @return 结果
     */
    @Override
    public int deleteTissueByTissueIds(Long[] tissueIds)
    {
        return tissueMapper.deleteTissueByTissueIds(tissueIds);
    }

    /**
     * 删除组织信息
     * 
     * @param tissueId 组织主键
     * @return 结果
     */
    @Override
    public int deleteTissueByTissueId(Long tissueId)
    {
        return tissueMapper.deleteTissueByTissueId(tissueId);
    }
}
