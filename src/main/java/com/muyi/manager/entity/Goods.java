package com.muyi.manager.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("goods")
public class Goods {

    @TableId("id")
    private Integer id;

    private String goodsName;

    private String goodsPrice;

    private String goodsType;
}