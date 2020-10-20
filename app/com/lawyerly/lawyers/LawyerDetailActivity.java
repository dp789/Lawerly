package app.com.lawyerly.lawyers;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import app.com.lawyerly.BaseActivity;
import app.com.lawyerly.R;
import app.com.lawyerly.databinding.ActivityLawyerDetailBinding;
import app.com.lawyerly.util.ImageHelper;

public class LawyerDetailActivity extends BaseActivity {
    private ActivityLawyerDetailBinding mBinding;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_lawyer_detail);
        setUpToolBar( mBinding.toolbarView.toolbar);
        //create the bitmap for lawyer profile imageview
        Bitmap profileImageBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lawyerly);
        profileImageBitmap = ImageHelper.getRoundCornerBitmap(profileImageBitmap, (int) getResources().getDimension(R.dimen.dimen_7));
        mBinding.ivProfilePic.setImageBitmap(profileImageBitmap);

        startAnimationOnButton();

    }

    @Override
    public void setUpToolBar(Toolbar toolBar) {
        super.setUpToolBar(toolBar);
        getSupportActionBar().setTitle(getString(R.string.lawyer_detail_header));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);
        getSupportActionBar().setElevation(getResources().getDimension(R.dimen.dimen_5));
    }
    /*This method will start the animation on button*/
    private void startAnimationOnButton(){
        animationDrawable = (AnimationDrawable) mBinding.scheduleMeetingBtn.getBackground();
        animationDrawable.setVisible(true, true);
        //setting enter fade animation duration to 5 seconds
        animationDrawable.setEnterFadeDuration(2000);
        // setting exit fade animation duration to 2 seconds
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();
    }
/*Stop the animation if activity is visible and animation is not running*/
    @Override
    public void onResume() {
        super.onResume();
        if (animationDrawable != null && !animationDrawable.isRunning()) {
            // start the animation
            animationDrawable.start();
        }

    }
/*Stop the animation if activity is no longer visible*/
    @Override
    public void onPause() {
        super.onPause();
        if (animationDrawable != null && animationDrawable.isRunning()) {
            // stop the animation
            animationDrawable.stop();
        }
    }
}
