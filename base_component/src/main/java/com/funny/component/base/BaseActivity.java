package com.funny.component.base;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

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
    protected void initContainerView(FrameLayout containerView) {
        mBingdingView = DataBindingUtil.inflate(getLayoutInflater(), getLayoutId(), null, false);
        if (mBingdingView != null) {
            //设置contentView
            View contentView = mBingdingView.getRoot();
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            contentView.setLayoutParams(params);
            containerView.addView(contentView);
            initViewModle();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    protected abstract void initView();

    protected abstract int getLayoutId();

    private void initViewModle() {
        Class<VM> viewModelClass = ClassUtil.getViewModel(this);
        if (viewModelClass != null) {
            mViewModel = ViewModelProviders.of(this).get(viewModelClass);
        }
    }
}
