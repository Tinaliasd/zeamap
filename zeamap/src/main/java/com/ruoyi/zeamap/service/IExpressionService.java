package com.ruoyi.zeamap.service;

import java.util.List;
import com.ruoyi.zeamap.domain.Expression;
import com.ruoyi.zeamap.vo.ExpressionVo;

/**
 * 基因表达量查询Service接口
 * 
 * @author ruoyi
 * @date 2022-11-19
 */
public interface IExpressionService 
{
    /**
     * 查询基因表达量查询
     * 
     * @param expressionId 基因表达量查询主键
     * @return 基因表达量查询
     */
    public Expression selectExpressionByExpressionId(Long expressionId);

    /**
     * 查询基因表达量查询列表
     * 
     * @param expression 基因表达量查询
     * @return 基因表达量查询集合
     */
    public List<Expression> selectExpressionList(Expression expression);

    /**
     * 新增基因表达量查询
     * 
     * @param expression 基因表达量查询
     * @return 结果
     */
    public int insertExpression(Expression expression);

    /**
     * 修改基因表达量查询
     * 
     * @param expression 基因表达量查询
     * @return 结果
     */
    public int updateExpression(Expression expression);

    /**
     * 批量删除基因表达量查询
     * 
     * @param expressionIds 需要删除的基因表达量查询主键集合
     * @return 结果
     */
    public int deleteExpressionByExpressionIds(Long[] expressionIds);

    /**
     * 删除基因表达量查询信息
     * 
     * @param expressionId 基因表达量查询主键
     * @return 结果
     */
    public int deleteExpressionByExpressionId(Long expressionId);

    List<Expression> selectmultiExpressionList(ExpressionVo expressionVo);

}
