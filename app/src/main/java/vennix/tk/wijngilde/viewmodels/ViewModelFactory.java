package vennix.tk.wijngilde.viewmodels;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private Application application;
    private Object[] params;

    public ViewModelFactory(Application application, Object... params) {
        this.application = application;
        this.params = params;
    }

    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == WineViewModel.class) {
            return(T) new WineViewModel(application, (int) params[0]);
        } else {
            return super.create(modelClass);
        }
    }
}