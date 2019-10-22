package com.funny.wan.ui;

import android.view.View;

import com.funny.component.base.BaseActivity;
import com.funny.wan.R;
import com.funny.wan.databinding.ActivityUserBinding;
import com.funny.wan.viewModel.UserViewModel;

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

    @Override
    protected void initEvent() {
        mBingdingView.registeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.registe();
            }
        });
    }
}
