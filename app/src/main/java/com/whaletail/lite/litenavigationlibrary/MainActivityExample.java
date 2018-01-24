package com.whaletail.lite.litenavigationlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.whaletail.lite.Lite;
import com.whaletail.lite.litenavigationlibrary.fragment.LiteFragment;
import com.whaletail.lite.views.LiteBottomNavigator;
import com.whaletail.lite.views.LiteGeneralHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivityExample extends AppCompatActivity {


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
                .page(new LiteFragment())
                .icons(R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round)
                .page(new LiteFragment())
                .icons(R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round)
                .page(new LiteFragment())
                .icons(R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round)
                .page(new LiteFragment())
                .icons(R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round)
                .page(new LiteFragment())
                .icons(R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round)
                .build();

    }
}
