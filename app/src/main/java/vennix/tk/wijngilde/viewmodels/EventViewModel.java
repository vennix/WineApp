package vennix.tk.wijngilde.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.List;

import vennix.tk.wijngilde.entities.Event;
import vennix.tk.wijngilde.repositories.EventRepository;

public class EventViewModel extends AndroidViewModel {
    private final LiveData<List<Event>> eventList;
    private EventRepository eventRepo;

    public EventViewModel(@NonNull Application application) {
        super(application);
        eventRepo = new EventRepository(this.getApplication());
        eventList = eventRepo.getAllEvents();
    }

    public LiveData<List<Event>> getEventList() {
        return eventList;
    }

    public void deleteItem(Event event) {
        new EventViewModel.deleteAsyncTask(eventRepo).execute(event);
    }

    private static class deleteAsyncTask extends AsyncTask<Event, Void, Void> {

        private EventRepository eventRepo;

        deleteAsyncTask(EventRepository eventRepo) {
            eventRepo = eventRepo;
        }

        @Override
        protected Void doInBackground(final Event ... params) {
            eventRepo.getmEventDao().delete(params[0].getId());
            return null;
        }

    }
}
