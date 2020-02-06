package com.luigi573.mira.base;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jaeger.library.StatusBarUtil;
import com.luigi573.mira.R;

import javax.inject.Inject;

import butterknife.BindColor;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DaggerActivity;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

public abstract class BaseActivity extends AppCompatActivity implements HasAndroidInjector {
    @Inject
    DispatchingAndroidInjector<Object> androidInjector;

    @BindColor(R.color.statusBarColor)
    int mColor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        setStatusBar();
    }


    private void setStatusBar() {
        StatusBarUtil.setColor(this, mColor, 0);
    }
    @Override
    public AndroidInjector<Object> androidInjector() {
        return androidInjector;
    }
}
