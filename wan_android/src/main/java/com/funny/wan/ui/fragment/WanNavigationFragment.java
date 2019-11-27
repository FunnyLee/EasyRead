package com.funny.wan.ui.fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.funny.component.base.BaseFragment;
import com.funny.component.router.RouterManager;
import com.funny.wan.R;
import com.funny.wan.databinding.FragmentWanNavigationBinding;
import com.funny.wan.viewModel.NoViewModel;

/**
 * Author: Funny
 * Time: 2019/11/5
 * Description: This is WanNavigationFragment
 */
@Route(path = RouterManager.WAN_NAVIGATION_FRAGMENT)
public class WanNavigationFragment extends BaseFragment<NoViewModel, FragmentWanNavigationBinding> {

    public static WanNavigationFragment newInstance() {
        WanNavigationFragment fragment = (WanNavigationFragment) ARouter.getInstance().build(RouterManager.WAN_NAVIGATION_FRAGMENT).navigation();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wan_navigation;
    }
}
