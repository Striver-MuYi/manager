package com.muyi.manager.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muyi.manager.entity.Goods;
import com.muyi.manager.service.GoodsService;
import com.muyi.manager.util.msg.MessageBase;
import com.muyi.manager.util.msg.MessageFactory;
import com.muyi.manager.util.msg.MessagePage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * description： 商品api
 * Create By  ： sena104
 * Create Time： Created in 2021-05-26 16:50
 */
@Slf4j
@RestController
@RequestMapping("/api/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping(value = {"/getAllByPage"})
    public MessagePage getGoodsList(@RequestBody Goods goods) {

        MessagePage msg = MessageFactory.buildPage();
        IPage<Goods> list =  goodsService.findGoodsByPage(new Page(), goods);
        list.getPages();
        list.getSize();
        list.getTotal();
        msg.setRow(list.getRecords());
        msg.setTotal((int) list.getTotal());
        log.debug("这是日子debug");
        log.info("这是日志info");
        log.error("这是日志error");
        return msg;
    }

    @PostMapping(value = "/addGoods")
    public MessageBase addGoods(@RequestBody Goods goods) {
        MessageBase msg = MessageFactory.buildBase();
        int executeResult = goodsService.insertGoods(goods);
        if (executeResult == 1) {
            msg.setMsg("添加成功");
            msg.setSuccess(true);
            log.info("添加商品信息");
        } else {
            msg.setMsg("添加失败");
        }
        return msg;
    }

    @DeleteMapping(value = "/delGoods/{id}")
    public MessageBase delGoods(@PathVariable Integer id) {
        MessageBase msg = MessageFactory.buildBase();
        int executeResult = goodsService.deleteGoods(id);
        if (executeResult == 1) {
            msg.setMsg("删除成功");
            msg.setSuccess(true);
            log.info("删除商品信息");
        } else {
            msg.setMsg("删除失败");
        }
        return msg;
    }
}
