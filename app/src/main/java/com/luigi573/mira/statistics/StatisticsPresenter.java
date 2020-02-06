package com.luigi573.mira.statistics;

import android.util.Log;

import com.luigi573.mira.data.Statistics;
import com.luigi573.mira.data.source.StatisticsRepository;
import com.luigi573.mira.di.ActivityScoped;
import com.luigi573.mira.util.TimeUtils;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

@ActivityScoped
public class StatisticsPresenter implements StatisticsContract.Presenter {
    private StatisticsContract.View mView;
    private CompositeDisposable mCompositeDisposable;
    private StatisticsRepository mRepository;

    @Inject
    public StatisticsPresenter(StatisticsRepository repository) {
        mRepository = repository;
        mCompositeDisposable = new CompositeDisposable();
    }
    @Override
    public void refresh() {
        Log.v("DDD","refresh");
        mView.setLoadingIndicator(true);
        Disposable disposable = mRepository.getStatistics().observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::showStatistics
                        , throwable -> {mView.setLoadingIndicator(false); mView.setRequestStatus(false); });
        mCompositeDisposable.add(disposable);
    }

    private void showStatistics(Statistics statistics) {
        Log.v("DDD", statistics.toString());
        Log.v("DDD","showStatistics");
        mView.setLoadingIndicator(false);
        mView.setRequestStatus(true);
        mView.showConfirmed(statistics.getConfirmedCount());
        mView.showSuspected(statistics.getSuspectedCount());
        mView.showCured(statistics.getCuredCount());
        mView.showDead(statistics.getDeadCount());
        mView.showModifyTime(TimeUtils.timeStamp2String(statistics.getModifyTime()
                , "yyyy.MM.dd HH:mm"));
        mView.setImage(statistics.getImgUrl());
    }


    @Override
    public void takeView(StatisticsContract.View view) {
        mView = view;
        refresh();
    }

    @Override
    public void dropView() {
        mView = null;
        mCompositeDisposable.clear();
    }
}
