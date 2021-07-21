package com.muyi.manager.mapper;

import com.muyi.manager.entity.GoodsOrder;

public interface GoodsOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsOrder record);

    int insertSelective(GoodsOrder record);

    GoodsOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsOrder record);

    int updateByPrimaryKeyWithBLOBs(GoodsOrder record);

    int updateByPrimaryKey(GoodsOrder record);
}