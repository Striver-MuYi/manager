package com.muyi.manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.muyi.manager.entity.Goods;
import com.muyi.manager.mapper.GoodsMapper;
import com.muyi.manager.service.GoodsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * description： 商品日志实现类
 * Create By  ： sena104
 * Create Time： Created in 2021-05-26 16:46
 */

@Service
@AllArgsConstructor
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    // 增
    @Override
    public int insertGoods(Goods goods) {
        return baseMapper.insert(goods);
    }

    // 删
    @Override
    public int updateGoods(Goods goods) {
        return baseMapper.updateById(goods);
    }

    // 改
    @Override
    public int deleteGoods(Integer id) {
        return baseMapper.deleteById(id);
    }

    // id查询
    @Override
    public Goods findGoodsById(Integer id) {
        return baseMapper.selectById(id);
    }

    // 名称查询
    @Override
    public Goods findGoodsByName(String name) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goodsName", name);
        return baseMapper.selectOne(queryWrapper);
    }

    // 分页
    @Override
    public IPage<Goods> findGoodsByPage(Page page, Goods goods) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        return baseMapper.selectPage(page, queryWrapper);
    }
}
