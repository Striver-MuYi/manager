package com.muyi.manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.muyi.manager.entity.Goods;

public interface GoodsMapper extends BaseMapper<Goods> {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}