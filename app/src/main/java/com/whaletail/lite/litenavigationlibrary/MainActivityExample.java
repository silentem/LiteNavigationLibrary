package com.whaletail.lite.litenavigationlibrary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.whaletail.lite.Lite;
import com.whaletail.lite.listeners.LiteFragmentListener;
import com.whaletail.lite.listeners.LiteLayoutParamsListener;
import com.whaletail.lite.listeners.SwitchListener;
import com.whaletail.lite.litenavigationlibrary.fragment.LiteFragment;
import com.whaletail.lite.views.LiteBottomNavigator;
import com.whaletail.lite.views.LiteGeneralHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivityExample extends AppCompatActivity {

    private static final String TAG = MainActivityExample.class.getSimpleName();

    @BindView(R.id.bottom_navigation_main)
    LiteBottomNavigator bottom;
    @BindView(R.id.viewpager_main)
    LiteGeneralHolder viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_example);
        ButterKnife.bind(this);
        Lite.builder(getSupportFragmentManager())
                .navigator(bottom)
                .holder(viewPager)
                .page(new LiteFragmentListener() {

                    private boolean shouldClick = false;

                    private boolean isShouldClick(int position) {
                        return shouldClick && position != bottom.getCurrentPosition();
                    }

                    private void setShouldClick(boolean shouldClick) {
                        this.shouldClick = shouldClick;
                    }

                    @NonNull
                    @Override
                    public Fragment getFragment() {
                        Log.i(TAG, "onClick triggered");
                        return new LiteFragment();
                    }

                    @Override
                    public boolean onPreGetFragment(final int position) {
                        Log.i(TAG, "position: " + position);

                        new Button(MainActivityExample.this).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setShouldClick(true);
                                bottom.setCurrentPosition(position);

                            }
                        });

                        return isShouldClick(position);
                    }
                })
                .icon(R.mipmap.ic_launcher_round, new LiteLayoutParamsListener() {
                    @Override
                    public RelativeLayout.LayoutParams getLayoutParams() {
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(50, 50);
                        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
                        return layoutParams;
                    }
                })
                .page(new LiteFragment())
                .icon(R.mipmap.ic_launcher_round, new LiteLayoutParamsListener() {
                    @Override
                    public RelativeLayout.LayoutParams getLayoutParams() {
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(75, 75);
                        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
                        return layoutParams;
                    }
                })
                .page(new LiteFragment())
                .icon(R.mipmap.ic_launcher_round, new LiteLayoutParamsListener() {
                    @Override
                    public RelativeLayout.LayoutParams getLayoutParams() {
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(100, 100);
                        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
                        return layoutParams;
                    }
                })
                .page(new LiteFragment())
                .icons(R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round)
                .page(new LiteFragment())
                .icons(R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round)
                .switchListener(new SwitchListener() {
                    @Override
                    public void onSwitch() {
                        Log.i(TAG, "onSwitch triggered");
                    }
                })
                .build();

    }
}
