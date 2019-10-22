package com.funny.wan.viewModel;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.funny.component.base.BaseViewModel;
import com.funny.component.net.RetrofitFactory;
import com.funny.component.utils.ToastUtil;
import com.funny.wan.api.IUserApi;
import com.funny.wan.entity.BaseWanAndroidResponse;

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

    public void registe() {
        if (verifyData()) {
            Observable<BaseWanAndroidResponse> registe = RetrofitFactory.getInstance().create(IUserApi.class).registe(username.get(), password.get(), username.get());
            Disposable disposable = add(registe).subscribe(new Consumer<BaseWanAndroidResponse>() {
                @Override
                public void accept(BaseWanAndroidResponse baseWanAndroidResponse) throws Exception {

                }
            });
        }
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

