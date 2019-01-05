package vennix.tk.wijngilde.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "kind")
public class Kind {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private Integer id;
    @ColumnInfo(name = "name")
    private String name;

    public Kind(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Starting data to populate the db with
    public static List<Kind> getStartingData() {
        List<Kind> kinds = new ArrayList<>();
        kinds.add(new Kind("Rood"));
        kinds.add(new Kind("Wit"));
        kinds.add(new Kind("Rosé"));
        kinds.add(new Kind("Champagne"));
        return kinds;
    }



























}
