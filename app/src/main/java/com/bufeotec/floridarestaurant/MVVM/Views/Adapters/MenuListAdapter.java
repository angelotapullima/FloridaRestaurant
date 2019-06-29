package com.bufeotec.floridarestaurant.MVVM.Views.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bufeotec.floridarestaurant.MVVM.Models.Menu;
import com.bufeotec.floridarestaurant.R;
import com.bufeotec.floridarestaurant.Utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.MenuViewHolder> {

    UniversalImageLoader universalImageLoader;


    class MenuViewHolder extends RecyclerView.ViewHolder {

        TextView nombre;
        ImageView foto;

        private MenuViewHolder(View itemView) {
            super(itemView);
            nombre= itemView.findViewById(R.id.txt_menu);
            foto= itemView.findViewById(R.id.img_menu);

        }
    }

    private final LayoutInflater mInflater;
    private List<Menu> listaMenu; // Cached copy of users


    public MenuListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        universalImageLoader = new UniversalImageLoader(context);}

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.rcv_menu_horizontal, parent, false);
        return new MenuViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        if (listaMenu != null) {
            Menu current = listaMenu.get(position);

            ImageLoader.getInstance().init(universalImageLoader.getConfig());
            UniversalImageLoader.setImage(current.getMenu_foto(),holder.foto,null);
            holder.nombre.setText(current.getMenu_nombre());




        } else {
            // Covers the case of data not being ready yet.
            // holder.userNameView.setText("No Word");
        }
    }
    public void setWords(List<Menu> users){
        listaMenu = users;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (listaMenu != null) {
            return listaMenu.size();
        }else{
            return  0;
        }
    }
}
