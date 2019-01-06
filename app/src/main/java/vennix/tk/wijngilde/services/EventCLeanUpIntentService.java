package vennix.tk.wijngilde.services;

import android.app.IntentService;
import android.arch.lifecycle.LiveData;
import android.content.Intent;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import vennix.tk.wijngilde.daos.EventDAO;
import vennix.tk.wijngilde.entities.Event;
import vennix.tk.wijngilde.repositories.EventRepository;

public class EventCLeanUpIntentService extends IntentService {

    public final static String EVENT_CLEAN_UP = "event_clean_up";

    public EventCLeanUpIntentService() {
        super("EventCLeanUpIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            try{
                RemovePastEventsTask task = new RemovePastEventsTask();
                task.doInBackground();
                Thread.sleep(5000);
            } catch (Exception ex){

            }
            sendCleanUpInfoToClient();
        }
    }

    private void sendCleanUpInfoToClient(){
        Intent intent = new Intent(EVENT_CLEAN_UP);
        sendBroadcast(intent);
    }

    private class RemovePastEventsTask extends AsyncTask<String, Integer, Long> {

        private EventRepository eventRepo = new EventRepository(getApplication());

        @Override
        protected Long doInBackground(String... strings) {
            Date currentDate = Calendar.getInstance().getTime();
            eventRepo.deletePastEvents(currentDate);
            Log.e("index", currentDate.toString());
            return null;
        }
    }

}
