package com.funny.wan.ui;

import com.funny.component.base.BaseActivity;
import com.funny.wan.R;
import com.funny.wan.databinding.ActivityLoginBinding;
import com.funny.wan.viewModel.LoginViewModel;

public class LoginActivity extends BaseActivity<LoginViewModel, ActivityLoginBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        setTitle("登录");

    }
}
