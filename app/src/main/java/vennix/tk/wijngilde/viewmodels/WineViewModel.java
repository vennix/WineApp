package vennix.tk.wijngilde.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.List;

import vennix.tk.wijngilde.entities.Wine;
import vennix.tk.wijngilde.repositories.WineRepository;

public class WineViewModel extends AndroidViewModel {

    private final LiveData<List<Wine>> wineList;
    private WineRepository wineRepo;

    public WineViewModel(@NonNull Application application) {
        super(application);
        wineRepo = new WineRepository(this.getApplication());
        wineList = wineRepo.getAllWines();
    }

    public LiveData<List<Wine>> getWineList() {
        return wineList;
    }

    public void deleteItem(Wine wine) {
        new deleteAsyncTask(wineRepo).execute(wine);
    }

    private static class deleteAsyncTask extends AsyncTask<Wine, Void, Void> {

        private WineRepository wineRepo;

        deleteAsyncTask(WineRepository wineRepo) {
            wineRepo = wineRepo;
        }

        @Override
        protected Void doInBackground(final Wine ... params) {
            wineRepo.getmWineDao().delete(params[0].getId());
            return null;
        }

    }
}
