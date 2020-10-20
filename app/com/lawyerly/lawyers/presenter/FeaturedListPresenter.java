package app.com.lawyerly.lawyers.presenter;

import java.util.ArrayList;

import app.com.lawyerly.model.LawyerList;

/**
 * Created by Psingh on 2/21/2018.
 */

public class FeaturedListPresenter implements FeaturedListContract.Presenter{
private FeaturedListContract.View mView;


public FeaturedListPresenter( FeaturedListContract.View mView) {
        this.mView = mView;
        this.mView.setPresenter(this);
        }

    @Override
    public void start() {
        //create the dummy data for lawyers
        ArrayList<LawyerList> mLawyerListDataList=new ArrayList<>();
        mLawyerListDataList.add(new LawyerList(4.8,60.90));
        mLawyerListDataList.add(new LawyerList(4.5,55.50));
        mLawyerListDataList.add(new LawyerList(4.1,90.00));
        mLawyerListDataList.add(new LawyerList(4.6,65.50));
        mLawyerListDataList.add(new LawyerList(4.5,100.00));
        mView.inflateData(mLawyerListDataList);
    }
}
