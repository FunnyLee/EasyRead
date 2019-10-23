package com.funny.wan.ui;

import android.annotation.SuppressLint;
import android.view.View;

import com.funny.component.base.BaseActivity;
import com.funny.wan.R;
import com.funny.wan.databinding.ActivityUserBinding;
import com.funny.wan.viewModel.UserViewModel;
import com.gyf.immersionbar.ImmersionBar;

public class UserActivity extends BaseActivity<UserViewModel, ActivityUserBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    protected void initImmersionbar() {
        ImmersionBar.with(this).statusBarView(mBingdingView.statusView).init();
    }

    @Override
    protected void initView() {
        setToolBar(mBingdingView.includeTitle.toolBar);
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

        //登录点击事件
        mBingdingView.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.login();
            }
        });
    }
}
