package com.franciscorp.meli.pruebameli.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.franciscorp.meli.pruebameli.models.Category;
import com.franciscorp.meli.pruebameli.data.categories.CategoryDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Database(entities = {Category.class}, version = 1, exportSchema = false)
public abstract class MeliRoomDatabase extends RoomDatabase {
    public abstract CategoryDao categoryDao();

    private static volatile MeliRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                CategoryDao dao = INSTANCE.categoryDao();
                dao.deleteAll();
            });
        }
    };

    public static MeliRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MeliRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MeliRoomDatabase.class, "meli_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
