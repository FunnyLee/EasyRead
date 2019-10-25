package com.funny.wan.ui;

import android.content.Context;
import android.content.Intent;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.funny.component.base.BaseActivity;
import com.funny.component.router.RouterManager;
import com.funny.wan.R;

@Route(path = RouterManager.MAIN_ACTIVITY)
public class MainActivity extends BaseActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
//        starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
