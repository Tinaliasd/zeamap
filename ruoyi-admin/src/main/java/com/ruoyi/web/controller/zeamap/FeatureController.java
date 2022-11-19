package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.Feature;
import com.ruoyi.zeamap.service.IFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * featureController
 * 
 * @author ruoyi
 * @date 2022-10-30
 */
@RestController
@RequestMapping("/zeamap/feature")
public class FeatureController extends BaseController
{
    @Autowired
    private IFeatureService featureService;

    /**
     * 查询feature列表1
     */
    @PreAuthorize("@ss.hasPermi('zeamap:feature:list')")
    @GetMapping("/list")
    public TableDataInfo list(Feature feature)
    {
        startPage();
        List<Feature> list = featureService.selectFeatureList(feature);
        return getDataTable(list);
    }

    /**
     * 导出feature列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:feature:export')")
    @Log(title = "feature", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Feature feature)
    {
        List<Feature> list = featureService.selectFeatureList(feature);
        ExcelUtil<Feature> util = new ExcelUtil<Feature>(Feature.class);
        util.exportExcel(response, list, "feature数据");
    }

    /**
     * 获取feature详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:feature:query')")
    @GetMapping(value = "/{featureId}")
    public AjaxResult getInfo(@PathVariable("featureId") Long featureId)
    {
        return AjaxResult.success(featureService.selectFeatureByFeatureId(featureId));
    }

    /**
     * 新增feature
     */
    @PreAuthorize("@ss.hasPermi('zeamap:feature:add')")
    @Log(title = "feature", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Feature feature)
    {
        return toAjax(featureService.insertFeature(feature));
    }

    /**
     * 修改feature
     */
    @PreAuthorize("@ss.hasPermi('zeamap:feature:edit')")
    @Log(title = "feature", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Feature feature)
    {
        return toAjax(featureService.updateFeature(feature));
    }

    /**
     * 删除feature
     */
    @PreAuthorize("@ss.hasPermi('zeamap:feature:remove')")
    @Log(title = "feature", businessType = BusinessType.DELETE)
	@DeleteMapping("/{featureIds}")
    public AjaxResult remove(@PathVariable Long[] featureIds)
    {
        return toAjax(featureService.deleteFeatureByFeatureIds(featureIds));
    }
}
