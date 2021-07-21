package com.muyi.manager.util.msg.file;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

public class ExcelListener extends AnalysisEventListener {

    //通过实例获取
    private List<Object> datas = new ArrayList<>();

    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {
        //数据存储到list，供批量处理，或后续自己业务逻辑处理。
        datas.add(o);
        for (Object data : datas) {
            System.out.println(data);
        }
        System.out.println("11111111111111111111");
        //根据业务自行 do something
        doSomething();
    }

    private void doSomething() {
        //入库调用接口
        System.out.println("入库操作");
    }

    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }

    public List<Object> getDatas() {
        return datas;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
     /*
        datas.clear();
        解释结束销毁不用的资源
     */
    }
}
