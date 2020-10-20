package app.com.lawyerly.home.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.com.lawyerly.BaseFragment;
import app.com.lawyerly.R;

public class SettingFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        // Inflate the layout for SettingFragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }
}
