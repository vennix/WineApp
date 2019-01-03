package vennix.tk.wijngilde.repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import vennix.tk.wijngilde.daos.WineDAO;
import vennix.tk.wijngilde.database.WijnGildeDatabase;
import vennix.tk.wijngilde.entities.Wine;

public class WineRepository {
    private WineDAO mWineDao;

    private WijnGildeDatabase myDb;

    public WineRepository(Application application) {
        myDb = WijnGildeDatabase.getDatabase(application);
        mWineDao = myDb.wineDao();
    }

    /*
    public void getAllWines(@NonNull LoadDataCallback<Wine> activityCallback) {
        new GetWinesAsyncTask(mWineDao, activityCallback).execute();
    }
    */

    public WineDAO getmWineDao() {
        return mWineDao;
    }

    public LiveData<List<Wine>> getAllWines(){
        LiveData<List<Wine>> wines = mWineDao.getAllWines();
        return wines;
    }

    private static class GetWinesAsyncTask extends AsyncTask<Void, Void, LiveData<List<Wine>>> {
        private WineDAO mWineDao;

        GetWinesAsyncTask(WineDAO wineDao) {
            mWineDao = wineDao;
        }

        @Override
        protected LiveData<List<Wine>> doInBackground(Void... voids) {
            return mWineDao.getAllWines();
        }

        @Override
        protected void onPostExecute(LiveData<List<Wine>> wines) {
            super.onPostExecute(wines);
        }
    }
}
