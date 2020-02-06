package com.luigi573.mira.statistics;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.luigi573.mira.R;
import com.luigi573.mira.base.BaseActivity;
import com.luigi573.mira.util.ActivityUtils;

import javax.inject.Inject;

public class StatisticsActivity extends BaseActivity {


    @Inject StatisticsFragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics_act);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), fragment, R.id.container);



    }
}
