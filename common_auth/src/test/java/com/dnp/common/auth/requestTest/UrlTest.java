package com.dnp.common.auth.requestTest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huazai on 2018/12/10.
 */
public class UrlTest {
    public static void main(String[] args) {
//        "service-hi:123456";
        String xx = new BASE64Encoder().encode("service-hi:123456".getBytes());
        System.out.println("xx = " + xx);
        String uri = "http://localhost:5555/uaa/oauth/token";
        List<NameValuePair> param = new ArrayList<>();
        param.add(new BasicNameValuePair("grant_type", "password"));
        param.add(new BasicNameValuePair("username", "sss"));
        param.add(new BasicNameValuePair("password", "123456"));
        try {
            sendPost(param, uri);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public  static  void sendPost(List<NameValuePair> formparams, String uri) throws IOException {
        HttpEntity reqEntity = new UrlEncodedFormEntity(formparams, "utf-8");

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000)//一、连接超时：connectionTimeout-->指的是连接一个url的连接等待时间
                .setSocketTimeout(5000)// 二、读取数据超时：SocketTimeout-->指的是连接上一个url，获取response的返回等待时间
                .setConnectionRequestTimeout(5000)
                .build();

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(uri);
        post.setHeader("Authorization", "Basic c2VydmljZS1oaToxMjM0NTY=");
        post.setEntity(reqEntity);
        post.setConfig(requestConfig);
        HttpResponse response = client.execute(post);

        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode = " + statusCode);
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity resEntity = response.getEntity();
            String message = EntityUtils.toString(resEntity, "utf-8");
            System.out.println(message);
        } else {
            System.out.println("请求失败");
        }
    }


}
