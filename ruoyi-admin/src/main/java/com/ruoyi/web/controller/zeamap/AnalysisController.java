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
import com.ruoyi.zeamap.domain.Analysis;
import com.ruoyi.zeamap.service.IAnalysisService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * analysisController
 * 
 * @author ruoyi
 * @date 2023-01-08
 */
@RestController
@RequestMapping("/zeamap/analysis")
public class AnalysisController extends BaseController
{
    @Autowired
    private IAnalysisService analysisService;

    /**
     * 查询analysis列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:analysis:list')")
    @GetMapping("/list")
    public TableDataInfo list(Analysis analysis)
    {
        startPage();
        List<Analysis> list = analysisService.selectAnalysisList(analysis);
        return getDataTable(list);
    }

    /**
     * 导出analysis列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:analysis:export')")
    @Log(title = "analysis", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Analysis analysis)
    {
        List<Analysis> list = analysisService.selectAnalysisList(analysis);
        ExcelUtil<Analysis> util = new ExcelUtil<Analysis>(Analysis.class);
        util.exportExcel(response, list, "analysis数据");
    }

    /**
     * 获取analysis详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:analysis:query')")
    @GetMapping(value = "/{analysisId}")
    public AjaxResult getInfo(@PathVariable("analysisId") Long analysisId)
    {
        return AjaxResult.success(analysisService.selectAnalysisByAnalysisId(analysisId));
    }

    /**
     * 新增analysis
     */
    @PreAuthorize("@ss.hasPermi('zeamap:analysis:add')")
    @Log(title = "analysis", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Analysis analysis)
    {
        return toAjax(analysisService.insertAnalysis(analysis));
    }

    /**
     * 修改analysis
     */
    @PreAuthorize("@ss.hasPermi('zeamap:analysis:edit')")
    @Log(title = "analysis", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Analysis analysis)
    {
        return toAjax(analysisService.updateAnalysis(analysis));
    }

    /**
     * 删除analysis
     */
    @PreAuthorize("@ss.hasPermi('zeamap:analysis:remove')")
    @Log(title = "analysis", businessType = BusinessType.DELETE)
	@DeleteMapping("/{analysisIds}")
    public AjaxResult remove(@PathVariable Long[] analysisIds)
    {
        return toAjax(analysisService.deleteAnalysisByAnalysisIds(analysisIds));
    }
}
