package vennix.tk.wijngilde.database;

import java.util.List;

public interface LoadDataCallback<T> {
    void onDataLoaded(List<T> data);
}
