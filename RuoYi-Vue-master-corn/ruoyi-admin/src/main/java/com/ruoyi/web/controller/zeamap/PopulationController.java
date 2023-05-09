package com.ruoyi.zeamap.controller;

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
import com.ruoyi.zeamap.domain.Population;
import com.ruoyi.zeamap.service.IPopulationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产品Controller
 * 
 * @author ruoyi
 * @date 2023-03-14
 */
@RestController
@RequestMapping("/zeamap/population")
public class PopulationController extends BaseController
{
    @Autowired
    private IPopulationService populationService;

    /**
     * 查询产品列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:population:list')")
    @GetMapping("/list")
    public TableDataInfo list(Population population)
    {
        startPage();
        List<Population> list = populationService.selectPopulationList(population);
        return getDataTable(list);
    }

    /**
     * 导出产品列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:population:export')")
    @Log(title = "产品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Population population)
    {
        List<Population> list = populationService.selectPopulationList(population);
        ExcelUtil<Population> util = new ExcelUtil<Population>(Population.class);
        util.exportExcel(response, list, "产品数据");
    }

    /**
     * 获取产品详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:population:query')")
    @GetMapping(value = "/{populationId}")
    public AjaxResult getInfo(@PathVariable("populationId") Long populationId)
    {
        return AjaxResult.success(populationService.selectPopulationByPopulationId(populationId));
    }

    /**
     * 新增产品
     */
    @PreAuthorize("@ss.hasPermi('zeamap:population:add')")
    @Log(title = "产品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Population population)
    {
        return toAjax(populationService.insertPopulation(population));
    }

    /**
     * 修改产品
     */
    @PreAuthorize("@ss.hasPermi('zeamap:population:edit')")
    @Log(title = "产品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Population population)
    {
        return toAjax(populationService.updatePopulation(population));
    }

    /**
     * 删除产品
     */
    @PreAuthorize("@ss.hasPermi('zeamap:population:remove')")
    @Log(title = "产品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{populationIds}")
    public AjaxResult remove(@PathVariable Long[] populationIds)
    {
        return toAjax(populationService.deletePopulationByPopulationIds(populationIds));
    }
}
