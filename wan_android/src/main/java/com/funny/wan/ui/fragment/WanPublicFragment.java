package com.funny.wan.ui.fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.funny.component.base.BaseFragment;
import com.funny.component.router.RouterManager;
import com.funny.wan.R;

/**
 * Author: Funny
 * Time: 2019/11/5
 * Description: This is WanPublicFragment
 */
@Route(path = RouterManager.WAN_PUBLIC_FRAGMENT)
public class WanPublicFragment extends BaseFragment {

    public static WanPublicFragment newInstance() {
        WanPublicFragment fragment = (WanPublicFragment) ARouter.getInstance().build(RouterManager.WAN_PUBLIC_FRAGMENT).navigation();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wan_public;
    }
}
