package com.funny.component;

import android.arch.lifecycle.AndroidViewModel;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Author: Funny
 * Time: 2019/10/21
 * Description: This is BaseActivity
 */
public class BaseActivity<VM extends AndroidViewModel, B extends ViewDataBinding> extends AppCompatActivity {

    protected VM mViewModel;
    protected B mBingdingView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

        mBingdingView = DataBindingUtil.inflate(getLayoutInflater(), layoutResID, null, false);
    }
}
