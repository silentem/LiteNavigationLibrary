package com.whaletail.lite.views;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.whaletail.lite.listeners.SwitchListener;

import java.util.ArrayList;
import java.util.List;

import static com.whaletail.lite.LiteConstants.POSITION_KEY;

/**
 * @author whaletail
 * @date 18.01.18.
 */

public class LiteBottomNavigator extends LinearLayout {

    private int currentPosition = 0;

    private List<LiteNavigatorItem> liteNavigatorItems;

    private LiteGeneralHolder.OnItemClick clickListener;

    private SwitchListener switchListener;

    public LiteBottomNavigator(Context context) {
        super(context);
    }

    public LiteBottomNavigator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LiteBottomNavigator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Nullable
    @Override
    protected Parcelable onSaveInstanceState() {
        super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        if (currentPosition != 0) {
            bundle.putInt(POSITION_KEY, currentPosition);
        }
        return bundle;
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            int position = bundle.getInt(POSITION_KEY);
            if (position != 0) {
                setCurrentPosition(position);
            }
            state = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(state);
    }

    public void setClickListener(LiteGeneralHolder.OnItemClick clickListener) {
        this.clickListener = clickListener;
    }

    public void setSwitchListener(SwitchListener switchListener) {
        this.switchListener = switchListener;
    }

    public void createNavigators(List<Pair<Integer, Integer>> menuIcons) {
        float weight = 1;
        liteNavigatorItems = new ArrayList<>();
        for (int i = 0; i < menuIcons.size(); i++) {
            Pair<Integer, Integer> menuIcon = menuIcons.get(i);
            Integer on = menuIcon.first;
            Integer off = menuIcon.second;

            LiteNavigatorItem icon = new LiteNavigatorItem(getContext());
            liteNavigatorItems.add(icon);
            icon.setIcon(on, off);
            icon.setPosition(i);
            if (i == 0) {
                icon.setOn();
            } else {
                icon.setOff();
            }

            icon.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    LiteNavigatorItem navigatorItem = (LiteNavigatorItem) view;
                    if (switchListener != null) {
                        switchListener.onSwitch();
                    }
                    int positionPressed = navigatorItem.getPosition();
                    setCurrentPosition(positionPressed);
                }
            });

            LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            lp.gravity = Gravity.CENTER;
            lp.weight = weight;

            addView(icon, lp);
        }

    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int positionPressed) {
        if (clickListener.onItemClick(positionPressed)) {
            liteNavigatorItems.get(positionPressed).setOn();
            liteNavigatorItems.get(currentPosition).setOff();
            currentPosition = positionPressed;
        }
    }

}
