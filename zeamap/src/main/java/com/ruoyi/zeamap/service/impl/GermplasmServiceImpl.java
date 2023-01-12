package com.ruoyi.zeamap.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.zeamap.domain.Tissue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.GermplasmMapper;
import com.ruoyi.zeamap.domain.Germplasm;
import com.ruoyi.zeamap.service.IGermplasmService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
@Service
public class GermplasmServiceImpl implements IGermplasmService 
{
    @Autowired
    private GermplasmMapper germplasmMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param germplasmId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Germplasm selectGermplasmByGermplasmId(Long germplasmId)
    {
        return germplasmMapper.selectGermplasmByGermplasmId(germplasmId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param germplasm 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Germplasm> selectGermplasmList(Germplasm germplasm)
    {
        return germplasmMapper.selectGermplasmList(germplasm);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param germplasm 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertGermplasm(Germplasm germplasm)
    {
        return germplasmMapper.insertGermplasm(germplasm);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param germplasm 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateGermplasm(Germplasm germplasm)
    {
        return germplasmMapper.updateGermplasm(germplasm);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param germplasmIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteGermplasmByGermplasmIds(Long[] germplasmIds)
    {
        return germplasmMapper.deleteGermplasmByGermplasmIds(germplasmIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param germplasmId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteGermplasmByGermplasmId(Long germplasmId)
    {
        return germplasmMapper.deleteGermplasmByGermplasmId(germplasmId);
    }


    @Override
    public Map<String, List<String>> SelectorSubGroupGermplasm() {
        List<Germplasm> germplasms = germplasmMapper.SelectorSubGroupGermplasm();

        //组合成一个key 对应多个value
        Map<String, List<String>> g = new HashMap<>();

        for (Germplasm germplasm:germplasms) {
            if (g.get(germplasm.getSubgroup().getName())!=null){
                List<String> germNames = new ArrayList<>();
                germNames.add(germplasm.getName());
                g.put(germplasm.getSubgroup().getName(), germNames);
            }else{
                List<String> germNames = g.get(germplasm.getSubgroup().getName());
                germNames.add(germplasm.getName());
            }
        }

        return g;
    }
}
