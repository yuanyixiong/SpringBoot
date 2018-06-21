/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.product.service;

import online.shixun.demo.eshop.dto.EshopFeature;
import online.shixun.demo.eshop.module.product.mapper.EshopFeatureMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class EshopFeatureService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopFeatureMapper featureMapper;

    public List<EshopFeature> getFeatures(Collection<String> ids) {
        return featureMapper.getEshopFeaturesByIds(ids);
    }
}
