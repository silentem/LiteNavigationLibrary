package com.whaletail.lite;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.util.Pair;

/**
 * @author whaletail
 * @date 18.01.18.
 */

public interface NeedLiteIcons {
    NeedLitePage icons(@NonNull @DrawableRes Integer on, @NonNull @DrawableRes Integer off);

    NeedLitePage icons(@NonNull Pair<Integer, Integer> icons);

    NeedLitePage icon(@NonNull @DrawableRes Integer icon);
}
