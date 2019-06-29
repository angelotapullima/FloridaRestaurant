package com.bufeotec.floridarestaurant.MVVM.Repository.MenuHorizontal;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.bufeotec.floridarestaurant.MVVM.Models.Menu;

@Database(entities = {Menu.class}, version = 1)
public abstract class MenuRoomDataBase extends RoomDatabase {
    public abstract MenuDao postInfoDao();

    private static MenuRoomDataBase INSTANCE;


    static MenuRoomDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MenuRoomDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MenuRoomDataBase.class, "lista_menu_database")
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
                    new MenuDbAsync(INSTANCE).execute();
                }
            };
}
