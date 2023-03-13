package com.ruoyi.web.controller.zeamap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.jdbc.Null;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public AjaxResult remove(@PathVariable Long[] featureIds){
        return toAjax(featureService.deleteFeatureByFeatureIds(featureIds));
    }

    /**
     * 5.1的一个请求
     * @param uniquename
     * @return
     */
    @GetMapping("/uniquename1")
    public AjaxResult TissueDescSvg(@RequestParam String uniquename) {
        //这两个接口没有问题但是数据造起来太麻烦了,看以后数据咋样把,目前写死了
        Map<String, String> DataMap = featureService.selectByUniquenameToExpression(uniquename);
//        if (DataMap == null){//查询不到
//            return AjaxResult.error("此基因在库中不存在");
//        }



//        return AjaxResult.success(DataMap);

        HashMap<String, String> map1 = new HashMap<>();

        map1.put("B73_6-7_internode", "Internode-short");
        map1.put("B73_7-8_internode", "Internode-long");
        map1.put("B73_Vegetative_Meristem_16-19_Day", "SAM");
        map1.put("B73_Ear_Primordium_2-4_mm", "Ear-PrimordiumSmall");
        map1.put("B73_Ear_Primordium_6-8_mm", "Ear-PrimordiumBig");
        map1.put("B73_Embryo_20_DAP", "Kernel-GerminatingSmall");
        map1.put("B73_Embryo_38_DAP", "Kernel-GerminatingBig");
        map1.put("B73_Endosperm_12_DAP", "Kernel-Endosperm");
        map1.put("B73_Endosperm_Crown_27_DAP", "Kernel-Crown");
        map1.put("B73_Germinatin_Kernels_2_DAI", "Kernel-Kernel");
        map1.put("B73_Pericarp_Aleurone_27_DAP", "Kernel-Pericarp");
        map1.put("B73_Leaf_Zone_1_Symmetrical", "Leaf-YoungZone1");
        map1.put("B73_Leaf_Zone_2_Stomatal", "Leaf-YoungZone2");
        map1.put("B73_Leaf_Zone_3_Growth", "Leaf-YoungZone3");
        map1.put("B73_Mature_Leaf_8", "Leaf-Mature");
        map1.put("B73_Primary_Root_5_Days", "Root-Primary");
        map1.put("B73_Root_Cortex_5_Days", "Root-Cortex");
        map1.put("B73_Root_Elongation_Zone_5_Days", "Root-Elongation");
        map1.put("B73_Root_Meristem_Zone_5_Days", "Root-Division");
        map1.put("B73_Secondary_Root_7-8_Days", "Root-Secondary");
        map1.put("B73_Mature_Pollen", "Tassel-Pollen");
        map1.put("B73_Female_Spikelet_Collected_on_day_as_silk", "Ear-Ear");
        map1.put("B73_Silk", "Ear-Silk");
        return AjaxResult.success(map1);

    }

    @GetMapping("/uniquename2")
    public AjaxResult ExpressionTissue(@RequestParam String uniquename) {
        //这两个接口没有问题但是数据造起来太麻烦了,看以后数据咋样把,目前写死了

        Map<String, String> DataMap = featureService.selectByUniquenameToExpression(uniquename);

//        if (DataMap == null){//查询不到
//            return AjaxResult.error("此基因在库中不存在");
//        }

//        return AjaxResult.success(DataMap);

        HashMap<String, String> res = new HashMap<>();
        res.put("geneID", "Zm00001d000001");
        res.put("B73_6-7_internode", "534.3606667");
        res.put("B73_7-8_internode", "937.3466667");
        res.put("B73_Vegetative_Meristem_16-19_Day", "1466.885");
        res.put("B73_Ear_Primordium_2-4_mm", "50.9252");
        res.put("B73_Ear_Primordium_6-8_mm", "54.59923333");
        res.put("B73_Embryo_20_DAP", "1.584866667");
        res.put("B73_Embryo_38_DAP", "11.17333667");
        res.put("B73_Endosperm_12_DAP", "0");
        res.put("B73_Endosperm_Crown_27_DAP", "1.27837");
        res.put("B73_Germinatin_Kernels_2_DAI", "21.5213");
        res.put("B73_Pericarp_Aleurone_27_DAP", "11.22052333");
        res.put("B73_Leaf_Zone_1_Symmetrical", "565.1873333");
        res.put("B73_Leaf_Zone_2_Stomatal", "169.073");
        res.put("B73_Leaf_Zone_3_Growth", "48.85053333");
        res.put("B73_Mature_Leaf_8", "6.38015");
        res.put("B73_Primary_Root_5_Days", "4.403233333");
        res.put("B73_Root_Cortex_5_Days", "4.862066667");
        res.put("B73_Root_Elongation_Zone_5_Days", "2.22319");
        res.put("B73_Root_Meristem_Zone_5_Days", "7.265293333");
        res.put("B73_Secondary_Root_7-8_Days", "7.57871");
        res.put("B73_Mature_Pollen", "1.56354");
        res.put("B73_Female_Spikelet_Collected_on_day_as_silk", "136.839");
        res.put("B73_Silk", "1376.44666");
        return AjaxResult.success(res);
    }



}
