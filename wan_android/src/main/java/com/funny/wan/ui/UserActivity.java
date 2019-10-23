package com.funny.wan.ui;

import android.annotation.SuppressLint;
import android.view.View;

import com.funny.component.base.BaseActivity;
import com.funny.component.utils.ConstantUtil;
import com.funny.wan.R;
import com.funny.wan.databinding.ActivityUserBinding;
import com.funny.wan.viewModel.UserViewModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.functions.Consumer;

public class UserActivity extends BaseActivity<UserViewModel, ActivityUserBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    protected void initView() {
        setTitle("登录");
        mBingdingView.setUserViewModel(mViewModel);
    }

    @SuppressLint("CheckResult")
    @Override
    protected void initEvent() {
        //注册点击事件
        mBingdingView.registeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.registe();
            }
        });


//        RxView.clicks(mBingdingView.loginBtn)
//                .throttleFirst(ConstantUtil.CLICK_INTERVAL, TimeUnit.SECONDS)
//                .subscribe(unit -> {
//                    mViewModel.login();
//                });
    }
}
