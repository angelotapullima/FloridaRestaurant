package com.bufeotec.floridarestaurant.MVVM.Repository.platos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.bufeotec.floridarestaurant.MVVM.Models.ListaPlatos;

import java.util.List;

@Dao
public interface ListPlatosDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ListaPlatos listaPlatos);

    @Query("SELECT * from lista_platos ")
    LiveData<List<ListaPlatos>> getAllPosts();

    @Query("DELETE FROM lista_platos")
    void deleteAll();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPosts(List<ListaPlatos> listaPlatos);

}
