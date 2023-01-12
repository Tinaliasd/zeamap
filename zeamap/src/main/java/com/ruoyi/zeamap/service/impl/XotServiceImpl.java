package com.ruoyi.zeamap.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.zeamap.vo.XotVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.XotMapper;
import com.ruoyi.zeamap.domain.Xot;
import com.ruoyi.zeamap.service.IXotService;

/**
 * xotService业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-08
 */
@Service
public class XotServiceImpl implements IXotService 
{
    @Autowired
    private XotMapper xotMapper;

    /**
     * 查询xot
     * 
     * @param xotId xot主键
     * @return xot
     */
    @Override
    public Xot selectXotByXotId(Long xotId)
    {
        return xotMapper.selectXotByXotId(xotId);
    }

    /**
     * 查询xot列表
     * 
     * @param xot xot
     * @return xot
     */
    @Override
    public List<Xot> selectXotList(Xot xot)
    {
        return xotMapper.selectXotList(xot);
    }

    /**
     * 新增xot
     * 
     * @param xot xot
     * @return 结果
     */
    @Override
    public int insertXot(Xot xot)
    {
        return xotMapper.insertXot(xot);
    }

    /**
     * 修改xot
     * 
     * @param xot xot
     * @return 结果
     */
    @Override
    public int updateXot(Xot xot)
    {
        return xotMapper.updateXot(xot);
    }

    /**
     * 批量删除xot
     * 
     * @param xotIds 需要删除的xot主键
     * @return 结果
     */
    @Override
    public int deleteXotByXotIds(Long[] xotIds)
    {
        return xotMapper.deleteXotByXotIds(xotIds);
    }

    /**
     * 删除xot信息
     * 
     * @param xotId xot主键
     * @return 结果
     */
    @Override
    public int deleteXotByXotId(Long xotId)
    {
        return xotMapper.deleteXotByXotId(xotId);
    }




    @Override
    public List<XotVo> selectXotFull(Xot xot) {
        List<Xot> xots = xotMapper.selectFull(xot);
        List<XotVo> xotVos = new ArrayList<>();
        for (Xot x:xots) {
            xotVos.add(new XotVo(x.getXotId(), x.getXotUid(), x.getCategory(), x.getType(), x.getAnalysis().getName(),x.getName(), x.getLocation(), x.getTraitDateLoc(), x.getYear(), x.getTissue()));
        }

        return xotVos;
    }

}
