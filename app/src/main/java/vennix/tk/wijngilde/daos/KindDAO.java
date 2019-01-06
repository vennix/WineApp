package vennix.tk.wijngilde.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;
import vennix.tk.wijngilde.entities.Kind;
import vennix.tk.wijngilde.entities.Wine;

@Dao
public interface KindDAO {
    @Insert
    void insert(Kind... kind);
    // returns ID of inserted row
    @Insert
    long insert(Kind kind);
    @Insert
    void insertList(List<Kind> kind);
    // Default SQLite behavior on insert or update = ABORT
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void upsert(Kind... kind);

    @Query("SELECT * FROM kind")
    LiveData<List<Kind>> getAllKinds();

    @Query("DELETE FROM kind WHERE id = :id")
    void delete(int id);

    @Query("SELECT id FROM kind WHERE name = :name")
    int getIdByName(String name);

    // if data needs to be synchronized with UI
    @Query("SELECT * FROM kind ORDER BY name ASC")
    LiveData<List<Wine>> getAllArtistsKindsByName();
}
