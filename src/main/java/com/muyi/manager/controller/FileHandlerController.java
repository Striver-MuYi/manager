package com.muyi.manager.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.muyi.manager.entity.FileEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * description： 文件上传下载处理api
 * Create By  ： sena104
 * Create Time： Created in 2021-06-07 14:29
 */

@RestController
@RequestMapping("/file")
public class FileHandlerController {

    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file) throws JSONException, IOException {
        JSONObject result = new JSONObject();
        boolean flag = false;
        result.put("msg", "批量添加失败，请稍后再试");
        System.out.println("1111111111111111");
        InputStream inputStream = file.getInputStream();
        List<FileEntity> fileEntityList = EasyExcel.read(inputStream)
                .head(FileEntity.class)
                // 设置sheet,默认读取第一个
                .sheet()
                // 设置标题所在行数
                .headRowNumber(4)
                .doReadSync();
        if (fileEntityList != null) {
            for (FileEntity fileEntity : fileEntityList) {
                System.out.println("fileEntity = " + fileEntity.toString());
            }
            flag = true;
            result.put("msg", "批量添加成功");
        }
        result.put("success", flag);
        return result.toString();
    }
}
