package com.ruoyi.web;

import com.ruoyi.web.controller.zeamap.TissueController;
import com.ruoyi.zeamap.domain.Feature;
import com.ruoyi.zeamap.domain.Tissue;
import com.ruoyi.zeamap.service.IFeatureService;
import com.ruoyi.zeamap.service.impl.TissueServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



/**
 * @program: ruoyi
 * @description: test
 * @author: Tinaliasd
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class FeatureTss {
    @Autowired
    private IFeatureService featureService;

    @Autowired
    private TissueController tissueController;

    @Test
    public void testFeature() {

        tissueController.selectorClassDesc();

    }



}
