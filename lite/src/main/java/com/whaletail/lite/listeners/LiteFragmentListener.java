package com.whaletail.lite.listeners;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

/**
 * @author whaletail
 */

public interface LiteFragmentListener {
    @NonNull
    Fragment getFragment();

    boolean checkBeforeGetFragment(int position);
}
