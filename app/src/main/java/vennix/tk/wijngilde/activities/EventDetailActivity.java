package vennix.tk.wijngilde.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import vennix.tk.wijngilde.R;
import vennix.tk.wijngilde.entities.Event;

public class EventDetailActivity extends AppCompatActivity {
    private TextView nameTextView;
    private TextView dateTextView;
    private TextView placesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        nameTextView = findViewById(R.id.nameTextView);
        dateTextView = findViewById(R.id.dateTextView);
        placesTextView = findViewById(R.id.placesTextView);

        Intent intent = getIntent();
        if (intent.hasExtra("event")) {
            Event event = (Event)intent.getSerializableExtra("event");
            nameTextView.setText(event.getName());
            dateTextView.setText(new SimpleDateFormat("dd-MM-yyyy").format(event.getDate()));
            placesTextView.setText(Integer.toString(event.getPlaces()));
        }

    }
}
