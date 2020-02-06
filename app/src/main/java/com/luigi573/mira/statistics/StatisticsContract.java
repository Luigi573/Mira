package com.luigi573.mira.statistics;

import com.luigi573.mira.base.BasePresenter;
import com.luigi573.mira.base.BaseView;

public interface StatisticsContract {
    interface Presenter extends BasePresenter<View> {
        void refresh();

    }

    interface View extends BaseView<Presenter> {

        void showModifyTime(String timeString);

        void showConfirmed(int count);

        void showSuspected(int count);

        void showCured(int count);

        void showDead(int count);

        void setLoadingIndicator(boolean isLoading);

        void setRequestStatus(boolean isSuccess);

        void setImage(String imageUrl);
    }
}
