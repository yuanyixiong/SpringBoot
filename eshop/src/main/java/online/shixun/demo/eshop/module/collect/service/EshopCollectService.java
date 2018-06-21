/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.collect.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.shixun.demo.eshop.core.service.BeanEnum;
import online.shixun.demo.eshop.core.service.TimeEnum;
import online.shixun.demo.eshop.dto.EshopCollect;
import online.shixun.demo.eshop.dto.EshopCollectCriteria;
import online.shixun.demo.eshop.dto.EshopOrderCriteria;
import online.shixun.demo.eshop.module.collect.mapper.EshopCollectMapper;
import online.shixun.demo.eshop.util.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName EshopCollectService
 * @Description TODO
 * @Date 2018/05/14 14:54
 * @Author shixun.online
 * @Version 1.0
 **/
@Service
public class EshopCollectService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopCollectMapper eshopCollectMapper;

    @Autowired
    private EshopCollectItemService collectItemService;

    /**
     * 收藏列表分页
     *
     * @param collect   检索的基础条件[用户/移除状态/收藏编号/收藏别名]
     * @param timeEnum  检索的时间方式
     * @param beginTime 自定义的检索开始时间
     * @param endTime   自定义的检索结束时间
     * @param pageNum   分页:当前页码
     * @param pageSize  分页:每页显示的数据量
     * @return 分页对象
     * @throws Exception
     */
    public PageInfo<EshopCollect> getCollects(EshopCollect collect, TimeEnum timeEnum, Date beginTime, Date endTime, int pageNum, int pageSize) throws ParseException {
        EshopCollectCriteria eshopCollectCriteria = new EshopCollectCriteria();
        EshopCollectCriteria.Criteria criteria = eshopCollectCriteria.createCriteria();

        //and
        if (Objects.nonNull(collect)) {
            //用户[必传]
            if (Objects.nonNull(collect.getUserId())) {
                criteria.andUserIdEqualTo(collect.getUserId());
            } else {
                throw new NullPointerException("用户编号为空");
            }
            if (Objects.nonNull(collect.getIsDel())) {
                criteria.andIsDelEqualTo(collect.getIsDel());
            }
        } else {
            throw new NullPointerException("用户编号为空");
        }

        // and 时间
        if (Objects.nonNull(timeEnum)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            switch (timeEnum) {
                case TRIMESTER://近三个月内
                    calendar.add(Calendar.MONTH, -3);
                    endTime = new Date();
                    beginTime = calendar.getTime();
                    criteria.andUpdateTimeBetween(beginTime, endTime);
                    break;
                case SEMESTER://近半年内
                    calendar.add(Calendar.MONTH, -6);
                    endTime = new Date();
                    beginTime = calendar.getTime();
                    criteria.andUpdateTimeBetween(beginTime, endTime);
                    break;
                case A_YEAR://今年内
                    endTime = new Date();
                    beginTime = new SimpleDateFormat("yyyy").parse(String.valueOf(calendar.getWeekYear()));
                    criteria.andUpdateTimeBetween(beginTime, endTime);
                    break;
                case TOW_YEARS://过去一年
                    calendar.add(Calendar.YEAR, -1);
                    beginTime = new SimpleDateFormat("yyyy").parse(String.valueOf(calendar.getWeekYear()));
                    endTime = new SimpleDateFormat("yyyy").parse(String.valueOf(calendar.getWeekYear() + 1));
                    criteria.andUpdateTimeBetween(beginTime, endTime);
                    break;
                case THREE_YEARS://过去两年
                    calendar.add(Calendar.YEAR, -2);
                    beginTime = new SimpleDateFormat("yyyy").parse(String.valueOf(calendar.getWeekYear()));
                    endTime = new SimpleDateFormat("yyyy").parse(String.valueOf(calendar.getWeekYear() + 1));
                    criteria.andUpdateTimeBetween(beginTime, endTime);
                    break;
                case FOUR_YEARS://过去三年
                    calendar.add(Calendar.YEAR, -3);
                    beginTime = new SimpleDateFormat("yyyy").parse(String.valueOf(calendar.getWeekYear()));
                    endTime = new SimpleDateFormat("yyyy").parse(String.valueOf(calendar.getWeekYear() + 1));
                    criteria.andUpdateTimeBetween(beginTime, endTime);
                    break;
                case MORE_YEARS://更多
                    calendar.add(Calendar.YEAR, -3);
                    beginTime = new SimpleDateFormat("yyyy").parse(String.valueOf(calendar.getWeekYear()));
                    criteria.andUpdateTimeLessThanOrEqualTo(beginTime);// 三年前的
                    break;
                case USER_DEFINED://用户自定义
                    criteria.andUpdateTimeBetween(beginTime, endTime);
                    break;
            }
        }

        //时间倒序
        eshopCollectCriteria.setOrderByClause("`update_time` DESC,`create_time` DESC");

        //分页
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(eshopCollectMapper.selectByExample(eshopCollectCriteria));
    }


    /**
     * 移除收藏列表-假删
     *
     * @param collect
     * @return
     */
    public int fakeDelete(EshopCollect collect) {
        if (Objects.equals(eshopCollectMapper.selectByPrimaryKey(collect.getId()).getIsDel(), BeanEnum.UNDEL.getIndex())) {
            EshopCollectCriteria example = new EshopCollectCriteria();
            example.createCriteria().andIdEqualTo(collect.getId());
            collect.setIsDel(BeanEnum.DEL.getIndex());
            return eshopCollectMapper.updateByExampleSelective(collect, example);
        }
        return -1;
    }

    /**
     * 移除收藏列表-真删
     *
     * @param collect
     * @return
     */
    public int realDelete(EshopCollect collect) {
        if (Objects.equals(eshopCollectMapper.selectByPrimaryKey(collect.getId()).getIsDel(), BeanEnum.DEL.getIndex())) {
            collectItemService.deleteByCollectId(collect.getId());
            return eshopCollectMapper.deleteByPrimaryKey(collect.getId());
        }
        return -1;
    }

    /**
     * 还原删除
     *
     * @param collect
     * @return
     */
    public int restoreDelete(EshopCollect collect) {
        if (Objects.equals(eshopCollectMapper.selectByPrimaryKey(collect.getId()).getIsDel(), BeanEnum.DEL.getIndex())) {
            EshopCollectCriteria example = new EshopCollectCriteria();
            example.createCriteria().andIdEqualTo(collect.getId());
            collect.setIsDel(BeanEnum.UNDEL.getIndex());
            return eshopCollectMapper.updateByExampleSelective(collect, example);
        }
        return -1;
    }

    /**
     * 加入收藏
     *
     * @param skuId
     * @param userId
     * @return
     */
    @Transient
    public int addCollect(String skuId, String userId) {
        EshopCollect collect = null;
        //找到用户当前的收藏列表
        EshopCollectCriteria eshopCollectCriteria = new EshopCollectCriteria();
        EshopCollectCriteria.Criteria criteria = eshopCollectCriteria.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andCreateTimeEqualTo(new Date());
        List<EshopCollect> list = eshopCollectMapper.selectByExample(eshopCollectCriteria);
        if (Objects.nonNull(list) && list.size() >= 1) {
            collect = list.stream().findFirst().get();
            collect.setCollectNumber(collect.getCollectNumber() + 1);
            eshopCollectMapper.updateByPrimaryKey(collect);
        } else {
            //当天不存在收藏列表
            collect = new EshopCollect(BeanUtils.getId(), BeanEnum.UNDEL.getIndex(), new Date(), new Date(), userId, "暂无", 1, 0);
            eshopCollectMapper.insertSelective(collect);
        }
        //添加收藏项
        return collectItemService.addCollectItem(skuId, collect.getId());
    }
}
