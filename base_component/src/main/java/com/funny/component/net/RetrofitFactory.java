package com.funny.component.net;

import android.util.Log;

import com.funny.component.BuildConfig;
import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.Logger;
import com.ihsanbal.logging.LoggingInterceptor;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.internal.platform.Platform;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author: Funny
 * Time: 2018/8/14
 * Description: This is RetrofitFactory
 */
public class RetrofitFactory {

    // TODO: 2019/7/30 base_url待修改
    private static final String BASE_URL = "https://www.wanandroid.com/";

    private static volatile Retrofit sInstance;

    private RetrofitFactory() {
    }

    public static Retrofit getInstance() {
        if (sInstance == null) {
            synchronized (RetrofitFactory.class) {
                if (sInstance == null) {

                    //添加持久化cookie
//                    ClearableCookieJar cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(AppManager.getAppManagerContext()));

                    //日志拦截器
                    LoggingInterceptor loggingInterceptor = getLogInterceptor();

                    OkHttpClient okHttpClient = getOkHttpClient(loggingInterceptor);

                    Retrofit.Builder builder = new Retrofit.Builder();
                    builder.client(okHttpClient);
                    builder.addConverterFactory(GsonConverterFactory.create());
                    builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());


                    builder.baseUrl(BASE_URL);
                    sInstance = builder.build();
                }
            }
        }
        return sInstance;
    }

    private static LoggingInterceptor getLogInterceptor() {
        return new LoggingInterceptor.Builder()
                .loggable(BuildConfig.DEBUG)
                .setLevel(Level.BASIC)
                .log(Platform.INFO)
                .request("Request")
                .response("Response")
                .addHeader("version", BuildConfig.VERSION_NAME)
                .addQueryParam("query", "0")
                .enableAndroidStudio_v3_LogsHack(true) /* enable fix for logCat logging issues with pretty format */
                .logger(new Logger() {
                    @Override
                    public void log(int level, String tag, String msg) {
                        Log.w(tag, msg);
                    }
                })
                .executor(Executors.newSingleThreadExecutor())
                .build();
    }

    private static OkHttpClient getOkHttpClient(LoggingInterceptor loggingInterceptor) {
        return new OkHttpClient().newBuilder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }
}
