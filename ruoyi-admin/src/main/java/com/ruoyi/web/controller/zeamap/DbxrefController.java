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
import com.ruoyi.zeamap.domain.Dbxref;
import com.ruoyi.zeamap.service.IDbxrefService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
@RestController
@RequestMapping("/zeamap/dbxref")
public class DbxrefController extends BaseController
{
    @Autowired
    private IDbxrefService dbxrefService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:dbxref:list')")
    @GetMapping("/list")
    public TableDataInfo list(Dbxref dbxref)
    {
        startPage();
        List<Dbxref> list = dbxrefService.selectDbxrefList(dbxref);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:dbxref:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Dbxref dbxref)
    {
        List<Dbxref> list = dbxrefService.selectDbxrefList(dbxref);
        ExcelUtil<Dbxref> util = new ExcelUtil<Dbxref>(Dbxref.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:dbxref:query')")
    @GetMapping(value = "/{dbxrefId}")
    public AjaxResult getInfo(@PathVariable("dbxrefId") Long dbxrefId)
    {
        return AjaxResult.success(dbxrefService.selectDbxrefByDbxrefId(dbxrefId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('zeamap:dbxref:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Dbxref dbxref)
    {
        return toAjax(dbxrefService.insertDbxref(dbxref));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('zeamap:dbxref:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Dbxref dbxref)
    {
        return toAjax(dbxrefService.updateDbxref(dbxref));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('zeamap:dbxref:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{dbxrefIds}")
    public AjaxResult remove(@PathVariable Long[] dbxrefIds)
    {
        return toAjax(dbxrefService.deleteDbxrefByDbxrefIds(dbxrefIds));
    }
}
