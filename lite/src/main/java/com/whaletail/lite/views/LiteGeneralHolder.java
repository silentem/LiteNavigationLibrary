package com.whaletail.lite.views;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.whaletail.lite.listeners.LiteFragmentListener;

import java.util.List;

/**
 * @author whaletail
 * @date 18.01.18.
 */

public class LiteGeneralHolder extends FrameLayout {

    private static final String TAG = LiteGeneralHolder.class.getSimpleName();

    private List<LiteFragmentListener> listeners;

    private FragmentManager manager;

    private OnItemClick onItemClickListener = new OnItemClick();

    public LiteGeneralHolder(@NonNull Context context) {
        super(context);
    }

    public LiteGeneralHolder(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LiteGeneralHolder(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Nullable
    @Override
    protected Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    public void setFragmentListeners(List<LiteFragmentListener> listeners) {
        if (listeners.isEmpty())
            throw new RuntimeException("LiteGeneralHolder must be filled with at least 1 fragment");
        if (manager == null)
            throw new RuntimeException("LiteGeneralHolder must have fragment manager");
        this.listeners = listeners;
        if (listeners.get(0).onPreGetFragment(0)) {
            manager.beginTransaction()
                    .replace(getId(), listeners.get(0).getFragment())
                    .commit();
        }
    }

    public void clean() {
        if (listeners != null) {
            listeners.clear();
        }
    }

    public void setManager(FragmentManager manager) {
        this.manager = manager;
    }

    public OnItemClick getListener() {
        if (onItemClickListener != null) {
            return onItemClickListener;
        } else {
            return new OnItemClick();
        }
    }

    class OnItemClick {
        boolean onItemClick(int newPosition) {
            if (listeners.get(newPosition).onPreGetFragment(newPosition)) {
                manager.beginTransaction()
                        .replace(getId(), listeners.get(newPosition).getFragment())
                        .commitAllowingStateLoss();
                return true;
            } else {
                return false;
            }
        }
    }

}
