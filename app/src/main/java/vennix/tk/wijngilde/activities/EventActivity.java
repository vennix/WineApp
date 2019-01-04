package vennix.tk.wijngilde.activities;

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
import vennix.tk.wijngilde.adapters.EventViewAdapter;
import vennix.tk.wijngilde.entities.Event;
import vennix.tk.wijngilde.viewmodels.EventViewModel;

public class EventActivity extends AppCompatActivity {

    private EventViewModel eventViewModel;
    private EventViewAdapter eventViewAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        recyclerView = findViewById(R.id.event_list);
        eventViewAdapter = new EventViewAdapter(new ArrayList<Event>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(eventViewAdapter);

        eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);

        eventViewModel.getEventList().observe(this, new Observer<List<Event>>() {
            @Override
            public void onChanged(@Nullable List<Event> events) {
                eventViewAdapter.addItems(events);
            }
        });
    }
}
