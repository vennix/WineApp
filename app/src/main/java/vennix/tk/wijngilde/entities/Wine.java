package vennix.tk.wijngilde.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;


@Entity(tableName = "wine",
        foreignKeys = @ForeignKey(entity = Kind.class,
                parentColumns = "id",
                childColumns = "kind_id"),
        indices = {@Index("kind_id")})
public class Wine {
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = "id")
    private Integer id;
    @ColumnInfo(name = "kind_id")
    private Integer kindId;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "alcohol_percentage")
    private Double alcoholPercentage;

    public Wine(@NonNull Integer kindId, @NonNull String name,
                @NonNull String description, @NonNull Double alcoholPercentage) {
        this.kindId = kindId;
        this.name = name;
        this.description = description;
        this.alcoholPercentage = alcoholPercentage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKindId() {
        return kindId;
    }

    public void setKindId(Integer kindId) {
        this.kindId = kindId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(Double alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }

    // Starting data to populate the db with
    public static List<Wine> getStartingData() {
        List<Wine> wines = new ArrayList<>();
        wines.add(new Wine(new Kind("rood").getId(), "Pomerol",
                "Lekkere rode wijn", 12.56));
        wines.add(new Wine(new Kind("wit").getId(),  "Anges",
                "Lekkere witte wijn", 12.56));
        return wines;
    }

    @Override
    public String toString() {
        return name + " - " + kindId + " - " + alcoholPercentage + "%Alc";
    }
}
