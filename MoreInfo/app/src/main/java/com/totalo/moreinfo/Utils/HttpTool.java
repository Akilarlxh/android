package com.totalo.moreinfo.Utils;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *抽象请求方法GET、POST
 */
public class HttpTool {
    /**
     * 发送请求的方法
     * @param method 请求的方法
     * @param adddress 请求的Url
     * @param params 请求的参数
     * @param listener 请求回调
     */
    public static void sendGetRequest(final String method, final String adddress, final String params,
                                      final  HttpCallbackListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try{
                    URL url = new URL(adddress);
                    connection = (HttpURLConnection)url.openConnection();
                    //设置请求方式
                    connection.setRequestMethod(method);
                    //设置连接超时时间
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    //设置是否缓存
                    connection.setUseCaches(true);
                    Log.i(method,"开始连接");
                    connection.connect();
                    if(connection.getResponseCode() == 200){
                        Log.i(method,"请求成功");
                        InputStream in = connection.getInputStream();
                        BufferedReader reader =new BufferedReader(new InputStreamReader(in));
                        StringBuilder response = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null){
                            response.append(line);
                        }
                        if(listener!=null){
                            //回调方法
                            listener.onFinish(response.toString());
                        }
                    }else {
                        Log.i(method,"请求失败");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    if(listener!=null){
                        listener.onError(e);
                    }
                }finally {
                    if(connection!=null){
                        connection.disconnect();
                    }
                }
            }
        }).start();

    }

}
