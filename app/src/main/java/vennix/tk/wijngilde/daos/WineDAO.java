package vennix.tk.wijngilde.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;

import vennix.tk.wijngilde.entities.Wine;

@Dao
public interface WineDAO {
    @Insert
    void insert(Wine... wine);
    // returns ID of inserted row
    @Insert
    long insert(Wine wine);
    @Insert
    void insertList(List<Wine> wine);
    // Default SQLite behavior on insert or update = ABORT
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void upsert(Wine... wine);

    @Query("SELECT * FROM wine")
    LiveData<List<Wine>> getAllWines();
    //List<Wine> getAllWines();

    @Query("DELETE FROM wine WHERE wine_id = :id")
    void delete(int id);

    // if data needs to be synchronized with UI
    @Query("SELECT * FROM wine ORDER BY name ASC")
    LiveData<List<Wine>> getAllWinesByName();
}
