package vennix.tk.wijngilde.repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.Date;
import java.util.List;

import vennix.tk.wijngilde.daos.EventDAO;
import vennix.tk.wijngilde.database.WijnGildeDatabase;
import vennix.tk.wijngilde.entities.Event;

public class EventRepository {
    private EventDAO mEventDao;

    private WijnGildeDatabase myDb;

    public EventRepository(Application application) {
        myDb = WijnGildeDatabase.getDatabase(application);
        mEventDao = myDb.eventDao();
    }

    public EventDAO getmEventDao() {
        return mEventDao;
    }

    public LiveData<List<Event>> getAllEvents(){
        LiveData<List<Event>> events = mEventDao.getAllEvents();
        return events;
    }

    public void deletePastEvents(Date date){
        mEventDao.deletePastEvents(date);
    }

    private static class GetEventsAsyncTask extends AsyncTask<Void, Void, LiveData<List<Event>>> {
        private EventDAO mEventDao;

        GetEventsAsyncTask(EventDAO eventDAO) {
            mEventDao = eventDAO;
        }

        @Override
        protected LiveData<List<Event>> doInBackground(Void... voids) {
            return mEventDao.getAllEvents();
        }

        @Override
        protected void onPostExecute(LiveData<List<Event>> events) {
            super.onPostExecute(events);
        }
    }
}
