package app.com.lawyerly.lawyers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.com.lawyerly.BaseFragment;
import app.com.lawyerly.R;


public class AllLawyersListFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        // Inflate the layout for AllLawyersList
        return inflater.inflate(R.layout.fragment_all_lawyer_list, container, false);
    }

}
