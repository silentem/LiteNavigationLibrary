package com.whaletail.lite.views;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import static com.whaletail.lite.views.LiteNavigationItem.State.OFF;

/**
 * @author whaletail
 * @date 18.01.18.
 */

public class LiteNavigationItem extends AppCompatImageView {

    private State state = OFF;
    @DrawableRes
    private int on;
    @DrawableRes
    private int off;

    public LiteNavigationItem(@NonNull Context context) {
        super(context);
    }

    public LiteNavigationItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LiteNavigationItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LiteNavigationItem init(@DrawableRes int on, @DrawableRes int off) {
        this.on = on;
        this.off = off;
        setImageResource(off);
        return this;
    }


    public void on() {
        setState(LiteNavigationItem.State.ON);
        setImageResource(getOn());
    }

    public void off() {
        setState(LiteNavigationItem.State.OFF);
        setImageResource(getOff());
    }

    @Nullable
    @Override
    protected Parcelable onSaveInstanceState() {
        super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putInt("on", on);
        bundle.putInt("off", off);
        bundle.putSerializable("state", state);
        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        Bundle bundle = (Bundle) state;
        on = bundle.getInt("on");
        off = bundle.getInt("off");
        this.state = (State) bundle.getSerializable("state");
        super.onRestoreInstanceState(state);
    }

    public int getOn() {
        return on;
    }

    public int getOff() {
        return off;
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
