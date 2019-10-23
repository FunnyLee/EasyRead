package com.funny.wan.ui;

import android.content.Context;
import android.content.Intent;

import com.funny.component.base.BaseActivity;
import com.funny.wan.R;

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
