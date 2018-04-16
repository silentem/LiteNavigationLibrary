package com.whaletail.lite.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
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

    public void init(List<LiteNavigationItem> views) {
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
            LinearLayout.LayoutParams layoutParams = (LayoutParams) item.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, weight);
                layoutParams.gravity = Gravity.CENTER;
            }
            addView(item, layoutParams);
        }
    }

    public void setAllItemOff() {
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) instanceof LiteNavigationItem) {
                LiteNavigationItem item = (LiteNavigationItem) getChildAt(i);
                item.off();
            }
        }
    }

}
