package com.luigi573.mira.statistics;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.luigi573.mira.R;
import com.luigi573.mira.base.BaseFragment;
import com.luigi573.mira.di.ActivityScoped;

import javax.inject.Inject;

import butterknife.BindView;

@ActivityScoped
public class StatisticsFragment extends BaseFragment implements StatisticsContract.View{
    @Inject
    StatisticsContract.Presenter mPresenter;

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    @BindView(R.id.update_time)
    TextView updatedTime;

    @BindView(R.id.confirmed)
    TextView confirmedCount;

    @BindView(R.id.confirmed_text)
    TextView confirmedText;

    @BindView(R.id.suspected)
    TextView suspectedCount;

    @BindView(R.id.suspected_text)
    TextView suspectedText;

    @BindView(R.id.cured)
    TextView curedCount;

    @BindView(R.id.cured_text)
    TextView curedText;

    @BindView(R.id.dead)
    TextView deadCount;

    @BindView(R.id.dead_text)
    TextView deadText;

    @BindView(R.id.progress_circular)
    ProgressBar progressBar;

    @BindView(R.id.failed_icon)
    View failedIcon;

    @BindView(R.id.image)
    ImageView image;

    @Inject
    public StatisticsFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
        return v;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.statistics_frag;
    }

    @Override
    protected View initView(Bundle savedInstanceState) {
        View v = View.inflate(getActivity(),R.layout.statistics_frag, null);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

        refreshLayout.setOnRefreshListener(() -> mPresenter.refresh());

        progressBar.setVisibility(View.GONE);
        failedIcon.setVisibility(View.GONE);
        mPresenter.takeView(this);
    }

    @Override
    public void onDestroy() {
        mPresenter.dropView();
        super.onDestroy();
    }

    @Override
    public void showModifyTime(String timeString) {
        updatedTime.setText("数据更新至 " + timeString);
    }

    @Override
    public void showConfirmed(int count) {
        confirmedCount.setText(count + "");
    }

    @Override
    public void showSuspected(int count) {
        suspectedCount.setText(count + "");
    }

    @Override
    public void showCured(int count) {
        curedCount.setText(count + "");
    }

    @Override
    public void showDead(int count) {
        deadCount.setText(count + "");
    }

    @Override
    public void setLoadingIndicator(boolean isLoading) {
        setStatHided(isLoading);
        setRefreshLayout(isLoading);
        progressBar.setVisibility(isLoading?View.VISIBLE:View.GONE);
    }

    private void setRefreshLayout(boolean isLoading) {
        refreshLayout.setRefreshing(isLoading);
    }

    private void setStatHided(boolean hided) {
        confirmedCount.setVisibility(hided?View.GONE:View.VISIBLE);
        confirmedText.setVisibility(hided?View.GONE:View.VISIBLE);
        suspectedCount.setVisibility(hided?View.GONE:View.VISIBLE);
        suspectedText.setVisibility(hided?View.GONE:View.VISIBLE);
        curedCount.setVisibility(hided?View.GONE:View.VISIBLE);
        curedText.setVisibility(hided?View.GONE:View.VISIBLE);
        deadCount.setVisibility(hided?View.GONE:View.VISIBLE);
        deadText.setVisibility(hided?View.GONE:View.VISIBLE);
    }

    @Override
    public void setRequestStatus(boolean isSuccess) {
        setStatHided(!isSuccess);
        failedIcon.setVisibility(isSuccess?View.GONE:View.VISIBLE);
        updatedTime.setVisibility(isSuccess?View.VISIBLE:View.GONE);
    }

    @Override
    public void setImage(String imageUrl) {
        Glide.with(this).load(imageUrl).into(image);
    }
}
