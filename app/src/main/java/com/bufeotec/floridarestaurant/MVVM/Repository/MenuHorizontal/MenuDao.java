package com.bufeotec.floridarestaurant.MVVM.Repository.MenuHorizontal;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;


import com.bufeotec.floridarestaurant.MVVM.Models.Menu;

import java.util.List;

@Dao
public interface MenuDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Menu resultModel);

    @Query("SELECT * from lista_menu ")
    LiveData<List<Menu>> getAllMenus();

    @Query("DELETE FROM lista_menu")
    void deleteAll();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMenu(List<Menu> resultModel);

}
