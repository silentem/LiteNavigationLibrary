package com.whaletail.lite.litenavigationlibrary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.whaletail.lite.Lite;
import com.whaletail.lite.LiteFragmentListener;
import com.whaletail.lite.listeners.SwitchListener;
import com.whaletail.lite.litenavigationlibrary.fragment.LiteFragment;
import com.whaletail.lite.views.LiteBottomNavigator;
import com.whaletail.lite.views.LiteGeneralHolder;

import java.util.Random;

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
                    @NonNull
                    @Override
                    public Fragment getFragment() {
                        Log.i(TAG, "onClick triggered");
                        return new LiteFragment();
                    }

                    @Override
                    public boolean onPreGetFragment(int position) {
                        Log.i(TAG, "position: " + position);
                        return new Random().nextBoolean();
                    }
                })
                .icons(R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round)
                .page(new LiteFragment())
                .icons(R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round)
                .page(new LiteFragment())
                .icons(R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round)
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
