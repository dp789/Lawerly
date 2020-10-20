package app.com.lawyerly.home.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.Menu;

import app.com.lawyerly.BaseActivity;
import app.com.lawyerly.R;
import app.com.lawyerly.adapter.TabPagerAdapter;
import app.com.lawyerly.databinding.ActivityHomeBinding;
import app.com.lawyerly.home.view.fragments.FavoriteFragment;
import app.com.lawyerly.home.view.fragments.LawyerFragment;
import app.com.lawyerly.home.view.fragments.ScheduleMeetingFragment;
import app.com.lawyerly.home.view.fragments.SettingFragment;
import app.com.lawyerly.home.view.fragments.ViewAppointmentFragment;

public class HomeActivity extends BaseActivity{
private ActivityHomeBinding mBinding;
    private int[] tabIcons = {
            R.drawable.list_icon,
            R.drawable.calendar,
            R.drawable.favorite,
            R.drawable.view_appointment,
            R.drawable.setting
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        setUpViewPager();
        setUpToolBar(mBinding.toolbarView.toolbar);
        //setSupportActionBar(mBinding.toolbarView.toolbar);
        mBinding.tabLayout.setupWithViewPager(mBinding.viewpager);
        setUpIconOnTab();
    }


    //show the option menu on toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    //Add the Icons on tab
    private void setUpIconOnTab() {
        //Add tabs icon with setIcon()
        for (int i = 0; i < mBinding.tabLayout.getTabCount(); i++) {
            mBinding.tabLayout.getTabAt(i).setIcon(tabIcons[i]);
        }
    }



    private void setUpViewPager(){
        //Add fragments
        TabPagerAdapter adapter = new TabPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new LawyerFragment());
        adapter.addFragment(new ScheduleMeetingFragment());
        adapter.addFragment(new FavoriteFragment());
        adapter.addFragment(new ViewAppointmentFragment());
        adapter.addFragment(new SettingFragment());

      //Set up the adapter to viewpager
        mBinding.viewpager.setAdapter(adapter);
    }


}
