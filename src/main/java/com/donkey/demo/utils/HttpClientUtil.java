package com.donkey.demo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by qixin-lvxincao on 2018/5/24.
 */
public class HttpClientUtil {
    protected static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    public static JSONObject doHttpClient(String method, String url,Map<String, String> param){
        String result ="";
        if("post".equals(method)){
            result = doPost(url,param);
        }else{

        }
        return JSON.parseObject(result);
    }

    public static String doPost(String url, Map<String, String> param) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建参数列表
            if (param != null) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (String key : param.keySet()) {
                    paramList.add(new BasicNameValuePair(key, param.get(key)));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList,"utf-8");
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            logger.warn(e.getMessage());
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                logger.warn(e.getMessage());
            }
        }

        return resultString;
    }

    public static String doPost(String url) {
        return doPost(url, null);
    }

    public static String doGet(String url, Map<String, String> param) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = null; //响应内容
        JSONObject jsonResult = null;
        StringBuilder sb = new StringBuilder();
        url = url +"?" +urlencode(param);
        HttpGet httpGet = new HttpGet(url);
        try{
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();            //获取响应实体
            if(null != entity){
                // 把json字符串转换成json对象
                jsonResult = JSONObject.parseObject(EntityUtils.toString(response.getEntity(), "utf-8"));
                resultString = jsonResult.toString();
            }
            }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                response.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return resultString;
    }

    public static String urlencode(Map<String,String>data) {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry i : data.entrySet()) {
            try{
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static String reEncoding(String text, String newEncoding) {
        String str = null;
        try {
            str = URLDecoder.decode(text, newEncoding);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return str;
    }



}
