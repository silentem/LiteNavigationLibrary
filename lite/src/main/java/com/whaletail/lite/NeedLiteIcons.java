package com.whaletail.lite;

import android.support.annotation.DrawableRes;
import android.support.v4.util.Pair;

/**
 * @author whaletail
 * @date 18.01.18.
 */

public interface NeedLiteIcons {
    NeedLitePage icons(@DrawableRes Integer on, @DrawableRes Integer off);

    NeedLitePage icons(Pair<Integer, Integer> icons);

    NeedLitePage icon(@DrawableRes Integer icon);
}
