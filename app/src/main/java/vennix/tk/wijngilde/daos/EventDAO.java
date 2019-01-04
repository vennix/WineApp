package vennix.tk.wijngilde.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import vennix.tk.wijngilde.entities.Event;

@Dao
public interface EventDAO {
    @Insert
    void insert(Event... event);
    // returns ID of inserted row
    @Insert
    long insert(Event event);
    @Insert
    void insertList(List<Event> event);
    // Default SQLite behavior on insert or update = ABORT
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void upsert(Event... event);

    @Query("SELECT * FROM event")
    LiveData<List<Event>> getAllEvents();

    @Query("DELETE FROM event WHERE event_id = :id")
    void delete(int id);

    // if data needs to be synchronized with UI
    @Query("SELECT * FROM event ORDER BY name ASC")
    LiveData<List<Event>> getAllEventsOderedByName();
}
