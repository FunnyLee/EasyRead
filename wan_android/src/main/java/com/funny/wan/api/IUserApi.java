package com.funny.wan.api;


import com.funny.wan.entity.BaseWanAndroidResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Author: Funny
 * Time: 2019/10/22
 * Description: This is IUserApi
 */
public interface IUserApi {

    /**
     * 注册 https://www.wanandroid.com/user/register
     *
     * @param username
     * @param password
     * @param repassword
     * @return
     */
    @FormUrlEncoded
    @POST("user/register")
    Observable<BaseWanAndroidResponse> registe(@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);

    /**
     * 登录 https://www.wanandroid.com/user/login
     *
     * @param username
     * @param password
     * @return
     */
    Observable login(@Field("username") String username, @Field("password") String password);
}
