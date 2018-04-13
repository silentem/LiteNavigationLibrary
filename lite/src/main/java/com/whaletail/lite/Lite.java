package com.whaletail.lite;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.whaletail.lite.listeners.LiteFragmentListener;
import com.whaletail.lite.listeners.LiteLayoutParamsListener;
import com.whaletail.lite.listeners.OnAllClickListener;
import com.whaletail.lite.views.LiteBottomNavigator;
import com.whaletail.lite.views.LiteGeneralHolder;
import com.whaletail.lite.views.LiteNavigationItem;

import java.util.ArrayList;
import java.util.List;


/**
 * @author whaletail
 * @date 18.01.18.
 */

public class Lite {

    public static NeedLiteNavigator builder(@NonNull Context context, @NonNull FragmentManager manager) {
        return new LiteBuilder(context, manager);
    }

    public static NeedLiteNavigator builder(@NonNull AppCompatActivity activity) {
        return new LiteBuilder(activity, activity.getSupportFragmentManager());
    }

    public static NeedLiteNavigator builder(@NonNull Fragment fragment) {
        return new LiteBuilder(fragment.getContext(), fragment.getFragmentManager());
    }

    static class LiteBuilder implements NeedLiteIcons, NeedLiteHolder, NeedLiteNavigator, NeedLitePage, Buildable {

        private static final String TAG = LiteBuilder.class.getSimpleName();

        private int startPosition = 0;

        private List<View> views;

        private List<LiteFragmentListener> listeners;

        private ViewGroup holder;

        private LiteBottomNavigator navigator;

        private FragmentManager manager;

        private Context context;

        private OnAllClickListener onAllClickListener;

        LiteBuilder(Context context, FragmentManager manager) {
            this.manager = manager;
            this.context = context;
        }

        @Override
        public NeedLitePage holder(@NonNull LiteGeneralHolder holder) {
            this.holder = holder;
            return this;
        }

        @Override
        public NeedLitePage holder(@NonNull ViewGroup holder) {
            this.holder = holder;
            return this;
        }

        @Override
        public NeedLiteHolder navigator(@NonNull LiteBottomNavigator navigator) {
            this.navigator = navigator;
            return this;
        }

        @Override
        public NeedLitePage icons(@NonNull final Integer on, @NonNull final Integer off) {
            if (views == null) views = new ArrayList<>();
            views.add(new LiteNavigationItem(context) {

                        @Override
                        protected View getView() {
                            return new ImageView(context);
                        }

                        @Override
                        public void on(View view) {
                            if (view instanceof ImageView) {
                                ((ImageView) view).setImageResource(on);
                            }
                        }

                        @Override
                        public void off(View view) {
                            if (view instanceof ImageView) {
                                ((ImageView) view).setImageResource(off);
                            }
                        }
                    }.init());
            return this;
        }

        @Override
        public NeedLitePage icons(@NonNull final Pair<Integer, Integer> icons) {
            if (views == null) views = new ArrayList<>();
            views.add(new LiteNavigationItem(context) {

                        @Override
                        protected View getView() {
                            return new ImageView(context);
                        }

                        @Override
                        public void on(View view) {
                            if (view instanceof ImageView) {
                                ((ImageView) view).setImageResource(icons.first);
                            }
                        }

                        @Override
                        public void off(View view) {
                            if (view instanceof ImageView) {
                                ((ImageView) view).setImageResource(icons.second);
                            }
                        }
                    }.init());
            return this;
        }

        @Override
        public NeedLitePage icon(@NonNull final Integer icon) {
            if (views == null) views = new ArrayList<>();
            views.add(new LiteNavigationItem(context) {

                        @Override
                        protected View getView() {
                            return new ImageView(context);
                        }

                        @Override
                        public void on(View view) {
                            if (view instanceof ImageView) {
                                ((ImageView) view).setImageResource(icon);
                            }
                        }

                        @Override
                        public void off(View view) {
                            if (view instanceof ImageView) {
                                ((ImageView) view).setImageResource(icon);
                            }
                        }
                    }.init());
            return this;
        }

