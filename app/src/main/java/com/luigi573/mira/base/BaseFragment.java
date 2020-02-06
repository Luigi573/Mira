package com.luigi573.mira.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;

public abstract class BaseFragment extends DaggerFragment {
    private Unbinder unbinder;
    private View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getLayoutResId()!= 0){
            mView = inflater.inflate(getLayoutResId(), container, false);
            unbinder = ButterKnife.bind(this, mView);
        }else{
            mView = initView(savedInstanceState);
        }
        return mView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    public abstract int getLayoutResId();
    protected abstract View initView(Bundle savedInstanceState);

}
