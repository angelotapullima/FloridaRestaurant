package com.bufeotec.floridarestaurant.MVVM.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "lista_menu")
public class Menu {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "menu_id")
    @SerializedName("menu_id")
    private String menu_id;

    @ColumnInfo(name = "menu_foto")
    @SerializedName("menu_foto")
    private String menu_foto;

    @ColumnInfo(name = "menu_nombre")
    @SerializedName("menu_nombre")
    private String menu_nombre;

    @NonNull
    public String getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(@NonNull String menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_foto() {
        return menu_foto;
    }

    public void setMenu_foto(String menu_foto) {
        this.menu_foto = menu_foto;
    }

    public String getMenu_nombre() {
        return menu_nombre;
    }

    public void setMenu_nombre(String menu_nombre) {
        this.menu_nombre = menu_nombre;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menu_id='" + menu_id + '\'' +
                ", menu_foto='" + menu_foto + '\'' +
                ", menu_nombre='" + menu_nombre + '\'' +
                '}';
    }
}
