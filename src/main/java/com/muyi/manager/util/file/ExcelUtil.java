package com.muyi.manager.util.msg.file;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.WriteWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 *  Excel 导出/导入
 *
 *
 */
public class ExcelUtil {

    /**
     * 导出某个sheet的Excel
     */
        public static void writeExcel(HttpServletResponse response, List<? extends BaseRowModel> list,
                                      String fileName, String sheetName, BaseRowModel object) {
        ExcelWriter excelWriter = new ExcelWriter(new WriteWorkbook());

//        ExcelWriter writer = new ExcelWriter(null,getOutputStream(fileName, response), ExcelTypeEnum.XLSX,true,new StyleExcelHandler());
//        Sheet sheet = new Sheet(0, 1, object.getClass());
//        //设置表名称
//        sheet.setSheetName(sheetName);
//        //导出
//        writer.write(list, sheet);
//        writer.finish();
    }

    /**
     * 导出文件时为Writer生成OutputStream
     */
    private static OutputStream getOutputStream(String fileName, HttpServletResponse response) {
        //创建本地文件
        String filePath = fileName + ".xlsx";
        File dbfFile = new File(filePath);
        try {
            if (!dbfFile.exists() || dbfFile.isDirectory()) {
                dbfFile.createNewFile();
            }
            //文件名字符设置
            fileName = new String(filePath.getBytes(), "ISO-8859-1");
            response.addHeader("Content-Disposition", "filename=" + fileName);
            return response.getOutputStream();
        } catch (IOException e) {
            throw new ExcelException("创建文件失败！");
        }
    }

}
