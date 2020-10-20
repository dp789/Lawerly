package app.com.lawyerly.intent;

import android.content.Context;
import android.content.Intent;

import app.com.lawyerly.lawyers.LawyerDetailActivity;

public class LawyerDetailIntent extends Intent{

    public LawyerDetailIntent(final Context context) {
        super(context,LawyerDetailActivity.class);
    }
}
