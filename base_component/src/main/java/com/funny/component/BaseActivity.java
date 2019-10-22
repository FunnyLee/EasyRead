package com.funny.component;

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
public class BaseActivity<VM extends AndroidViewModel, B extends ViewDataBinding> extends BaseTitleActivity {

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

        //设置contentView
        View contentView = mBingdingView.getRoot();
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        contentView.setLayoutParams(params);
        mContainerView.addView(contentView);
        initViewModle();
    }

    private void initViewModle() {
        Class<VM> viewModelClass = ClassUtil.getViewModel(this);
        if (viewModelClass != null) {
            mViewModel = ViewModelProviders.of(this).get(viewModelClass);
        }
    }


}
