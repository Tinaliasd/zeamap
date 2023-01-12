package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.Xot;

/**
 * xotMapper接口
 * 
 * @author ruoyi
 * @date 2023-01-08
 */
public interface XotMapper 
{
    /**
     * 查询xot
     * 
     * @param xotId xot主键
     * @return xot
     */
    public Xot selectXotByXotId(Long xotId);

    /**
     * 查询xot列表
     * 
     * @param xot xot
     * @return xot集合
     */
    public List<Xot> selectXotList(Xot xot);

    /**
     * 新增xot
     * 
     * @param xot xot
     * @return 结果
     */
    public int insertXot(Xot xot);

    /**
     * 修改xot
     * 
     * @param xot xot
     * @return 结果
     */
    public int updateXot(Xot xot);

    /**
     * 删除xot
     * 
     * @param xotId xot主键
     * @return 结果
     */
    public int deleteXotByXotId(Long xotId);

    /**
     * 批量删除xot
     * 
     * @param xotIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXotByXotIds(Long[] xotIds);


    /**
     *
     * @param xot
     * @return
     */

    List<Xot> selectFull(Xot xot);
}
