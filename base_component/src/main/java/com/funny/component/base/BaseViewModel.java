package com.funny.component.base;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Author: Funny
 * Time: 2019/10/22
 * Description: This is BaseViewModel
 */
public class BaseViewModel extends AndroidViewModel {

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * 处理Rxjava线程切换
     * 使用RxLifeCycle对Rxjava生命周期进行管理
     *
     * @param <T>
     * @param observable
     * @return
     */
    public <T> Observable<T> add(Observable<T> observable) {
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
//                .compose(mView.autoRxLifeCycle().bindToLifecycle());
    }

}
