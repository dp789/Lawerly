package app.com.lawyerly.home.view.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.com.lawyerly.BaseFragment;
import app.com.lawyerly.R;
import app.com.lawyerly.adapter.TabPagerAdapter;
import app.com.lawyerly.databinding.FragmentLawyersListBinding;
import app.com.lawyerly.lawyers.AllLawyersListFragment;
import app.com.lawyerly.lawyers.FavoriteLawyerListFragment;
import app.com.lawyerly.lawyers.FeaturedListFragment;

public class LawyerFragment extends BaseFragment{
private FragmentLawyersListBinding mBinding;
    private String tabTitles[] = new String[]{"FEATURED", " ALL", "FAVS"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        // Inflate the layout for LawyersList
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_lawyers_list, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpViewPagerAdapter();
        mBinding.childTabLayout.setupWithViewPager(mBinding.lawyerViewpager);

    }

    /*This method will add the fragment to the adapter and then the adapter to viewpager*/

    private void setUpViewPagerAdapter(){
        ChildViewPager adapter = new ChildViewPager(getChildFragmentManager());
        adapter.addFragment(new FeaturedListFragment());
        adapter.addFragment(new AllLawyersListFragment());
        adapter.addFragment(new FavoriteLawyerListFragment());
        mBinding.lawyerViewpager.setAdapter(adapter);
    }

    /*This method will add the list count with tab title*/
    public void myUpdatePageTitle(int pagePosition,int numItems) {
        TabLayout.Tab tab = mBinding.childTabLayout.getTabAt(pagePosition);
        if (tab != null) {
            tab.setText(tabTitles[0]+"("+numItems+")");
        }
    }


    class ChildViewPager extends TabPagerAdapter {
        public ChildViewPager(FragmentManager manager) {
            super(manager);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }
}
