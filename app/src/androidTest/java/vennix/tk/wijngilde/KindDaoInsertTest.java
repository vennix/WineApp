package vennix.tk.wijngilde;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import vennix.tk.wijngilde.daos.KindDAO;
import vennix.tk.wijngilde.database.WijnGildeDatabase;
import vennix.tk.wijngilde.entities.Kind;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class KindDaoInsertTest {
    private WijnGildeDatabase db;
    private KindDAO kindDao;

    @Before
    public void setUp() throws Exception {
        Context context = InstrumentationRegistry.getTargetContext();
        db = Room.inMemoryDatabaseBuilder(context, WijnGildeDatabase.class)
                .allowMainThreadQueries().build();
        kindDao = db.kindDao();
    }

    @After
    public void tearDown() throws Exception {
        db.close();
    }

    @Test
    public void insert() throws Exception {
        Kind kind = new Kind("rood");
        /*
         * bron: https://developer.android.com/training/data-storage/room/accessing-data
         * If the @Insert method receives only 1 parameter, it can return a long,
         * which is the new rowId for the inserted item. If the parameter is an array
         * or a collection, it should return long[] or List<Long> instead.
         *
         * This db is empty, so should return 1 for first element in table.
         */
        assertEquals("1", String.valueOf(kindDao.insert(kind)));
    }
}
