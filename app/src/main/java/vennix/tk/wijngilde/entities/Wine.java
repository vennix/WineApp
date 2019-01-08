package vennix.tk.wijngilde.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "wine",
        foreignKeys = @ForeignKey(entity = Kind.class,
                parentColumns = "id",
                childColumns = "kind_id"),
        indices = {@Index("kind_id")})
public class Wine implements Serializable {
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = "id")
    private Integer id;
    @ColumnInfo(name = "kind_id")
    private Integer kindId;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "year")
    private String year;
    @ColumnInfo(name = "house")
    private String house;
    @ColumnInfo(name = "region")
    private String region;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "alcohol_percentage")
    private Double alcoholPercentage;
    @ColumnInfo(name = "grape_variety")
    private String grapeVariety;

    public Wine(@NonNull Integer kindId, @NonNull String name, @NonNull String year, @NonNull String house,
                @NonNull String region, @NonNull String description, @NonNull Double alcoholPercentage, String grapeVariety) {
        this.kindId = kindId;
        this.name = name;
        this.year = year;
        this.house = house;
        this.region = region;
        this.description = description;
        this.alcoholPercentage = alcoholPercentage;
        this.grapeVariety = grapeVariety;
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

    public String getYear() { return year; }

    public void setYear(String year) { this.year = year; }

    public String getHouse() { return house; }

    public void setHouse(String house) { this.house = house; }

    public String getRegion() { return region; }

    public void setRegion(String region) { this.region = region; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGrapeVariety() { return grapeVariety; }

    public void setGrapeVariety(String grapeVariety) { this.grapeVariety = grapeVariety; }

    public Double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(Double alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }

    // Starting data to populate the db with
    public static List<Wine> getStartingData() {
        List<Wine> wines = new ArrayList<>();
        // Red wines
        wines.add(new Wine(1, "Lalande de Pomerol", "2011", "Château Haut-Ballet",
                "Bordeaux", "Na maar liefst 7 jaar rijping zijn alle elementen in deze met goud bekroonde Lalande de Pomerol prachtig versmolten: donker fruit en de typerende tannines van hoge kwaliteit. Krachtig en zacht van smaak!",
                13.73, "Cabernet Franc, Cabernet Sauvignon, Merlot"));
        wines.add(new Wine(1, "Puisseguin Saint-Émilion", "2017", "Château le Chay",
                "Bordeaux", "Zacht en krachtig en met een lange afdronk, het kenmerk van een grote wijn. Op Château Le Chay waren de druiven in 2017 zó rijk geconcentreerd dat de eigenaars besloten om voor het eerst in de geschiedenis van de mooiste trossen een speciale prestige cuvée te maken. Het resultaat mag er zijn!",
                12.56, "100% Merlot"));
        wines.add(new Wine(1, "Bourgogne", "2016", "Domaine Robert Sirugue",
                "Bourgogne", "Helderrode pinot noir uit een mooi, elegant oogstjaar: rijpe kersen en lichte koffienuances in de geur en een ronde, soepele en sappige smaakstructuur.",
                13.50, "100% Pinot noir"));
        // White wines
        wines.add(new Wine(2, "Pouilly-Fuissé", "2017", "Charles Drouin",
                "Chardonnay", "Krachtig en breed van smaak vol rijp Chardonnay fruit. Zó hoort een goede Pouilly-Fuissé te smaken. Gemaakt volgens het 'lutte raisonnée' principe waarbij er zo duurzaam mogelijk gewerkt wordt.",
                10.32, "100% Chardonnay"));
        wines.add(new Wine(2, "Cuvée les Galfins", "2017", "Domaine de Congy",
                "Congy", "Een bekroonde Pouilly-Fumé: snerpend fris, krachtig en met expressies van het terroir. De bodem van gefossiliseerde schaaldieren zorgt ervoor dat de beste fruitaroma's uit de Sauvignon Blanc vrijkomen.",
                8.34, "100% Sauvignon Blanc"));
        wines.add(new Wine(2, "Doré Chablis", "2016", "Domaine du Cèdre",
                "Chablis", "Een karaktervolle Chablis met een krachtige, maar toch frisse en levendige smaak waarin het terroir van kalk en krijt mooi naar voren komt. Komt van de kleine geconcentreerde oogst 2017.",
                9.42, "100% Chardonnay"));
        // Rosé wines
        wines.add(new Wine(3, "Plaisir' Rosé", "2017", "La Pauline",
                "La Varenne", "Een fruitige rosé uit het zonnige zuiden van Frankrijk. Sappig van smaak met bosvruchten, knapperige besjes en frisse tonen. Dankzij de lange zomer zijn de druiven bijzonder rijk en aromatisch van smaak.",
                9.42, "Grenache, Syrah"));
        wines.add(new Wine(3, "Coteaux d'Aix en Provence", "2017", "Opale",
                "Provence", "Geuren van perzik en meloen, met aroma's van de Garrigue (vegetatie van grassen en lage planten) en een mooie mineraliteit. Explosie van fruit (aardbei, framboos) en wilde bloemen met een fijn puntje anijs. Frisse, ronde wijn, met een mooie balans en een royale afdronk.",
                9.42, "Grenache, Syrah, Cinsault"));
        wines.add(new Wine(3, "La Rosée", "2017", "Domaine des Deux Ruisseaux",
                "Languedoc-Roussillon", "Frisse aroma's van rood fruit met florale toetsen. Elegante aanzet van rood zomerfruit. Verfijnd met een mooie harmonie tussen mondvulling en frisheid.",
                12.50, "Grenache (50%), Merlot (50%)"));
        // Champagne wines
        wines.add(new Wine(4, "Champagne Brut", "2017", "Pierre Darcys",
                "Champagne", "Aroma's van tropisch fruit, mango en abrikoos. Krachtige aanzet met naar het midden smaken van noten en brood gesteund door fijne zuren.Evenwichtige en frisse afdronk.",
                12.50, "Chardonnay (33%), Pinot Noir (34%), Pinot Meunier (33%)"));
        wines.add(new Wine(4, "Brut 1er Cru Champagne", "2017", "Pol Guyot",
                "Champagne", "Heeft u wat te vieren? Schenk dan eens deze krachtige Brut 1er Cru Champagne met een rijke smaak van appeltjes, brioche en hazelnoot. Perfect om zo te serveren, maar ook erg lekker bij gerookte vis.",
                12.00, "Chardonnay, Pinot Meunier, Pinot Noir"));
        wines.add(new Wine(4, "Cuvée Vendémiaire - Brut Blanc de Blancs", "2017", "Doyard",
                "Champagne", "heel rijpe Champagne met aroma's van rijp en gedroogd fruit en een lichte toets van vanille.",
                12.35, "100% Chardonnay"));
        return wines;
    }

    @Override
    public String toString() {
        return name + " - " + kindId + " - " + alcoholPercentage + "%Alc";
    }
}
