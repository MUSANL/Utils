
import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;


public class SMSTest {

    public static void main(String[] args) throws HttpException, IOException{
        String res = sentMessages("135********","验证码:888888");
        System.out.println(res);
    }

    public static String sentMessages(String phoneNumber, String messages) throws HttpException, IOException {

        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://gbk.api.smschinese.cn");
        // 在头文件中设置转码
        post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
        NameValuePair[] data = {
                // 注册的用户名
                new NameValuePair("Uid", "MU***"),
                // 短信密钥
                new NameValuePair("Key", "d41*****"),
                // 手机号码
                new NameValuePair("smsMob", phoneNumber),
                //设置短信内容
                new NameValuePair("smsText", messages)
        };
        post.setRequestBody(data);
        client.executeMethod(post);
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        System.out.println("statusCode:" + statusCode);
//        for (Header h : headers) {
//            System.out.println(h.toString());
//        }
        String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
        //打印返回消息状态
        //System.out.println(result);
        post.releaseConnection();
        return result;
    }
}