package com.eljavi.mascotas.adapter;


//ADAPTADOR DE RECYCLER VIEW PARA EL FRAGMENT DE PERFIL. NECESITA UN ADAPTADOR MAS SENCILLO Y CON OTRO
//DISENO DE CARD VIEW PERFIL

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.eljavi.mascotas.R;
import com.eljavi.mascotas.pojo.Mascotas;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.Adapter2ViewHolder> {

    ArrayList<Mascotas> mascotas;

    public Adapter2(ArrayList<Mascotas>mascotas){
        this.mascotas = mascotas;
    }


    @NonNull
    @Override
    public Adapter2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil, parent, false);

        return new Adapter2ViewHolder(v); //CONSTRUCTOR DE LA CLASE ESTATICA DE ABAJO
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter2ViewHolder mascotaViewHolder, int position) {
        Mascotas mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto2.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre2.setText(mascota.getNombre());
        mascotaViewHolder.tvLikes2.setText(String.valueOf(mascota.getLikes()));

    }

    @Override
    public int getItemCount() {   //CANTIDAD DE ELEMENTOS EN EL PERFIL. SE VA A USAR EL MISMO ARRAY CON UNA SOLA FOTO
        return mascotas.size();
    }

    //CLASE ADENTRO DE LA CLASE. ANIDADA. VIEW HOLDER
    public static class Adapter2ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto2;
        private TextView tvNombre2;
        private TextView tvLikes2;

        //CONSTRUCTOR
        public Adapter2ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto2 = (ImageView) itemView.findViewById(R.id.imgFoto2);
            tvNombre2 =(TextView) itemView.findViewById(R.id.tvNombre2);
            tvLikes2 = (TextView) itemView.findViewById(R.id.tvLikes2);

        }
    }




}
