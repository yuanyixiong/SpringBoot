package online.shixun.demo.eshop.module.slideshow.service;

import online.shixun.demo.eshop.core.service.BeanEnum;
import online.shixun.demo.eshop.core.service.SlideshowEnum;
import online.shixun.demo.eshop.dto.EshopSlideshow;
import online.shixun.demo.eshop.dto.EshopSlideshowCriteria;
import online.shixun.demo.eshop.module.slideshow.mapper.EshopSlideshowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EshopSlideshowService {
    @Autowired
    private EshopSlideshowMapper slideshowMapper;

    public List<EshopSlideshow> getSlideshows(SlideshowEnum slideshowEnum) {
        EshopSlideshowCriteria eshopSlideshowCriteria = new EshopSlideshowCriteria();
        EshopSlideshowCriteria.Criteria criteria = eshopSlideshowCriteria.createCriteria();
        criteria.andIsDelEqualTo(BeanEnum.UNDEL.getIndex());//未删
        criteria.andSlideshowHtmlEqualTo(slideshowEnum.getKeyword());
        //升序排序，越小越靠前
        eshopSlideshowCriteria.setOrderByClause("slideshow_index asc");
        return slideshowMapper.selectByExample(eshopSlideshowCriteria);
    }


}
