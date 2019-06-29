package com.bufeotec.floridarestaurant.MVVM.Repository.Reviews;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import com.bufeotec.floridarestaurant.MVVM.Models.Reviews;

@Database(entities = {Reviews.class}, version = 1)
public abstract class ReviewsRoomDataBase extends RoomDatabase {
    public abstract ReviewsDao postInfoDao();

    private static ReviewsRoomDataBase INSTANCE;


    static ReviewsRoomDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ReviewsRoomDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ReviewsRoomDataBase.class, "lista_reviews_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();

                }
            }
        }
        return INSTANCE;
    }

    private static Callback sRoomDatabaseCallback =
            new Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new ReviewsDbAsync(INSTANCE).execute();
                }
            };
}
