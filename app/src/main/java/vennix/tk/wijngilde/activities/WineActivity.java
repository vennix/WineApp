package vennix.tk.wijngilde.activities;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vennix.tk.wijngilde.R;
import vennix.tk.wijngilde.adapters.WineViewAdapter;
import vennix.tk.wijngilde.entities.Wine;
import vennix.tk.wijngilde.viewmodels.WineViewModel;

public class WineActivity extends AppCompatActivity {

    private WineViewModel wineViewModel;
    private WineViewAdapter wineViewAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wines);

        recyclerView = findViewById(R.id.wine_list);
        wineViewAdapter = new WineViewAdapter(new ArrayList<Wine>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(wineViewAdapter);

        wineViewModel = ViewModelProviders.of(this).get(WineViewModel.class);

        wineViewModel.getWineList().observe(this, new Observer<List<Wine>>() {
            @Override
            public void onChanged(@Nullable List<Wine> wines) {
                wineViewAdapter.addItems(wines);
            }
        });

    }

}
