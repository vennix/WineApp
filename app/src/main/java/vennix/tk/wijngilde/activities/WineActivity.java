package vennix.tk.wijngilde.activities;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
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
import vennix.tk.wijngilde.viewmodels.ViewModelFactory;
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

        Bundle extras = getIntent().getExtras();
        int kindId = 0;
        if (extras != null) {
            kindId = (int) extras.get("kind_id");
        }

        wineViewModel = ViewModelProviders.of(this, new ViewModelFactory(getApplication(), kindId)).get(WineViewModel.class);

        wineViewModel.getWineList().observe(this, new Observer<List<Wine>>() {
            @Override
            public void onChanged(@Nullable List<Wine> wines) {
                wineViewAdapter.addItems(wines);
            }
        });

        // handle onClick on listItem
        wineViewAdapter.setOnItemClickListener(new WineViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(Wine wine) {
                Intent intent = new Intent(getBaseContext(), EventDetailActivity.class);
                intent.putExtra("wine", wine);
                startActivity(intent);
            }
        });
    }

}
