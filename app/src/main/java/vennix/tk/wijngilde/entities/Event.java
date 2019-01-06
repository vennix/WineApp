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
    @ColumnInfo(name = "description")
    private String description;

    public Event(String name, int places, Date date, String description) {
        this.name = name;
        this.places = places;
        this.date = date;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", places=" + places +
                ", date=" + date +
                ", description='" + description + '\'' +
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
            events.add(new Event("Wijnen uit Afrika",
                    75, format.parse(sDate1), "We overlopen de meest gekende wijnen uit Afrika, alsook de betere opkomende wijnhuizen. Er zal een assortiment van 15 wijnen gepresenteerd worden waarvan gedegusteerd kan worden. Er is ook de mogelijkheid om enkele wijnen te bestellen."));
            events.add(new Event("Wijn maken deel 1",
                    75, format.parse(sDate2), "De avond zal starten met een voorstelling over de basis benodigdheden om wijn te maken. We overlopen de verschillende stappen die genomen worden in de wijngaard omdat nu eenmaal dit de basis is om een goede wijn te bouwen. "));
            events.add(new Event("Wijnen uit Frankrijk deel 1",
                    75, format.parse(sDate3), "Een voorstelling van de betere witte wijnen uit Frankrijk en hun streken. Na de voorstelling is er een degustatie gepland waar een 20 tal wijnen kunnen geproeft worden. Deel 2 zal over de champange gaan."));
        } catch (ParseException ex) {
            Log.e(ex.getMessage(), "index");
        }
        return events;
    }
}
