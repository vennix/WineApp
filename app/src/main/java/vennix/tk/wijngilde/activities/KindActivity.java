package vennix.tk.wijngilde.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import vennix.tk.wijngilde.R;
import vennix.tk.wijngilde.adapters.KindViewAdapter;
import vennix.tk.wijngilde.entities.Kind;
import vennix.tk.wijngilde.viewmodels.KindViewModel;

public class KindActivity extends AppCompatActivity implements View.OnClickListener{

    private KindViewModel kindViewModel;
    private KindViewAdapter kindViewAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kinds);

        recyclerView = findViewById(R.id.kind_list);
        kindViewAdapter = new KindViewAdapter(new ArrayList<Kind>(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(kindViewAdapter);

        kindViewModel = ViewModelProviders.of(this).get(KindViewModel.class);

        kindViewModel.getKindList().observe(this, new Observer<List<Kind>>() {
            @Override
            public void onChanged(@Nullable List<Kind> kinds) {
                kindViewAdapter.addItems(kinds);
            }
        });
    }

    @Override
    public void onClick(View v) {
        Kind kind = (Kind)v.getTag();
        Intent intent = new Intent(this, WineActivity.class);
        intent.putExtra("kind_id", kind.getId());
        startActivity(intent);
    }
}
