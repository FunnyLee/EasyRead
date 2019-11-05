package com.funny.wan.ui.fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.funny.component.base.BaseFragment;
import com.funny.component.router.RouterManager;
import com.funny.wan.R;

/**
 * Author: Funny
 * Time: 2019/11/5
 * Description: This is WanMainFragment
 */
@Route(path = RouterManager.WAN_MIAN_FRAGMENT)
public class WanMainFragment extends BaseFragment {

    public static WanMainFragment newInstance() {
        WanMainFragment fragment = (WanMainFragment) ARouter.getInstance().build(RouterManager.WAN_MIAN_FRAGMENT).navigation();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wan_main;
    }
}
