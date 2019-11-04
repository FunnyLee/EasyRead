package com.funny.wan.ui;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.funny.component.base.BaseFragment;
import com.funny.component.router.RouterManager;
import com.funny.wan.R;

/**
 * Author: Funny
 * Time: 2019/11/4
 * Description: This is FilmFragment
 */
@Route(path = RouterManager.FILM_FRAGMENT)
public class FilmFragment extends BaseFragment {

    public static FilmFragment newInstance() {

        Bundle args = new Bundle();

        FilmFragment fragment = new FilmFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_film;
    }
}
