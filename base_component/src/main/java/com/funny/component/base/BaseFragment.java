package com.funny.component.base;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.funny.component.utils.ClassUtil;

/**
 * Author: Funny
 * Time: 2019/11/4
 * Description: This is BaseFragment
 */
public abstract class BaseFragment<VM extends AndroidViewModel, B extends ViewDataBinding> extends Fragment {

    protected VM mViewModel;
    protected B mBindingView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mBindingView = DataBindingUtil.setContentView(getActivity(), getLayoutId());
        View rootView = mBindingView.getRoot();
        createViewModle();
        initImmersionbar();
        initView();
        initData();
        initEvent();
        return rootView;
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

    private void createViewModle(){
        Class<VM> viewModelClass = ClassUtil.getViewModel(this);
        if(viewModelClass != null){
            mViewModel = ViewModelProviders.of(this).get(viewModelClass);
        }
    }

}
