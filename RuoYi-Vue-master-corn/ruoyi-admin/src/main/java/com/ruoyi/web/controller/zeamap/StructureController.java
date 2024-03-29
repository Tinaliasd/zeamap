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
import com.ruoyi.zeamap.domain.Structure;
import com.ruoyi.zeamap.service.IStructureService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * StructureController
 * 
 * @author ruoyi
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/zeamap/structure")
public class StructureController extends BaseController
{
    @Autowired
    private IStructureService structureService;

    /**
     * 查询Structure列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:structure:list')")
    @GetMapping("/list")
    public TableDataInfo list(Structure structure)
    {
        startPage();
        List<Structure> list = structureService.selectStructureList(structure);
        return getDataTable(list);
    }

    /**
     * 导出Structure列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:structure:export')")
    @Log(title = "Structure", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Structure structure)
    {
        List<Structure> list = structureService.selectStructureList(structure);
        ExcelUtil<Structure> util = new ExcelUtil<Structure>(Structure.class);
        util.exportExcel(response, list, "Structure数据");
    }

    /**
     * 获取Structure详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:structure:query')")
    @GetMapping(value = "/{group}")
    public AjaxResult getInfo(@PathVariable("group") String group)
    {
        return AjaxResult.success(structureService.selectStructureByGroup(group));
    }

    /**
     * 新增Structure
     */
    @PreAuthorize("@ss.hasPermi('zeamap:structure:add')")
    @Log(title = "Structure", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Structure structure)
    {
        return toAjax(structureService.insertStructure(structure));
    }

    /**
     * 修改Structure
     */
    @PreAuthorize("@ss.hasPermi('zeamap:structure:edit')")
    @Log(title = "Structure", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Structure structure)
    {
        return toAjax(structureService.updateStructure(structure));
    }

    /**
     * 删除Structure
     */
    @PreAuthorize("@ss.hasPermi('zeamap:structure:remove')")
    @Log(title = "Structure", businessType = BusinessType.DELETE)
	@DeleteMapping("/{groups}")
    public AjaxResult remove(@PathVariable String[] groups)
    {
        return toAjax(structureService.deleteStructureByGroups(groups));
    }
}
