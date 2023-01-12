package com.ruoyi.web.controller.zeamap;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.zeamap.domain.Analysis;
import com.ruoyi.zeamap.domain.Xot;
import com.ruoyi.zeamap.vo.XotVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.zeamap.service.IXotService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * xotController
 * 
 * @author ruoyi
 * @date 2023-01-08
 */
@RestController
@RequestMapping("/zeamap/xot")
public class XotController extends BaseController
{
    @Autowired
    private IXotService xotService;

    /**
     * 查询xot列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:xot:list')")
    @GetMapping("/list")
    public TableDataInfo list(Xot xot)
    {
        startPage();
        List<Xot> list = xotService.selectXotList(xot);
        return getDataTable(list);
    }

    /**
     * 导出xot列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:xot:export')")
    @Log(title = "xot", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Xot xot)
    {
        List<Xot> list = xotService.selectXotList(xot);
        ExcelUtil<Xot> util = new ExcelUtil<Xot>(Xot.class);
        util.exportExcel(response, list, "xot数据");
    }

    /**
     * 获取xot详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:xot:query')")
    @GetMapping(value = "/{xotId}")
    public AjaxResult getInfo(@PathVariable("xotId") Long xotId)
    {
        return AjaxResult.success(xotService.selectXotByXotId(xotId));
    }

    /**
     * 新增xot
     */
    @PreAuthorize("@ss.hasPermi('zeamap:xot:add')")
    @Log(title = "xot", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Xot xot)
    {
        return toAjax(xotService.insertXot(xot));
    }

    /**
     * 修改xot
     */
    @PreAuthorize("@ss.hasPermi('zeamap:xot:edit')")
    @Log(title = "xot", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Xot xot)
    {
        return toAjax(xotService.updateXot(xot));
    }

    /**
     * 删除xot
     */
    @PreAuthorize("@ss.hasPermi('zeamap:xot:remove')")
    @Log(title = "xot", businessType = BusinessType.DELETE)
	@DeleteMapping("/{xotIds}")
    public AjaxResult remove(@PathVariable Long[] xotIds)
    {
        return toAjax(xotService.deleteXotByXotIds(xotIds));
    }



    @GetMapping("/xots")
    public TableDataInfo XotFind(@RequestParam(required = false) String category,@RequestParam(required = false) String type,@RequestParam(required = false) String analysis,
                                 @RequestParam(required = false) String name,@RequestParam(required = false) String location,@RequestParam(required = false) String year,
                                 @RequestParam(required = false) String tissue,@RequestParam(required = false) String traitDateLoc) {

        startPage();
        Xot xot = new Xot();
        xot.setCategory(category);
        xot.setType(type);
        Analysis a = new Analysis();
        a.setName(analysis);
        xot.setAnalysis(a);
        xot.setName(name);
        xot.setLocation(location);
        xot.setTissue(tissue);
        xot.setTraitDateLoc(traitDateLoc);
        xot.setYear(year);
        List<XotVo> list = xotService.selectXotFull(xot);
        return getDataTable(list);
    }
}
