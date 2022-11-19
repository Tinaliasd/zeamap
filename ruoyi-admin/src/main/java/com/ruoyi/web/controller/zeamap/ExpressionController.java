package com.ruoyi.web.controller.zeamap;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.zeamap.domain.Expression;
import com.ruoyi.zeamap.service.IExpressionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 基因表达量查询Controller
 * 
 * @author ruoyi
 * @date 2022-11-19
 */
@RestController
@RequestMapping("/zeamap/expression")
public class ExpressionController extends BaseController
{
    @Autowired
    private IExpressionService expressionService;

    /**
     * 查询基因表达量查询列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:expression:list')")
    @GetMapping("/list")
    public TableDataInfo list(Expression expression)
    {
        startPage();
        List<Expression> list = expressionService.selectExpressionList(expression);
        return getDataTable(list);
    }

    /**
     * 导出基因表达量查询列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:expression:export')")
    @Log(title = "基因表达量查询", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Expression expression)
    {
        List<Expression> list = expressionService.selectExpressionList(expression);
        ExcelUtil<Expression> util = new ExcelUtil<Expression>(Expression.class);
        util.exportExcel(response, list, "基因表达量查询数据");
    }

    /**
     * 获取基因表达量查询详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:expression:query')")
    @GetMapping(value = "/{expressionId}")
    public AjaxResult getInfo(@PathVariable("expressionId") Long expressionId)
    {
        return AjaxResult.success(expressionService.selectExpressionByExpressionId(expressionId));
    }

    /**
     * 新增基因表达量查询
     */
    @PreAuthorize("@ss.hasPermi('zeamap:expression:add')")
    @Log(title = "基因表达量查询", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Expression expression)
    {
        return toAjax(expressionService.insertExpression(expression));
    }

    /**
     * 修改基因表达量查询
     */
    @PreAuthorize("@ss.hasPermi('zeamap:expression:edit')")
    @Log(title = "基因表达量查询", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Expression expression)
    {
        return toAjax(expressionService.updateExpression(expression));
    }

    /**
     * 删除基因表达量查询
     */
    @PreAuthorize("@ss.hasPermi('zeamap:expression:remove')")
    @Log(title = "基因表达量查询", businessType = BusinessType.DELETE)
	@DeleteMapping("/{expressionIds}")
    public AjaxResult remove(@PathVariable Long[] expressionIds)
    {
        return toAjax(expressionService.deleteExpressionByExpressionIds(expressionIds));
    }
}
