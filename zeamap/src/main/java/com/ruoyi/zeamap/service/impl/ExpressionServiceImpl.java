package com.ruoyi.zeamap.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.zeamap.vo.ExpressionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.ExpressionMapper;
import com.ruoyi.zeamap.domain.Expression;
import com.ruoyi.zeamap.service.IExpressionService;

/**
 * 基因表达量查询Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-19
 */
@Service
public class ExpressionServiceImpl implements IExpressionService 
{
    @Autowired
    private ExpressionMapper expressionMapper;



    /**
     * 查询基因表达量查询
     * 
     * @param expressionId 基因表达量查询主键
     * @return 基因表达量查询
     */
    @Override
    public Expression selectExpressionByExpressionId(Long expressionId)
    {
        return expressionMapper.selectExpressionByExpressionId(expressionId);
    }

    /**
     * 查询基因表达量查询列表
     * 
     * @param expression 基因表达量查询
     * @return 基因表达量查询
     */
    @Override
    public List<Expression> selectExpressionList(Expression expression)
    {
        return expressionMapper.selectExpressionList(expression);
    }

    /**
     * 新增基因表达量查询
     * 
     * @param expression 基因表达量查询
     * @return 结果
     */
    @Override
    public int insertExpression(Expression expression)
    {
        expression.setCreateTime(DateUtils.getNowDate());
        return expressionMapper.insertExpression(expression);
    }

    /**
     * 修改基因表达量查询
     * 
     * @param expression 基因表达量查询
     * @return 结果
     */
    @Override
    public int updateExpression(Expression expression)
    {
        expression.setUpdateTime(DateUtils.getNowDate());
        return expressionMapper.updateExpression(expression);
    }

    /**
     * 批量删除基因表达量查询
     * 
     * @param expressionIds 需要删除的基因表达量查询主键
     * @return 结果
     */
    @Override
    public int deleteExpressionByExpressionIds(Long[] expressionIds)
    {
        return expressionMapper.deleteExpressionByExpressionIds(expressionIds);
    }

    /**
     * 删除基因表达量查询信息
     * 
     * @param expressionId 基因表达量查询主键
     * @return 结果
     */
    @Override
    public int deleteExpressionByExpressionId(Long expressionId)
    {
        return expressionMapper.deleteExpressionByExpressionId(expressionId);
    }
    @Override
    public List<Expression> selectmultiExpressionList(ExpressionVo expressionVo) {
        List<Expression> expressions = null;
        if(expressionVo.getFlag() == 1){
           expressions = expressionMapper.selectmultiExpressionListTissue(expressionVo);

        } else if (expressionVo.getFlag() == 2) {
           expressions = expressionMapper.selectmultiExpressionListGermplasm(expressionVo);

        }else{
            expressions = expressionMapper.selectmultiExpressionListEnvironment(expressionVo);

        }
        return expressions;
    }

}
