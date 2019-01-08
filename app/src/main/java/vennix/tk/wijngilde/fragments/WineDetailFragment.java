package vennix.tk.wijngilde.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import vennix.tk.wijngilde.R;
import vennix.tk.wijngilde.repositories.WineRepository;

public class WineDetailFragment extends Fragment {

    private WineRepository wineRepo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wine_detail,
                container, false);
        return view;
    }

    public void setText(String textToShow) {
        TextView view = getView().findViewById(R.id.detailsText);
        view.setText(textToShow);
    }

}
