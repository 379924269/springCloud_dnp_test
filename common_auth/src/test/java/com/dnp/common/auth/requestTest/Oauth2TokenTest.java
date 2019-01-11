package com.dnp.common.auth.requestTest;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huazai on 2018/12/10.
 */
public class Oauth2TokenTest {
    public static void main(String[] args) {
//        "service-hi:123456";
        getPrincipleTest();
    }

    public static void hiTest() {
        String uri = "http://localhost:5555/hi";
        List<NameValuePair> param = new ArrayList<>();
        Header header = new BasicHeader("Authorization", "Bearer 16d6a08a-d155-4790-8487-f8b45165082d" );
        try {
            sendPost(param, uri, header);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void getPrincipleTest() {
        String uri = "http://localhost:8762/getPrinciple";
        List<NameValuePair> param = new ArrayList<>();
        Header header = new BasicHeader("Authorization", "Bearer 16d6a08a-d155-4790-8487-f8b45165082d" );
        try {
            sendGet(param, header, uri);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    public  static  void sendPost(List<NameValuePair> formparams, String uri, Header header) throws IOException {
        HttpEntity reqEntity = new UrlEncodedFormEntity(formparams, "utf-8");

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000)//一、连接超时：connectionTimeout-->指的是连接一个url的连接等待时间
                .setSocketTimeout(5000)// 二、读取数据超时：SocketTimeout-->指的是连接上一个url，获取response的返回等待时间
                .setConnectionRequestTimeout(5000)
                .build();

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(uri);
        post.setHeader(header);
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

    /**
     * @param params      请求参数,如：List<NameValuePair> param = new ArrayList<NameValuePair>();param.add(new BasicNameValuePair("grant_type", "password"));
     * @param header      请求头， 如：Header header = new BasicHeader("Authorization", "bearer " + token);
     * @param requestPath 请求路径
     * @throws IOException io异常
     */
    public static void sendGet(List<NameValuePair> params, Header header, String requestPath) throws IOException, URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(requestPath);
        uriBuilder.setParameters(params);
        HttpClient httpClient = HttpClientBuilder.create().build();
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(1000000).setSocketTimeout(1000000).build();
        HttpGet httpGet = new HttpGet(requestPath);
        httpGet.setConfig(requestConfig);
        httpGet.setHeader(header);

        HttpResponse response = httpClient.execute(httpGet);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode = " + statusCode);
        out(response, statusCode);

    }

    private static void out(HttpResponse response, int statusCode) throws IOException {
        if (statusCode == 200) {
            String message = EntityUtils.toString(response.getEntity());
            System.out.println("message = " + message);
        } else {
            String message = EntityUtils.toString(response.getEntity());
            System.out.println("message = " + message);
            System.out.println("请求失败");
        }
}
}
