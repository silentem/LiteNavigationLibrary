package com.whaletail.lite.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * @author whaletail
 * @date 18.01.18.
 */

public class LiteNavigatorItem extends RelativeLayout {
    private int position;
    private ImageView icon;
    private int on;
    private int off;

    public LiteNavigatorItem(@NonNull Context context) {
        super(context);
    }

    public LiteNavigatorItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LiteNavigatorItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    void init() {
        icon = new ImageView(getContext());

        LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.addRule(CENTER_IN_PARENT);
        addView(icon, lp);
    }

    void init(@NonNull LayoutParams layoutParams) {
        icon = new ImageView(getContext());
        addView(icon, layoutParams);
    }

    void init(@NonNull LayoutParams layoutParams, @NonNull ViewGroup layout, ImageView icon) {
        if (icon != null) {
            this.icon = icon;
        } else {
            this.icon = new ImageView(getContext());
        }

        addView(layout, layoutParams);
    }

    void init(@NonNull ViewGroup layout, ImageView icon) {
        if (icon != null) {
            this.icon = icon;
        } else {
            this.icon = new ImageView(getContext());
        }

        LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.addRule(CENTER_IN_PARENT);

        addView(layout, lp);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setIcon(int on, int off) {
        this.on = on;
        this.off = off;
    }

    public void setOn() {
        icon.setImageResource(on);
    }

    public void setOff() {
        icon.setImageResource(off);
    }

}
