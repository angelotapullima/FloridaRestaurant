package com.bufeotec.floridarestaurant.MVVM.Views.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bufeotec.floridarestaurant.MVVM.Models.ListaPlatos;
import com.bufeotec.floridarestaurant.R;
import com.bufeotec.floridarestaurant.Utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class PlatosListAdapter extends RecyclerView.Adapter<PlatosListAdapter.PostViewHolder> {

    UniversalImageLoader universalImageLoader;
    String foto ;

    class PostViewHolder extends RecyclerView.ViewHolder {
        private ImageView plato_foto;
        private TextView plato_nombre, plato_descripcion,  plato_precio,plato_disponibilidad,plato_add;

        private PostViewHolder(View itemView) {
            super(itemView);
            plato_foto=  itemView.findViewById(R.id.plato_foto);
            plato_nombre=  itemView.findViewById(R.id.plato_nombre);
            plato_descripcion=  itemView.findViewById(R.id.plato_descripcion);
            plato_precio = itemView.findViewById(R.id.plato_precio);
            plato_disponibilidad=  itemView.findViewById(R.id.plato_disponibilidad);
            plato_add=  itemView.findViewById(R.id.plato_add);
        }
    }

    private final LayoutInflater mInflater;
    private List<ListaPlatos> listaPlatos; // Cached copy of users


    public PlatosListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        universalImageLoader = new UniversalImageLoader(context);}

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.rcv_list_platos, parent, false);
        return new PostViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        if (listaPlatos != null) {
            ListaPlatos current = listaPlatos.get(position);
            /*holder.id.setText(""+current.getId());
            holder.title.setText(current.getDestino());
            holder.body.setText(current.getFoto());*/


            holder.setIsRecyclable(false);
            holder.plato_add.setId(position);
            ImageLoader.getInstance().init(universalImageLoader.getConfig());

            holder.plato_nombre.setText(current.getPlato_nombre());
            holder.plato_descripcion.setText(current.getPlato_descripcion());
            holder.plato_disponibilidad.setText(current.getPlato_disponibilidad());
            holder.plato_precio.setText(current.getPlato_precio());

            UniversalImageLoader.setImage(current.getPlato_foto(),holder.plato_foto,null);






        } else {
            // Covers the case of data not being ready yet.
           // holder.userNameView.setText("No Word");
        }
    }
    public void setWords(List<ListaPlatos> users){
        listaPlatos = users;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (listaPlatos != null) {
            return listaPlatos.size();
        }else{
            return  0;
        }
    }
}
