package com.ruoyi.web;

import com.ruoyi.zeamap.domain.Feature;
import com.ruoyi.zeamap.domain.Tissue;
import com.ruoyi.zeamap.service.IFeatureService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

        featureService.selectByUniquenameToExpression("111").forEach((e,v) -> System.out.println(e+" "+v));

    }

}
