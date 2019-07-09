package com.function.luo.okhttputils;

import android.os.Handler;
import android.os.Looper;

import org.json.JSONObject;


import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;


/**
 * Created by luo on 2019/7/8.
 * okhttp 的封装
 */

public class HttpUtil {
    private static Long connectTimeout = 100L;
    private static Long writeTimeout = 100L;
    private static Long readTimeout = 100L;
    /**
     * mdiatype 这个需要和服务端保持一致
     */
    private static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");
    private static Handler mainHandler = new Handler(Looper.getMainLooper());
    private static OkHttpClient okHttpClient;
    private static JSONObject jsonObject;
    public static OkHttpClient getHttpInstance() {
        if (okHttpClient == null) {
            synchronized (HttpUtil.class) {
                if (okHttpClient == null) {
                    okHttpClient = new OkHttpClient.Builder()
                            //10秒连接超时
                            .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                            //10m秒写入超时
                            .writeTimeout(writeTimeout, TimeUnit.SECONDS)
                            //10秒读取超时
                            .readTimeout(readTimeout, TimeUnit.SECONDS)
                            //.addInterceptor(new HttpHeaderInterceptor())//头部信息统一处理
                            //.addInterceptor(new CommonParamsInterceptor())//公共参数统一处理
                            .build();
                }
            }
        }
        return okHttpClient;
    }





}
