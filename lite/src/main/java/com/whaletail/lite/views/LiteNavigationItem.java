package com.whaletail.lite.views;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import static com.whaletail.lite.views.LiteNavigationItem.State.OFF;
import static com.whaletail.lite.views.LiteNavigationItem.State.ON;

/**
 * @author whaletail
 * @date 18.01.18.
 */

public abstract class LiteNavigationItem extends FrameLayout {

    private State state = OFF;

    public LiteNavigationItem(@NonNull Context context) {
        super(context);
    }

    public LiteNavigationItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LiteNavigationItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LiteNavigationItem init() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        addView(getView(), layoutParams);
        off();
        return this;
    }

    protected abstract View getView();

    public abstract void on(View view);

    public abstract void off(View view);

    public void on(){
        if (getChildCount() > 0) {
            on(getChildAt(0));
            setState(ON);
        }
    }

    public void off(){
        if (getChildCount() > 0) {
            off(getChildAt(0));
            setState(OFF);
        }
    }

    @Nullable
    @Override
    protected Parcelable onSaveInstanceState() {
        super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putSerializable("state", state);
        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        Bundle bundle = (Bundle) state;
        this.state = (State) bundle.getSerializable("state");
        super.onRestoreInstanceState(state);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public enum State {
        ON, OFF
    }
}
