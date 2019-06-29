package com.bufeotec.floridarestaurant.MVVM.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "lista_reviews")
public class Reviews {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "review_id")
    @SerializedName("review_id")
    private String review_id;

    @ColumnInfo(name = "review_foto")
    @SerializedName("review_foto")
    private String review_foto;

    @ColumnInfo(name = "review_nombre")
    @SerializedName("review_nombre")
    private String review_nombre;

    @ColumnInfo(name = "review_descripcion")
    @SerializedName("review_descripcion")
    private String review_descripcion;

    @NonNull
    public String getReview_id() {
        return review_id;
    }

    public void setReview_id(@NonNull String review_id) {
        this.review_id = review_id;
    }

    public String getReview_foto() {
        return review_foto;
    }

    public void setReview_foto(String review_foto) {
        this.review_foto = review_foto;
    }

    public String getReview_nombre() {
        return review_nombre;
    }

    public void setReview_nombre(String review_nombre) {
        this.review_nombre = review_nombre;
    }

    public String getReview_descripcion() {
        return review_descripcion;
    }

    public void setReview_descripcion(String review_descripcion) {
        this.review_descripcion = review_descripcion;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "review_id='" + review_id + '\'' +
                ", review_foto='" + review_foto + '\'' +
                ", review_nombre='" + review_nombre + '\'' +
                ", review_descripcion='" + review_descripcion + '\'' +
                '}';
    }
}
