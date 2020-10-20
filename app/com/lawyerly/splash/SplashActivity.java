package app.com.lawyerly.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import app.com.lawyerly.R;
import app.com.lawyerly.intent.HomeIntent;
import app.com.lawyerly.splash.presenter.SplashContract;
import app.com.lawyerly.splash.presenter.SplashPresenter;


public class SplashActivity extends AppCompatActivity implements SplashContract.View {
    private SplashContract.Presenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter = new SplashPresenter(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(SplashContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void startHomeScreen() {
       startActivity(new HomeIntent(this));
       finish();
    }
}
