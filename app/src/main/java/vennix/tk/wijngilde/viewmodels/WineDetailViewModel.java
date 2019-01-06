package vennix.tk.wijngilde.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import vennix.tk.wijngilde.entities.Wine;
import vennix.tk.wijngilde.repositories.WineRepository;

public class WineDetailViewModel extends AndroidViewModel {

    //private Wine wine;
    //private WineRepository wineRepo;
    private String test = "test";

    public WineDetailViewModel(@NonNull Application application) {
        super(application);
        //wineRepo = new WineRepository(this.getApplication());
        //this.wine = wineRepo.getWineById(wineId);
    }

    public String getTest() {
        return test;
    }
}
