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
import com.ruoyi.zeamap.domain.Germplasm;
import com.ruoyi.zeamap.service.IGermplasmService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
@RestController
@RequestMapping("/zeamap/germplasm")
public class GermplasmController extends BaseController
{
    @Autowired
    private IGermplasmService germplasmService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:germplasm:list')")
    @GetMapping("/list")
    public TableDataInfo list(Germplasm germplasm)
    {
        startPage();
        List<Germplasm> list = germplasmService.selectGermplasmList(germplasm);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:germplasm:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Germplasm germplasm)
    {
        List<Germplasm> list = germplasmService.selectGermplasmList(germplasm);
        ExcelUtil<Germplasm> util = new ExcelUtil<Germplasm>(Germplasm.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:germplasm:query')")
    @GetMapping(value = "/{germplasmId}")
    public AjaxResult getInfo(@PathVariable("germplasmId") Long germplasmId)
    {
        return AjaxResult.success(germplasmService.selectGermplasmByGermplasmId(germplasmId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('zeamap:germplasm:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Germplasm germplasm)
    {
        return toAjax(germplasmService.insertGermplasm(germplasm));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('zeamap:germplasm:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Germplasm germplasm)
    {
        return toAjax(germplasmService.updateGermplasm(germplasm));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('zeamap:germplasm:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{germplasmIds}")
    public AjaxResult remove(@PathVariable Long[] germplasmIds)
    {
        return toAjax(germplasmService.deleteGermplasmByGermplasmIds(germplasmIds));
    }

    @GetMapping("/multi")
    public AjaxResult selectorClassDesc(){

        return AjaxResult.success(germplasmService.SelectorSubGroupGermplasm());
    }
}
