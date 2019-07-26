package com.fh.shop.api.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {

    /**
     * get请求
     * @param url
     * @return
     */
    public static String httpGet(String url){
        CloseableHttpClient client = null;
        HttpGet httpGet = null;
        CloseableHttpResponse execute = null;
        String str = "";
        try {
             client = HttpClientBuilder.create().build();
             httpGet = new HttpGet();
             execute = client.execute(httpGet);
            HttpEntity entity = execute.getEntity();
             str = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != execute){
                try {
                    execute.close();
                    execute=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != httpGet){
                httpGet.releaseConnection();
            }
            if(null != client){
                try {
                    client.close();
                    client=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return str;
    }

    /**
     * post请求
     * @return
     */
    public static String httpPost(String url, Map<String,String> params,Map<String,String> headers){
        CloseableHttpClient build = null;
        HttpPost httpPost = null;
        CloseableHttpResponse execute = null;
        String s;
        try {
            //创建配置
             build = HttpClientBuilder.create().build();
            //设置请求方式
             httpPost = new HttpPost(url);
            //设置普通参数
            List<NameValuePair> pairs = new ArrayList<>();
            if(null != params && params.size() > 0){
                Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
                while(iterator.hasNext()){
                    Map.Entry<String, String> next = iterator.next();
                    String key = next.getKey();
                    String value = next.getValue();
                    pairs.add(new BasicNameValuePair(key,value));
                }
                //进行和post融合
                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(pairs);
                httpPost.setEntity(urlEncodedFormEntity);
            }
            //设置头信息
            if(null != headers && headers.size() > 0){
                Iterator<Map.Entry<String, String>> iterator = headers.entrySet().iterator();
                while (iterator.hasNext()){
                    Map.Entry<String, String> next = iterator.next();
                    String key = next.getKey();
                    String value = next.getValue();
                    httpPost.setHeader(key,value);
                }
            }
            //执行
            execute = build.execute(httpPost);
            //获取响应内容
            HttpEntity entity = execute.getEntity();
            //转换String
             s = EntityUtils.toString(entity);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
        }
        return s;
    }
}
