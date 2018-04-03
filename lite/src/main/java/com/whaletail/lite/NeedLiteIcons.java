package com.whaletail.lite;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.util.Pair;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.whaletail.lite.listeners.LiteLayoutParamsListener;

/**
 * @author whaletail
 * @date 18.01.18.
 */

public interface NeedLiteIcons {
    NeedLitePage icons(@NonNull @DrawableRes Integer on,
                       @NonNull @DrawableRes Integer off);

    NeedLitePage icons(@NonNull Pair<Integer, Integer> icons);

    NeedLitePage icon(@NonNull @DrawableRes Integer icon);

    NeedLitePage icons(@NonNull Pair<Integer, Integer> icons,
                       LiteLayoutParamsListener liteLayoutParamsListener);

    NeedLitePage icons(@NonNull @DrawableRes Integer on,
                       @NonNull @DrawableRes Integer off,
                       LiteLayoutParamsListener liteLayoutParamsListener);

    NeedLitePage icons(@NonNull @DrawableRes Integer on,
                       @NonNull @DrawableRes Integer off,
                       @NonNull ViewGroup layout,
                       ImageView icon,
                       LiteLayoutParamsListener liteLayoutParamsListener);

    NeedLitePage icon(@NonNull @DrawableRes Integer icon,
                      LiteLayoutParamsListener liteLayoutParamsListener);
}
