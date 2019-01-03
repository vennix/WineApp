package vennix.tk.wijngilde.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import vennix.tk.wijngilde.entities.Kind;
import vennix.tk.wijngilde.entities.Wine;
import vennix.tk.wijngilde.daos.KindDAO;
import vennix.tk.wijngilde.daos.WineDAO;


@Database(entities = {Wine.class, Kind.class}, version = 1)
public abstract class WijnGildeDatabase extends RoomDatabase {

    public abstract WineDAO wineDao();
    public abstract KindDAO kindDao();

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
                                    Executors.newSingleThreadScheduledExecutor()
                                            .execute(new Runnable() {
                                        @Override
                                        public void run() {
                                            getDatabase(context).wineDao()
                                                    .insertList(Wine.getStartingData());
                                        }
                                    });
                                }
                            })
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
