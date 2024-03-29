package com.funny.component.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Author: Funny
 * Time: 2019/7/30
 * Description: This is BaseWanAndroidInfo
 */
public class BaseWanResponse<T> implements Serializable {

    @SerializedName("errorCode")
    public int errorCode;

    @SerializedName("errorMsg")
    public String errorMsg;

    @SerializedName("data")
    public T data;
}
