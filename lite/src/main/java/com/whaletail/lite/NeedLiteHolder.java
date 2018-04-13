package com.whaletail.lite;


import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.whaletail.lite.views.LiteGeneralHolder;

/**
 * @author whaletail
 * @date 18.01.18.
 */

public interface NeedLiteHolder {
    NeedLitePage holder(@NonNull LiteGeneralHolder holder);

    NeedLitePage holder(@NonNull ViewGroup viewGroup);
}
