package vennix.tk.wijngilde.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.concurrent.Executors;

import vennix.tk.wijngilde.converters.DateTypeConverter;
import vennix.tk.wijngilde.daos.EventDAO;
import vennix.tk.wijngilde.entities.Event;
import vennix.tk.wijngilde.entities.Kind;
import vennix.tk.wijngilde.entities.Wine;
import vennix.tk.wijngilde.daos.KindDAO;
import vennix.tk.wijngilde.daos.WineDAO;


@Database(entities = {Wine.class, Kind.class, Event.class}, version = 1)
@TypeConverters({DateTypeConverter.class})
public abstract class WijnGildeDatabase extends RoomDatabase {

    public abstract WineDAO wineDao();
    public abstract KindDAO kindDao();
    public abstract EventDAO eventDao();

    private static volatile WijnGildeDatabase INSTANCE;

    public static WijnGildeDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WijnGildeDatabase.class) {
                if (INSTANCE == null) {
                    // Create database
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WijnGildeDatabase.class,
                            "wijngilde_database")
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    /*
                                    Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                                        @Override
                                        public void run() {
                                            getDatabase(context).kindDao().insertList(Kind.getStartingData());
                                        }
                                    });
                                    */
                                    Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                                        @Override
                                        public void run() {
                                            getDatabase(context).wineDao().insertList(Wine.getStartingData());
                                        }
                                    });
                                    Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                                        @Override
                                        public void run() {
                                            getDatabase(context).eventDao().insertList(Event.getStartingData());
                                        }
                                    });
                                }
                            })
                            //.addMigrations(MIGRATION_5_6)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    //migration from db version 1 to db version 2
    /*
    static final Migration MIGRATION_5_6 = new Migration(5, 6) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            //database.execSQL("CREATE TABLE 'event' ('event_id' INTEGER, 'name' TEXT, 'places' INTEGER, PRIMARY KEY('event_id'))");
            database.execSQL("INSERT INTO 'kind' ('kind_id', 'name') VALUES ('1', 'rood')");
            database.execSQL("INSERT INTO 'kind' ('kind_id', 'name') VALUES ('2', 'wit')");
            database.execSQL("INSERT INTO 'kind' ('kind_id', 'name') VALUES ('3', 'rose')");

            database.execSQL("INSERT INTO 'wine' ('wine_id', 'kind', 'name', 'description', 'alcohol_percentage') VALUES ('2', '1', 'Pomerol', 'lekkere wijn', '12.50')");
            database.execSQL("INSERT INTO 'wine' ('wine_id', 'kind', 'name', 'description', 'alcohol_percentage') VALUES ('3', '2', 'Agnes', 'lekkere wijn', '10.50')");
            database.execSQL("INSERT INTO 'wine' ('wine_id', 'kind', 'name', 'description', 'alcohol_percentage') VALUES ('4', '3', 'Coquille Rosé', 'lekkere wijn', '9.50')");

            database.execSQL("INSERT INTO 'event' ('event_id', 'name', 'places') VALUES ('1', 'Wijnen uit Africe', '75')");
            database.execSQL("INSERT INTO 'event' ('event_id', 'name', 'places') VALUES ('2', 'Wijn maken deel 1', '75')");
            database.execSQL("INSERT INTO 'event' ('event_id', 'name', 'places') VALUES ('3', 'Wijnen uit Frankrijk', '75')");
        }
    };
    */
}
