package com.whaletail.lite;


import android.support.annotation.NonNull;

import com.whaletail.lite.views.LiteBottomNavigator;

/**
 * @author whaletail
 * @date 18.01.18.
 */

public interface NeedLiteNavigator {
    NeedLiteHolder navigator(@NonNull LiteBottomNavigator navigator);
}
