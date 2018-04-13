package com.whaletail.lite.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

/**
 * @author whaletail
 * @date 18.01.18.
 */

public class LiteBottomNavigator extends LinearLayout {

    private static final String TAG = LiteBottomNavigator.class.getSimpleName();

    public LiteBottomNavigator(Context context) {
        super(context);
    }

    public LiteBottomNavigator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LiteBottomNavigator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init(List<View> views) {
        if (views == null) {
            Log.e(TAG, "LiteBottomNavigator must have item views");
            return;
        }
        float weight = 1F / views.size();
        for (int i = 0; i < views.size(); i++) {
            View item = views.get(i);
            if (item == null) {
                Log.e(TAG, "LiteBottomNavigator view item is null on position " + i);
                continue;
            }
            ViewGroup.LayoutParams layoutParams = item.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, weight);
            }
            addView(item, layoutParams);
        }
    }
}
