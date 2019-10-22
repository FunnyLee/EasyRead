package com.funny.component.utils;

import android.widget.Toast;

import com.funny.component.AppManager;

/**
 * Author: Funny
 * Time: 2019/10/22
 * Description: This is ToastUtil
 */
public class ToastUtil {

    public static void show(String msg) {
        Toast.makeText(AppManager.getAppManagerContext(), msg, Toast.LENGTH_SHORT).show();
    }

}
