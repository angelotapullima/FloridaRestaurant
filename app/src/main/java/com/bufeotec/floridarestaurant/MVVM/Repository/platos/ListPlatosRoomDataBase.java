package com.bufeotec.floridarestaurant.MVVM.Repository.platos;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.bufeotec.floridarestaurant.MVVM.Models.ListaPlatos;


@Database(entities = {ListaPlatos.class}, version = 1)
public abstract class ListPlatosRoomDataBase extends RoomDatabase {
    public abstract ListPlatosDao postInfoDao();

    private static ListPlatosRoomDataBase INSTANCE;


    static ListPlatosRoomDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ListPlatosRoomDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ListPlatosRoomDataBase.class, "lista_platos_database")
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
                    new ListPlatosDbAsync(INSTANCE).execute();
                }
            };
}
