package com.funny.component.net;

import com.funny.component.entity.BaseWanResponse;

import io.reactivex.functions.Consumer;

/**
 * Author: Funny
 * Time: 2019/10/24
 * Description: This is SuccessCallback
 */
public class SuccessCallback<T> implements Consumer<BaseWanResponse> {


    @Override
    public void accept(BaseWanResponse baseWanResponse) throws Exception {
        T t = (T) baseWanResponse.data;

        if(baseWanResponse.errorCode == 0){
            success(baseWanResponse);
        }
    }

    public void success(BaseWanResponse baseWanResponse){}
}
