package com.funny.wan.ui;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.funny.component.base.BaseActivity;
import com.funny.component.router.RouterManager;
import com.funny.wan.R;

@Route(path = RouterManager.MAIN_ACTIVITY)
public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
