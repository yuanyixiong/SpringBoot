/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.comment.controller;

import com.github.pagehelper.PageInfo;
import online.shixun.demo.eshop.core.service.BeanEnum;
import online.shixun.demo.eshop.core.service.Node;
import online.shixun.demo.eshop.dto.EshopComment;
import online.shixun.demo.eshop.dto.EshopProduct;
import online.shixun.demo.eshop.dto.EshopResource;
import online.shixun.demo.eshop.module.comment.service.EshopCommentService;
import online.shixun.demo.eshop.module.product.service.EshopProductService;
import online.shixun.demo.eshop.module.user.service.EshopResourceService;
import online.shixun.demo.eshop.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class EshopCommentController {

    @Autowired
    private EshopResourceService resourceService;

    @Autowired
    private EshopCommentService commentService;

    @Autowired
    private EshopProductService productService;

    @Value("${system.page.size}")
    private Integer pageSize;

    @GetMapping("/getComments")
    public ModelAndView getComments(ModelAndView mav, EshopComment eshopComment, @RequestParam(defaultValue = "1") int pageNum) {
        PageInfo<EshopComment> pageInfo = commentService.getComments(eshopComment, pageNum, this.pageSize);
        mav.addObject("pageInfo", pageInfo);
        mav.addObject("eshopComment", eshopComment);
        mav.setViewName("fragment/detail/comment");
        return mav;
    }

    @GetMapping("/main")
    public ModelAndView main(ModelAndView mav, String productId) {
        //加载水平导航栏菜单
        List<Node<EshopResource>> levelNavigationMenu = resourceService.initLevelNavigation();
        //加载垂直导航栏菜单
        List<Node<EshopResource>> verticalNavigationMenu = resourceService.initVerticalNavigation();

        //设置数据到请求中
        mav.addObject("levelNavigationMenu", levelNavigationMenu);
        mav.addObject("verticalNavigationMenu", verticalNavigationMenu);


        EshopProduct product = productService.getProduct(productId);
        mav.addObject("product", product);
        mav.setViewName("comment");
        return mav;
    }


    @PostMapping("/addComment")
    public ModelAndView addComment(ModelAndView mav, EshopComment comment) {
        comment.setId(BeanUtils.getId());
        comment.setIsDel(BeanEnum.UNDEL.getIndex());
        comment.setCreateTime(new Date());
        comment.setUpdateTime(new Date());
        commentService.addComment(comment);
        mav.setViewName("redirect:/order/main");
        return mav;
    }
}
