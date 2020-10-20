package app.com.lawyerly.lawyers;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.com.lawyerly.BaseFragment;
import app.com.lawyerly.R;
import app.com.lawyerly.databinding.FragmentFeaturedListBinding;
import app.com.lawyerly.home.view.fragments.LawyerFragment;
import app.com.lawyerly.intent.LawyerDetailIntent;
import app.com.lawyerly.lawyers.adapter.FeaturedListAdapter;
import app.com.lawyerly.lawyers.presenter.FeaturedListContract;
import app.com.lawyerly.lawyers.presenter.FeaturedListPresenter;
import app.com.lawyerly.model.LawyerList;

public class FeaturedListFragment extends BaseFragment implements FeaturedListContract.View,FeaturedListAdapter.OnLawyerClickListener{
    private FragmentFeaturedListBinding mBinding;
    private FeaturedListContract.Presenter mPresenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        // Inflate the layout for FeaturedList
        mBinding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_featured_list, container, false);
        return mBinding.getRoot();
    }

       //Initialize and start the presenter
    @Override
    public void onResume() {
        super.onResume();
        mPresenter=new FeaturedListPresenter(this);
        mPresenter.start();

    }


    /*This method will set the data to adapter to inflate the lawyer list*/
    private void setUpRecyclerView(ArrayList<LawyerList> lawyerListData){
        FeaturedListAdapter mFeaturedListAdapter;
        mBinding.lawyersFeaturedList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mFeaturedListAdapter = new FeaturedListAdapter(lawyerListData,getActivity());
        mBinding.lawyersFeaturedList.setAdapter(mFeaturedListAdapter);
        mFeaturedListAdapter.setListener(this);
        if(getParentFragment()!=null && getParentFragment() instanceof LawyerFragment){
            ((LawyerFragment)getParentFragment()).myUpdatePageTitle(0,lawyerListData.size());
        }
    }

    @Override
    public void setPresenter(FeaturedListContract.Presenter presenter) {
        mPresenter=presenter;
    }

    /*Receive the callback from presenter after data creation*/
    @Override
    public void inflateData(ArrayList<LawyerList> lawyerList) {
        setUpRecyclerView(lawyerList);
    }

    @Override
    public void onLawyerItemClicked(LawyerList lawyer) {
        startActivity(new LawyerDetailIntent(getActivity()));
    }
}
