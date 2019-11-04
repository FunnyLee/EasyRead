package com.funny.wan.ui;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.funny.component.base.BaseActivity;
import com.funny.component.router.RouterManager;
import com.funny.wan.R;
import com.funny.wan.databinding.ActivityMainBinding;
import com.funny.wan.viewModel.MainViewModel;
import com.gyf.immersionbar.ImmersionBar;

@Route(path = RouterManager.MAIN_ACTIVITY)
public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initImmersionbar() {
        ImmersionBar.with(this).statusBarView(mBingdingView.statusView).init();
    }
}
