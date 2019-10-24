package com.funny.wan.viewModel;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.funny.component.base.BaseViewModel;
import com.funny.component.entity.BaseWanResponse;
import com.funny.component.net.BaseResultCode;
import com.funny.component.net.RetrofitFactory;
import com.funny.component.utils.ToastUtil;
import com.funny.wan.api.IUserApi;
import com.funny.wan.entity.UserInfo;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Author: Funny
 * Time: 2019/10/22
 * Description: This is LoginViewModel
 */
public class UserViewModel extends BaseViewModel {

    public ObservableField<String> username = new ObservableField<>();
    public ObservableField<String> password = new ObservableField<>();

    public UserViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * 注册
     */
    public MutableLiveData<Boolean> registe() {
        MutableLiveData<Boolean> data = new MutableLiveData<>();
        if (verifyData()) {
            Observable<BaseWanResponse<UserInfo>> registe = RetrofitFactory.getInstance().create(IUserApi.class).registe(username.get(), password.get(), password.get());
            Disposable disposable = add(registe).subscribe(new Consumer<BaseWanResponse<UserInfo>>() {
                @Override
                public void accept(BaseWanResponse<UserInfo> response) throws Exception {
                    if (response.errorCode == BaseResultCode.ACTION_SUCESS) {
                        data.setValue(true);
                    } else {
                        data.setValue(false);
                        ToastUtil.show(response.errorMsg);
                    }
                }
            }, new Consumer<Throwable>() {
                @Override
                public void accept(Throwable throwable) throws Exception {
                    data.setValue(false);
                    ToastUtil.show("网络连接失败，请稍后重试");
                }
            });
        } else {
            data.setValue(false);
        }
        return data;
    }

    public MutableLiveData<Boolean> login() {
        MutableLiveData<Boolean> data = new MutableLiveData<>();
        if (verifyData()) {
            Observable<BaseWanResponse<UserInfo>> login = RetrofitFactory.getInstance().create(IUserApi.class).login(username.get(), password.get());
            Disposable disposable = add(login).subscribe(response -> {
                if (response.errorCode == BaseResultCode.ACTION_SUCESS) {
                    data.setValue(true);
                } else {
                    data.setValue(false);
                    ToastUtil.show(response.errorMsg);
                }
            }, throwable -> {
                data.setValue(false);
                ToastUtil.show("网络连接失败，请稍后重试");
            });
        } else {
            data.setValue(false);
        }
        return data;
    }

    private boolean verifyData() {
        if (TextUtils.isEmpty(username.get())) {
            ToastUtil.show("请输入用户名");
            return false;
        }
        if (TextUtils.isEmpty(password.get())) {
            ToastUtil.show("请输入密码");
            return false;
        }
        return true;
    }

}

