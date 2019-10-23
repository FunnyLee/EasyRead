package com.funny.component.base;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.funny.component.utils.ClassUtil;

/**
 * Author: Funny
 * Time: 2019/10/21
 * Description: This is BaseActivity
 */
public abstract class BaseActivity<VM extends AndroidViewModel, B extends ViewDataBinding> extends BaseTitleActivity {

    protected VM mViewModel;
    protected B mBingdingView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBingdingView = DataBindingUtil.setContentView(this, getLayoutId());
        createViewModle();
        initImmersionbar();
        initView();
        initData();
        initEvent();
    }

    protected abstract int getLayoutId();


    protected void initImmersionbar() {
    }

    protected void initView() {
    }

    protected void initData() {
    }

    protected void initEvent() {
    }


    private void createViewModle() {
        Class<VM> viewModelClass = ClassUtil.getViewModel(this);
        if (viewModelClass != null) {
            mViewModel = ViewModelProviders.of(this).get(viewModelClass);
        }
    }
}
