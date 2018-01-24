package com.whaletail.lite.litenavigationlibrary.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.whaletail.lite.litenavigationlibrary.R;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiteFragment extends Fragment {


    @BindView(R.id.tv_test)
    TextView testTextView;

    public LiteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lite, container, false);
        ButterKnife.bind(this, view);

        testTextView.setText(new Random().nextInt() + " is new random value");

        return view;
    }

}
