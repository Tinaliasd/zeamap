package com.ruoyi.web;

import com.ruoyi.zeamap.domain.Feature;
import com.ruoyi.zeamap.service.IFeatureService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: ruoyi
 * @description: test
 * @author: Tinaliasd
 **/
@SpringBootTest
public class FeatureTss {
    @Autowired
    private IFeatureService featureService;


    @Test
    public void testFeature() {
        Feature feature = new Feature();
        feature.setCommonname("z1");
        featureService.selectFeatureList(feature);
    }

}
