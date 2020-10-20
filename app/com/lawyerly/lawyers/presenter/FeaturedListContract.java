package app.com.lawyerly.lawyers.presenter;

import java.util.ArrayList;

import app.com.lawyerly.model.LawyerList;
import app.com.lawyerly.mvp.BasePresenter;
import app.com.lawyerly.mvp.BaseView;

public interface FeaturedListContract {
    interface View extends BaseView<FeaturedListContract.Presenter> {
        void inflateData(ArrayList<LawyerList> lawyerList);

    }

    interface Presenter extends BasePresenter {

    }
}
