package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.develop.domain.*;
import com.ruoyi.develop.service.IDbxrefService;
import com.ruoyi.develop.service.IFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;

/**
 * featureController
 *
 * @author 温镜蓉
 * @date 2022-10-30
 */
@RestController
@RequestMapping("/system/feature")
public class FeatureController extends BaseController
{
    @Autowired
    private IFeatureService featureService;
    @Autowired
    private IDbxrefService dbxrefService;


    //=====查询条件1的前置需求=====
    /**
     * 在feature表里查询dbxrefId,再通过dbxrefId在dbxref表里查询accession
     */
    @PreAuthorize("@ss.hasAnyRoles({'common','admin'})")
    @GetMapping("/selectAccession")
    public TableDataInfo selectAccession()
    {
        List<String> dbxrefIds = featureService.selectDbxrefId();
        startPage();
        List<String> accession = new LinkedList<>();
        for (String dbxrefId:dbxrefIds) {
            if(dbxrefId != null) {
                accession.add(dbxrefService.selectAccessionByDbxrefId(dbxrefId));
            }
        }
        return getDataTable(accession);
    }
    /**
     * 通过accession在dbxref表里查询version
     */
    @PreAuthorize("@ss.hasAnyRoles({'common','admin'})")
    @GetMapping("/selectVersion")
    public TableDataInfo selectVersion(String accession)
    {
        startPage();
        List<String> list = dbxrefService.selectVersionByAccession(accession);
        return getDataTable(list);
    }


    //=====查询条件2的前置需求=====
    /**
     * 在feature表里查询uniqueName
     */
    @PreAuthorize("@ss.hasAnyRoles({'common','admin'})")
    @GetMapping("/selectUniqueName")
    public TableDataInfo selectUniqueName()
    {
        startPage();
        List<String> uniqueNames = featureService.selectUniqueName();
        return getDataTable(uniqueNames);
    }


    //=====查询=====
    /**
     * 通过queryCriteria的五个条件查询featureId集合,再通过featureId集合在feature和featureloc和dbxref表里查询queryResult
     */
    @PreAuthorize("@ss.hasAnyRoles({'common','admin'})")
    @GetMapping("/enquiry")
    public TableDataInfo selectQueryResult(@RequestBody QueryCriteria queryCriteria)
    {
        startPage();
        List<QueryResult> queryResult = featureService.selectQueryResult(queryCriteria);
        return getDataTable(queryResult);
    }


    //=====下载=====
    /**
     * 通过featureId集合在feature和featureloc和dbxref表里查询queryResult并下载
     */
    @PreAuthorize("@ss.hasAnyRoles({'common','admin'})")
    @PostMapping("/download")
    public void download(HttpServletResponse response,@RequestParam List<String> featureId)
    {
        List<QueryResult> list = new LinkedList<>();
        for (String feature_id : featureId) {
            list.add(featureService.download(feature_id));
        }
        ExcelUtil<QueryResult> util = new ExcelUtil<QueryResult>(QueryResult.class);
        util.exportExcel(response,list,"原始数据");
    }


    //=====跳转=====
    /**
     * 通过featureId在feature,cvterm,dbxref,featureloc,feature_dbxref和cv表里查询skipResult
     */
    @PreAuthorize("@ss.hasAnyRoles({'common','admin'})")
    @GetMapping("/skipResult")
    public SkipResult skip(String featureId)
    {
        SkipResult skipResult = featureService.selectSummary(featureId);
        skipResult.setFunctionAnnotations(featureService.selectFunctionAnnotation(featureId));
        skipResult.setSequences(featureService.selectSequences(featureId));
        return skipResult;
    }

}
