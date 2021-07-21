package com.muyi.manager.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * description： 文件处理实体类
 * Create By  ： sena104
 * Create Time： Created in 2021-06-07 14:34
 */
@Data
public class FileEntity {
    @ExcelIgnore
    private Integer id;
    @ExcelProperty(index = 1, value = "配置名称")
    private String name;
    @ExcelProperty(index = 2, value = "配置url")
    private String url;
    @ExcelIgnore
    private String ws_name;
    @ExcelProperty(index = 3, value = "配置规则")
    private String check_define;	// 规则定义
    @ExcelProperty(index = 4, value = "最小值")
    private Integer lowe_bound;
    @ExcelProperty(index = 5, value = "最大值")
    private Integer upper_boud;
    @ExcelProperty(index = 6, value = "编码")
    private String charset;
    @ExcelProperty(index = 7, value = "开始时间")
    private String start_time;
    @ExcelProperty(index = 8, value = "启动数")
    private Integer eve_coll_num; // 一次启动个数
}
