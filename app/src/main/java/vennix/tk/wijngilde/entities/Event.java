package vennix.tk.wijngilde.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.util.Log;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "event")
// Implementing Serializable enables us to pass an object of this class with Intent.putExtra()
public class Event implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "event_id")
    private Integer id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "places")
    private int places;
    @ColumnInfo(name = "date")
    private Date date;

    public Event(String name, int places, Date date) {
        this.name = name;
        this.places = places;
        this.date = date;
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

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", places=" + places +
                ", date=" + date +
                '}';
    }

    // Starting data to populate the db with
    public static List<Event> getStartingData() {
        String sDate1 = "05-10-2018";
        String sDate2 = "10-02-2019";
        String sDate3 = "02-04-2019";
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        List<Event> events = new ArrayList<>();
        try{
            events.add(new Event("Wijnen uit afrika",
                    75, format.parse(sDate1)));
            events.add(new Event("Wijn maken deel 1",
                    75, format.parse(sDate2)));
            events.add(new Event("Wijnen uit afrika",
                    75, format.parse(sDate3)));
        } catch (ParseException ex) {
            Log.e(ex.getMessage(), "index");
        }
        return events;
    }
}
