package app.com.lawyerly.splash.presenter;

import android.os.Handler;


public class SplashPresenter implements SplashContract.Presenter{
    private SplashContract.View mView;


    public SplashPresenter( SplashContract.View mView) {
        this.mView = mView;
        this.mView.setPresenter(this);
    }


    @Override
    public void start() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.startHomeScreen();
            }
        }, 2000);

    }
}
