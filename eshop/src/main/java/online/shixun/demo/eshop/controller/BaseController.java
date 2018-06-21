/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName BaseController
 * @Description TODO
 * @Date 2018/05/14 17:32
 * @Author shixun.online
 * @Version 1.0
 **/
public class BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 实现Spring Date 日期格式的转换
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        //自动转换日期类型的字段格式
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {

                //初始化允许的时间格式
                List<SimpleDateFormat> formatList = new ArrayList<>();
                formatList.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                formatList.add(new SimpleDateFormat("yyyy-MM-dd"));
                formatList.add(new SimpleDateFormat("yyyy-MM"));
                formatList.add(new SimpleDateFormat("yyyy"));
                Date date = null;

                //格式化时间
                for (SimpleDateFormat format : formatList) {
                    //防止空数据出错
                    if (StringUtils.isNotBlank(text)) {
                        try {
                            date = format.parse(text);
                            break;
                        } catch (ParseException e) {
                            continue;
                        }
                    }
                }

                if (Objects.nonNull(text) && Objects.isNull(date)) {
                    logger.error("自动绑定日期数据出错");
                }

                super.setValue(date);
            }
        });
    }

}