        @Override
        public NeedLitePage icons(@NonNull final Pair<Integer, Integer> icons, @NonNull LiteLayoutParamsListener listener) {
            if (views == null) views = new ArrayList<>();
            LiteNavigationItem item = new LiteNavigationItem(context) {

                @Override
                protected View getView() {
                    return new ImageView(context);
                }

                @Override
                public void on(View view) {
                    if (view instanceof ImageView) {
                        ((ImageView) view).setImageResource(icons.first);
                    }
                }

                @Override
                public void off(View view) {
                    if (view instanceof ImageView) {
                        ((ImageView) view).setImageResource(icons.second);
                    }
                }
            }.init();
            item.setLayoutParams(listener.getLayoutParams());
            views.add(item);
            return this;
        }

        @Override
        public NeedLitePage icons(@NonNull final Integer on, @NonNull final Integer off, LiteLayoutParamsListener listener) {
            if (views == null) views = new ArrayList<>();
            LiteNavigationItem item = new LiteNavigationItem(context) {

                @Override
                protected View getView() {
                    return new ImageView(context);
                }

                @Override
                public void on(View view) {
                    if (view instanceof ImageView) {
                        ((ImageView) view).setImageResource(on);
                    }
                }

                @Override
                public void off(View view) {
                    if (view instanceof ImageView) {
                        ((ImageView) view).setImageResource(off);
                    }
                }
            }.init();
            item.setLayoutParams(listener.getLayoutParams());
            views.add(item);
            return this;
        }


        @Override
        public NeedLitePage icon(@NonNull final Integer icon, @NonNull LiteLayoutParamsListener listener) {
            if (views == null) views = new ArrayList<>();
            LiteNavigationItem item = new LiteNavigationItem(context) {

                @Override
                protected View getView() {
                    return new ImageView(context);
                }

                @Override
                public void on(View view) {
                    if (view instanceof ImageView) {
                        ((ImageView) view).setImageResource(icon);
                    }
                }

                @Override
                public void off(View view) {
                    if (view instanceof ImageView) {
                        ((ImageView) view).setImageResource(icon);
                    }
                }
            }.init();
            item.setLayoutParams(listener.getLayoutParams());
            views.add(item);
            return this;
        }

        @Override
        public NeedLitePage item(@NonNull LiteNavigationItem item) {
            if (views == null) {
                views = new ArrayList<>();
            }
            views.add(item.init());
            return this;
        }

        @Override
        public LiteState build() {
            if (navigator != null) {
                navigator.init(views);
            }
            if (views != null) {
                setOnClickListenersToItems(views);
            }

            return new LiteState(0);
        }


        private void setOnClickListenersToItems(@NonNull List<View> views) {
            for (int i = 0; i < views.size(); i++) {
                View view = views.get(i);
                view.setOnClickListener(new BaseLiteOnClickListener(i));
            }
            if (views.size() > startPosition) {
                setPosition(startPosition);
                View view = views.get(startPosition);
                if (view instanceof LiteNavigationItem) {
                    ((LiteNavigationItem) view).on();
                }
            }
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

                @Override
                public boolean checkBeforeGetFragment(int position) {
                    return true;
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
        public Buildable allClickListener(OnAllClickListener onAllClickListener) {
            this.onAllClickListener = onAllClickListener;
            return this;
        }

        private void setPosition(int position) {
            if (listeners == null) {
                Log.e(TAG, "LiteFragmentListeners is null on position " + position);
                return;
            }
            if (manager == null) {
                Log.e(TAG, "FragmentManger is null on position " + position);
                return;
            }

            LiteFragmentListener liteFragmentListener = listeners.get(position);

            if (liteFragmentListener == null) {
                Log.e(TAG, "Item is null on position " + position);
                return;
            }
            if (liteFragmentListener.checkBeforeGetFragment(position)) {
                manager.beginTransaction()
                        .replace(holder.getId(), liteFragmentListener.getFragment())
                        .commit();
                if (onAllClickListener != null) {
                    onAllClickListener.onAllClick();
                }
            }
        }

        private class BaseLiteOnClickListener implements View.OnClickListener {

            private int position;

            private BaseLiteOnClickListener(int position) {
                this.position = position;
            }

            @Override
            public void onClick(View v) {
                setPosition(position);
                if (v instanceof LiteNavigationItem) {
                    LiteNavigationItem item = (LiteNavigationItem) v;
                    switch (item.getState()) {
                        case ON: {
                            item.off();
                            break;
                        }
                        case OFF: {
                            item.on();
                            break;
                        }
                    }
                }
            }
        }

    }

}
