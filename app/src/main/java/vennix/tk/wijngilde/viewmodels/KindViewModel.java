package vennix.tk.wijngilde.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.List;

import vennix.tk.wijngilde.entities.Kind;
import vennix.tk.wijngilde.repositories.KindRepository;

public class KindViewModel extends AndroidViewModel {
    private final LiveData<List<Kind>> kindList;
    private KindRepository kindRepo;

    public KindViewModel(@NonNull Application application) {
        super(application);
        kindRepo = new KindRepository(this.getApplication());
        kindList = kindRepo.getAllKinds();
    }

    public LiveData<List<Kind>> getKindList() {
        return kindList;
    }

    public void deleteItem(Kind kind) {
        new KindViewModel.deleteAsyncTask(kindRepo).execute(kind);
    }

    private static class deleteAsyncTask extends AsyncTask<Kind, Void, Void> {

        private KindRepository kindRepo;

        deleteAsyncTask(KindRepository kindRepo) {
            kindRepo = kindRepo;
        }

        @Override
        protected Void doInBackground(final Kind ... params) {
            kindRepo.getmKindDao().delete(params[0].getId());
            return null;
        }

    }
}