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
import com.ruoyi.zeamap.domain.Feature;
import com.ruoyi.zeamap.service.IFeatureService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
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
     * 查询【请填写功能名称】列表
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
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:feature:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Feature feature)
    {
        List<Feature> list = featureService.selectFeatureList(feature);
        ExcelUtil<Feature> util = new ExcelUtil<Feature>(Feature.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:feature:query')")
    @GetMapping(value = "/{featureId}")
    public AjaxResult getInfo(@PathVariable("featureId") Long featureId)
    {
        return AjaxResult.success(featureService.selectFeatureByFeatureId(featureId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('zeamap:feature:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Feature feature)
    {
        return toAjax(featureService.insertFeature(feature));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('zeamap:feature:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Feature feature)
    {
        return toAjax(featureService.updateFeature(feature));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('zeamap:feature:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{featureIds}")
    public AjaxResult remove(@PathVariable Long[] featureIds)
    {
        return toAjax(featureService.deleteFeatureByFeatureIds(featureIds));
    }
}
