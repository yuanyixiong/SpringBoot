/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.activity.service;

import online.shixun.demo.eshop.core.service.BeanEnum;
import online.shixun.demo.eshop.dto.EshopActivity;
import online.shixun.demo.eshop.dto.EshopActivityCriteria;
import online.shixun.demo.eshop.module.activity.mapper.EshopActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EshopActivityService {

    @Autowired
    private EshopActivityMapper activityMapper;

    public List<EshopActivity> getActivitys(EshopActivity activity) {
        EshopActivityCriteria eshopActivityCriteria = new EshopActivityCriteria();
        EshopActivityCriteria.Criteria criteria = eshopActivityCriteria.createCriteria();
        criteria.andIsDelEqualTo(BeanEnum.UNDEL.getIndex());//未删
        if (Objects.nonNull(activity)) {
            //其他条件
        }
        //升序排序，越小越靠前
        eshopActivityCriteria.setOrderByClause("activity_index asc");
        return activityMapper.selectByExample(eshopActivityCriteria);
    }
}
