package com.funny.wan.ui;

import com.funny.component.BaseActivity;
import com.funny.wan.R;

public class LoginActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        setTitle("登录");
    }
}
