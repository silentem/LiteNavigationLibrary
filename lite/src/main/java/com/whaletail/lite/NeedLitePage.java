package com.whaletail.lite;

import android.support.v4.app.Fragment;

import com.whaletail.lite.listeners.SwitchListener;

/**
 * @author whaletail
 * @date 19.01.18.
 */

public interface NeedLitePage {
    NeedLiteIcons page(Fragment fragment);
    Buildable switchListener(SwitchListener switchListener);
    void build();
}
