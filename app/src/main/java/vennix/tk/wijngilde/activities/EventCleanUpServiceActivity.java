package vennix.tk.wijngilde.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import vennix.tk.wijngilde.R;
import vennix.tk.wijngilde.services.EventCLeanUpIntentService;

public class EventCleanUpServiceActivity extends AppCompatActivity {

    private EventCleanUpReceiver receiver;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_clean_up_service);
        resultTextView = findViewById(R.id.result_text_view);
        registerCleanUpReceiver();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);
    }

    public void startCleanUpService(View view){
        Intent cleanUpIntent =  new Intent();
        cleanUpIntent.setClass(this, EventCLeanUpIntentService.class);
        startService(cleanUpIntent);
    }

    private void registerCleanUpReceiver(){
        receiver = new EventCleanUpReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(EventCLeanUpIntentService.EVENT_CLEAN_UP);
        registerReceiver(receiver, intentFilter);
    }

    private class EventCleanUpReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            resultTextView.setText("All past events are removed");
        }
    }

}
