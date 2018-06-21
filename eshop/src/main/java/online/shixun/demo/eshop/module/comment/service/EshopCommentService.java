/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.comment.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.shixun.demo.eshop.core.service.BeanEnum;
import online.shixun.demo.eshop.dto.EshopComment;
import online.shixun.demo.eshop.dto.EshopCommentCriteria;
import online.shixun.demo.eshop.module.comment.mapper.EshopCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EshopCommentService {
    @Autowired
    private EshopCommentMapper commentMapper;

    public PageInfo<EshopComment> getComments(EshopComment eshopComment, int pageNum, int pageSize) {
        EshopCommentCriteria eshopCommentCriteria = new EshopCommentCriteria();
        if (Objects.nonNull(eshopComment)) {
            EshopCommentCriteria.Criteria criteria = eshopCommentCriteria.createCriteria();
            criteria.andIsDelEqualTo(BeanEnum.UNDEL.getIndex());//未删
            if (Objects.nonNull(eshopComment.getProductId())) {
                criteria.andProductIdEqualTo(eshopComment.getProductId());
            }
        }
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(commentMapper.selectByExample(eshopCommentCriteria));
    }

    public int addComment(EshopComment comment) {
        return commentMapper.insert(comment);
    }
}
