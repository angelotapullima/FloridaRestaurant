package com.bufeotec.floridarestaurant.MVVM.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "lista_platos")
public class ListaPlatos
{
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "plato_id")
    @SerializedName("plato_id")
    private String plato_id;

    @ColumnInfo(name = "plato_foto")
    @SerializedName("plato_foto")
    private String plato_foto;


    @ColumnInfo(name = "plato_nombre")
    @SerializedName("plato_nombre")
    private String plato_nombre;


    @ColumnInfo(name = "plato_descripcion")
    @SerializedName("plato_descripcion")
    private String plato_descripcion;


    @ColumnInfo(name = "plato_precio")
    @SerializedName("plato_precio")
    private String plato_precio;


    @ColumnInfo(name = "plato_disponibilidad")
    @SerializedName("plato_disponibilidad")
    private String plato_disponibilidad;

    @NonNull
    public String getPlato_id() {
        return plato_id;
    }

    public void setPlato_id(@NonNull String plato_id) {
        this.plato_id = plato_id;
    }

    public String getPlato_foto() {
        return plato_foto;
    }

    public void setPlato_foto(String plato_foto) {
        this.plato_foto = plato_foto;
    }

    public String getPlato_nombre() {
        return plato_nombre;
    }

    public void setPlato_nombre(String plato_nombre) {
        this.plato_nombre = plato_nombre;
    }

    public String getPlato_descripcion() {
        return plato_descripcion;
    }

    public void setPlato_descripcion(String plato_descripcion) {
        this.plato_descripcion = plato_descripcion;
    }

    public String getPlato_precio() {
        return plato_precio;
    }

    public void setPlato_precio(String plato_precio) {
        this.plato_precio = plato_precio;
    }

    public String getPlato_disponibilidad() {
        return plato_disponibilidad;
    }

    public void setPlato_disponibilidad(String plato_disponibilidad) {
        this.plato_disponibilidad = plato_disponibilidad;
    }

    @Override
    public String toString() {
        return "ListaPlatos{" +
                "plato_id='" + plato_id + '\'' +
                ", plato_foto='" + plato_foto + '\'' +
                ", plato_nombre='" + plato_nombre + '\'' +
                ", plato_descripcion='" + plato_descripcion + '\'' +
                ", plato_precio='" + plato_precio + '\'' +
                ", plato_disponibilidad='" + plato_disponibilidad + '\'' +
                '}';
    }

    /*@Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", body = "+body+", title = "+title+"]";
    }*/
}

/*
@Entity(tableName = "post_info")


return "ClassPojo [id = "+id+", body = "+body+", title = "+title+"]";

 public class ListaPlatos implements Parcelable{
        @NonNull
        @ColumnInfo(name = "userId")
        @SerializedName("userId")
        @Expose
        private Integer userId;

        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "id")
        @SerializedName("id")
        @Expose
        private Integer id;

        @NonNull
        @ColumnInfo(name = "title")
        @SerializedName("title")
        @Expose
        private String title;

        @NonNull
        @ColumnInfo(name = "body")
        @SerializedName("body")
        @Expose
        private String body;

        public final Creator<ListaPlatos> CREATOR = new Creator<ListaPlatos>() {

            @SuppressWarnings({
                    "unchecked"
            })
            public ListaPlatos createFromParcel(Parcel in) {
                ListaPlatos instance = new ListaPlatos();

                instance.id = ((Integer) in.readValue((Integer.class.getClassLoader())));

                instance.title = ((String) in.readValue((String.class.getClassLoader())));

                instance.body = ((String) in.readValue((String.class.getClassLoader())));

                return instance;
            }

            public ListaPlatos[] newArray(int size) {
                return (new ListaPlatos[size]);
            }

        };



        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }



        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }


        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }



        public void writeToParcel(Parcel dest, int flags) {

            dest.writeValue(id);

            dest.writeValue(title);

            dest.writeValue(body);

        }

        public int describeContents() {
            return 0;
        }
    }

*/
