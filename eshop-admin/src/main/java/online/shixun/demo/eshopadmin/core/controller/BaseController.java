/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.core.controller;

import online.shixun.demo.eshopadmin.core.model.BaseModel;
import online.shixun.demo.eshopadmin.core.response.ResponseData;
import online.shixun.demo.eshopadmin.core.service.BaseServiceAbstractPage;
import online.shixun.demo.eshopadmin.core.service.BeanEnum;
import online.shixun.demo.eshopadmin.core.service.ProductEnum;
import online.shixun.demo.eshopadmin.model.EshopProductModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 通用的控制器
 */
public abstract class BaseController<Model extends BaseModel, ID extends Serializable> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    protected BaseServiceAbstractPage<Model, ID> baseServiceAbstractPage; //基础服务

    @Value("${system.page.size}")
    protected Integer pageSize;//分页页码 application.yml 文件注入

    /**
     * 模块主页请求
     *
     * @return
     */
    public abstract String getMainPageUrl();

    /**
     * 模块编辑页请求
     *
     * @return
     */
    public abstract String getFromPageUrl();

    /**
     * 存储图片的服务器
     *
     * @param request
     * @return
     */
    protected String getImageHome(HttpServletRequest request) {
        return request.getSession().getServletContext().getRealPath("/");
    }

    /**
     * 注入基础服务
     *
     * @param baseServiceAbstractPage
     */
    public BaseController(BaseServiceAbstractPage baseServiceAbstractPage) {
        this.baseServiceAbstractPage = baseServiceAbstractPage;
    }

    /**
     * 进入模块主页
     *
     * @param mav
     * @return
     */
    @GetMapping("/main")
    public ModelAndView main(ModelAndView mav) {
        mav.setViewName(this.getMainPageUrl());
        return mav;
    }


    /***
     * 进入模块编辑界面(添加，详情，编辑)
     * @param mav
     * @param action add/edit/info
     * @param id
     * @return
     */
    @GetMapping("/from")
    public ModelAndView from(ModelAndView mav, String action, ID id, HttpServletRequest request) {
        Model model = null;
        if (action.equals("edit") || action.equals("info")) {
            try {
                model = (Model) baseServiceAbstractPage.getModel(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        mav.addObject("model", model);
        mav.addObject("action", action);
        mav.setViewName(this.getFromPageUrl());
        return mav;
    }

    /**
     * 保存数据
     *
     * @param model
     * @return
     */
    @PostMapping("/save")
    public ResponseData save(Model model) {
        ResponseData responseData = new ResponseData();
        try {
            //第一次保存数据设置创建时间
            if (Objects.isNull(model.getCreateTime())) {
                model.setCreateTime(new Date());
            }
            //每次执行保存，记录更新时间
            model.setUpdateTime(new Date());
            baseServiceAbstractPage.editModel(model, (ID) model.getId());
            responseData.setData("保存成功");
        } catch (Exception e) {
            responseData.setError(e.getMessage());
        }
        return responseData;
    }


    /**
     * 根据数据编号查询数据
     *
     * @param id
     * @return
     */
    @GetMapping("/getModel")
    public ResponseData getModel(ID id) {
        ResponseData responseData = new ResponseData();
        try {
            responseData.setData(baseServiceAbstractPage.getModel(id));
        } catch (Exception e) {
            responseData.setError(e.getMessage());
        }
        return responseData;
    }

    /**
     * 根据数据编号检查是否存在重复
     *
     * @param id
     * @return
     */
    @GetMapping("/inspectRepeat")
    public ResponseData inspectRepeat(ID id) {
        ResponseData responseData = new ResponseData();
        try {
            //检索不到数据，不存在重复，反之存在重复
            baseServiceAbstractPage.getModel(id);
        } catch (Exception e) {
            responseData.setError(e.getMessage());
        }
        return responseData;
    }

    /**
     * 根据数据编号删除数据[真删]
     *
     * @param id      删除的ID
     * @param request 同步删除数据对应的资源
     * @return
     */
    @GetMapping("/deleteReal")
    public ResponseData deleteReal(ID id, HttpServletRequest request) {
        ResponseData responseData = new ResponseData();
        try {
            Model model = baseServiceAbstractPage.getModel(id);
            if (Objects.equals(model.getIsDel(), BeanEnum.UNDEL.getIndex())) {
                responseData.setError("非回收站数据，无法直接清除");
                return responseData;
            }
            baseServiceAbstractPage.deleteModel(id);
            responseData.setData("清除成功");
        } catch (Exception e) {
            responseData.setError(e.getMessage());
        }
        return responseData;
    }

    /**
     * 根据数据编号删除数据[假删]
     *
     * @param id
     * @return
     */
    @GetMapping("/deleteFake")
    public ResponseData deleteFake(ID id) {
        ResponseData responseData = new ResponseData();
        try {
            Model model = baseServiceAbstractPage.getModel(id);
            if (Objects.equals(model.getIsDel(), BeanEnum.DEL.getIndex())) {
                responseData.setError("请勿重复加入回收站");
                return responseData;
            }
            if (model instanceof EshopProductModel) {
                if (Objects.equals(((EshopProductModel) model).getProductIsShow(), ProductEnum.SHOW.getIndex())) {
                    responseData.setError("商品已经上架如法加入回收站，请先下架");
                    return responseData;
                }
            }
            model.setIsDel(BeanEnum.DEL.getIndex());
            baseServiceAbstractPage.editModel(model, id);
            responseData.setData("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setError(e.getMessage());
        }
        return responseData;
    }


    /**
     * 根据数据编号[还原假删]
     *
     * @param id
     * @return
     */
    @GetMapping("/deleteUrlRestore")
    public ResponseData deleteUrlRestore(ID id) {
        ResponseData responseData = new ResponseData();
        try {
            Model model = baseServiceAbstractPage.getModel(id);
            model.setIsDel(BeanEnum.UNDEL.getIndex());
            baseServiceAbstractPage.editModel(model, id);
            responseData.setData("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setError(e.getMessage());
        }
        return responseData;
    }

    /**
     * 分页查询
     *
     * @param model 查询条件
     * @param page  当前查询的页码
     * @return
     */
    @GetMapping("/getPages")
    public ResponseData getPages(Model model, @RequestParam(defaultValue = "0") Integer page) {
        logger.info(String.format("请求地址：%s,页数：%s,显示条数：%s", "/getPages", page, this.pageSize));
        //分页排序资源数据
        PageRequest pageRequest = PageRequest.of(page, this.pageSize);//设置分页
        ResponseData responseData = new ResponseData();
        try {
            Page<Model> pages = baseServiceAbstractPage.getModelsPage(Objects.isNull(model) ? (Model) (model.getClass().newInstance()) : model, pageRequest, this.getPagesSort());
            responseData.setData(pages);
        } catch (Exception e) {
            responseData.setError(e.getMessage());
        }
        return responseData;
    }

    /**
     * 设置分页的排序
     *
     * @return
     */
    public abstract Sort getPagesSort();


}
