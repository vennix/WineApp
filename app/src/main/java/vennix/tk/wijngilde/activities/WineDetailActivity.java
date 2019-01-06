package vennix.tk.wijngilde.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import vennix.tk.wijngilde.R;
import vennix.tk.wijngilde.viewmodels.WineDetailViewModel;

public class WineDetailActivity extends Fragment {

    private WineDetailViewModel wineViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_wine_detail, container, false);
        wineViewModel = ViewModelProviders.of(this).get(WineDetailViewModel.class);
        FragmentManager manager = getFragmentManager();

        return view;
    }

}
