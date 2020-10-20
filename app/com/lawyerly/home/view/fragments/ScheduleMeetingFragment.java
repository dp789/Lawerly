package app.com.lawyerly.home.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.com.lawyerly.BaseFragment;
import app.com.lawyerly.R;

public class ScheduleMeetingFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        // Inflate the layout for FavoriteLawyersFragment
        return inflater.inflate(R.layout.fragment_schedule_meeting, container, false);
    }
}
