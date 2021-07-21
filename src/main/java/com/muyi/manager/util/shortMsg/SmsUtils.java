package com.muyi.manager.util.shortMsg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SmsUtils {

    private String USRENAME = "xuleinew";
    private String PASSWORD = "4F956593A625A882D2366E76F8DC";
    private String endPoint = "http://web.cr6868.com/asmx/smsservice.aspx";
    private String nameSpace = "http://www.ohsena.com/";
    private String number;
    private String msg;

    public SmsUtils(String number, String msg) {
        this.number = number;
        this.msg = msg;
        init();
    }

    public void init() {
//        PropertiesConfiguration config = null;
//        try {
//            try {
//                config = new PropertiesConfiguration("messageConfig.properties");
//            } catch (ConfigurationException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        // TODO Auto-generated catch block
//        config.setReloadingStrategy(new FileChangedReloadingStrategy());
//        this.USRENAME = config.getString("USRENAME");
//        this.PASSWORD = config.getString("PASSWORD");
//        this.endPoint = config.getString("endPoint");
//        this.nameSpace = config.getString("nameSpace");
    }

    public boolean sendMessage() {
        try {
            // 发送内容
            String sign = "【z帅智能科技】";

            // 创建StringBuffer对象用来操作字符串
            StringBuffer sb = new StringBuffer(this.endPoint);

            // 向StringBuffer追加用户名
            sb.append("?name=xuleinew" );

            // 向StringBuffer追加密码（登陆网页版，在管理中心--基本资料--接口密码，是28位的）
            sb.append("&pwd=4F956593A625A882D2366E76F8DC");

            // 向StringBuffer追加手机号码
            sb.append("&mobile=" + this.number);

            // 向StringBuffer追加消息内容转URL标准码
            sb.append("&content=" + URLEncoder.encode(this.msg, "utf-8"));

            // 追加发送时间，可为空，为空为及时发送
            sb.append("&stime=");

            // 加签名
            sb.append("&sign="+ URLEncoder.encode(sign, "utf-8"));// + URLEncoder.encode(sign));

            // type为固定值pt extno为扩展码，必须为数字 可为空
            sb.append("&type=pt&extno=");
            // 创建url对象

            // System.out.println("---"+sb.toString());
            URL url = new URL(sb.toString());

            // 打开url连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 设置url请求方式 ‘get’ 或者 ‘post’

            connection.setRequestMethod("POST");
            connection.setRequestProperty("contentType", "utf-8");

            // 发送
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            // 返回发送结果
            String inputline = in.readLine();

            // 返回结果为‘0，20140009090990,1，提交成功’ 发送成功 具体见说明文档
            System.out.println("====inputline====:"+inputline);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {

        StringBuffer msg = new StringBuffer();
//        String sendName = "龚女士";
        String sendName1 = "函宝";
//        String phone1 = "15191413365";
//        String phone2 = "17391814134";
        String phone3 = "13397489367";
        msg.append("尊敬的"+sendName1+"您好，请您尽快上楼避难！");
        SmsUtils smsUtils = new SmsUtils(phone3, msg.toString());
        smsUtils.sendMessage();

//        new SmsUtils(
//            "15116381731",
//            "您好！"+"\u6E56\u5357\u751F\u7269\u673A\u7535\u804C\u4E1A\u6280\u672F\u5B66\u9662"+"：你所监测的数据库"+"127.0.0.1"+"于"+"127.0.0.1"+"无法正常访问，请您及时关注并修复。"
//        ).sendMessage();
    }

}
