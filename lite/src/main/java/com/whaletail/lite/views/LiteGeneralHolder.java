package com.whaletail.lite.views;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

import com.whaletail.lite.listeners.LiteFragmentListener;

import java.util.List;

/**
 * @author whaletail
 * @date 18.01.18.
 */

public class LiteGeneralHolder extends FrameLayout {
    public LiteGeneralHolder(@NonNull Context context) {
        super(context);
    }

    public LiteGeneralHolder(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public LiteGeneralHolder(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
