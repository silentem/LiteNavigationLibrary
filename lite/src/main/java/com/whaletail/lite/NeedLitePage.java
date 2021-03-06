package com.whaletail.lite;

import android.support.v4.app.Fragment;

import com.whaletail.lite.listeners.LiteFragmentListener;
import com.whaletail.lite.listeners.OnAllClickListener;

/**
 * @author whaletail
 * @date 19.01.18.
 */

public interface NeedLitePage {
    NeedLiteIcons page(Fragment fragment);
    NeedLiteIcons page(LiteFragmentListener liteFragmentListener);
    Buildable allClickListener(OnAllClickListener onAllClickListener);
    LiteState build();
}
