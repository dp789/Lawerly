package app.com.lawyerly.splash.presenter;

import app.com.lawyerly.mvp.BasePresenter;
import app.com.lawyerly.mvp.BaseView;

public interface SplashContract {

    interface View extends BaseView<Presenter> {
      void startHomeScreen();

    }

    interface Presenter extends BasePresenter {

    }
}
