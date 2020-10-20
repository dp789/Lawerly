package app.com.lawyerly.intent;

import android.content.Context;
import android.content.Intent;

import app.com.lawyerly.home.view.HomeActivity;

public class HomeIntent extends Intent {

    public HomeIntent(final Context context) {
        super(context, HomeActivity.class);
    }

}
