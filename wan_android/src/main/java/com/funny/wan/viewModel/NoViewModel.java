package com.funny.wan.viewModel;

import android.app.Application;
import android.support.annotation.NonNull;

import com.funny.component.base.BaseViewModel;

/**
 * Author: Funny
 * Time: 2019/11/5
 * Description: This is 没有ViewModel的情况使用这个类
 */
public class NoViewModel extends BaseViewModel {

    public NoViewModel(@NonNull Application application) {
        super(application);
    }
}
