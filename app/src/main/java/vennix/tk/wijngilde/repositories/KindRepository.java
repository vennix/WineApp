package vennix.tk.wijngilde.repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import vennix.tk.wijngilde.daos.KindDAO;
import vennix.tk.wijngilde.database.WijnGildeDatabase;
import vennix.tk.wijngilde.entities.Kind;

public class KindRepository {
    private KindDAO mKindDao;

    private WijnGildeDatabase myDb;

    public KindRepository(Application application) {
        myDb = WijnGildeDatabase.getDatabase(application);
        mKindDao = myDb.kindDao();
    }

    public KindDAO getmKindDao() {
        return mKindDao;
    }

    public LiveData<List<Kind>> getAllKinds() {
        LiveData<List<Kind>> kinds = mKindDao.getAllKinds();
        return kinds;
    }

    private static class GetKindsAsyncTask extends AsyncTask<Void, Void, LiveData<List<Kind>>> {
        private KindDAO mKindDao;

        GetKindsAsyncTask(KindDAO kindDao) {
            mKindDao = kindDao;
        }

        @Override
        protected LiveData<List<Kind>> doInBackground(Void... voids) {
            return mKindDao.getAllKinds();
        }

        @Override
        protected void onPostExecute(LiveData<List<Kind>> kinds) {
            super.onPostExecute(kinds);
        }
    }
}
