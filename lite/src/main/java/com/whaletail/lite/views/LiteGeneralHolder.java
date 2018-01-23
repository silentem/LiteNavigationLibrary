package com.whaletail.lite.views;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import java.util.List;

/**
 * @author whaletail
 * @date 18.01.18.
 */

public class LiteGeneralHolder extends FrameLayout {

    private List<Fragment> fragments;

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
        manager.beginTransaction()
                .remove(manager.findFragmentById(getId()))
                .commit();
        return super.onSaveInstanceState();
    }

    public void setFragments(List<Fragment> fragments) {
        if (fragments.isEmpty())
            throw new RuntimeException("LiteGeneralHolder must be filled with at least 1 fragment");
        if (manager == null)
            throw new RuntimeException("LiteGeneralHolder must have fragment manager");
        this.fragments = fragments;
        manager.beginTransaction()
                .add(getId(), fragments.get(0))
                .commit();
    }

    public void setManager(FragmentManager manager) {
        this.manager = manager;
    }

    class OnItemClick {
        void onItemClick(int newPosition) {
            manager.beginTransaction()
                    .replace(getId(), fragments.get(newPosition))
                    .commit();
        }
    }

    public OnItemClick getListener() {
        return onItemClickListener;
    }

}
