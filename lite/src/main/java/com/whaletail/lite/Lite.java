package com.whaletail.lite;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.Pair;

import com.whaletail.lite.listeners.SwitchListener;
import com.whaletail.lite.views.LiteBottomNavigator;
import com.whaletail.lite.views.LiteGeneralHolder;

import java.util.ArrayList;
import java.util.List;


/**
 * @author whaletail
 * @date 18.01.18.
 */

public class Lite {

    static String POSITION_KEY = "lite_general_holder_position";

    static class LiteBuilder implements NeedLiteIcons, NeedLiteHolder, NeedLiteNavigator, NeedLitePage, Buildable {

        private List<Pair<Integer, Integer>> icons;

        private List<LiteFragmentListener> listeners;

        private LiteGeneralHolder holder;

        private LiteBottomNavigator navigator;

        private FragmentManager manager;

        LiteBuilder(FragmentManager manager) {
            this.manager = manager;
        }

        @Override
        public NeedLitePage holder(LiteGeneralHolder holder) {
            this.holder = holder;
            return this;
        }

        @Override
        public NeedLiteHolder navigator(LiteBottomNavigator navigator) {
            this.navigator = navigator;
            return this;
        }

        @Override
        public NeedLitePage icons(@NonNull Integer on, @NonNull Integer off) {
            if (icons == null) icons = new ArrayList<>();
            icons.add(new Pair<>(on, off));
            return this;
        }

        @Override
        public NeedLitePage icons(@NonNull Pair<Integer, Integer> icons) {
            if (this.icons == null) this.icons = new ArrayList<>();
            this.icons.add(icons);
            return this;
        }

        @Override
        public NeedLitePage icon(@NonNull Integer icon) {
            if (icons == null) icons = new ArrayList<>();
            icons.add(new Pair<>(icon, icon));
            return this;
        }

        @Override
        public void build() {
            navigator.createNavigators(icons);
            holder.setManager(manager);
            holder.setFragmentListeners(listeners);
            navigator.setClickListener(holder.getListener());
        }

        @Override
        public NeedLiteIcons page(final Fragment fragment) {
            if (listeners == null) listeners = new ArrayList<>();
            listeners.add(new LiteFragmentListener() {
                @NonNull
                @Override
                public Fragment getFragment() {
                    return fragment;
                }
            });
            return this;
        }

        @Override
        public NeedLiteIcons page(LiteFragmentListener liteFragmentListener) {
            if (listeners == null) listeners = new ArrayList<>();
            listeners.add(liteFragmentListener);
            return this;
        }

        @Override
        public Buildable switchListener(SwitchListener switchListener) {
            navigator.setSwitchListener(switchListener);
            return this;
        }

    }

    public static NeedLiteNavigator builder(FragmentManager manager) {
        return new LiteBuilder(manager);
    }

}
