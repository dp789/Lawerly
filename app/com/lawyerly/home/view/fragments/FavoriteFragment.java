package app.com.lawyerly.home.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.com.lawyerly.BaseFragment;
import app.com.lawyerly.R;

/**
 * Created by Psingh on 2/19/2018.
 */

public class FavoriteFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        // Inflate the layout for FavoriteFragment
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }
}
