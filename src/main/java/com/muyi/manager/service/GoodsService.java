package com.muyi.manager.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.muyi.manager.entity.Goods;

/**
 * description： 商品日志
 * Create By  ： sena104
 * Create Time： Created in 2021-05-26 16:45
 */
public interface GoodsService extends IService<Goods> {

    int insertGoods(Goods goods);

    int updateGoods(Goods goods);

    int deleteGoods(Integer id);

    Goods findGoodsById(Integer id);

    Goods findGoodsByName(String name);

    IPage<Goods> findGoodsByPage(Page page, Goods goods);
}
