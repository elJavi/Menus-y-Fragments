package com.eljavi.mascotas.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.eljavi.mascotas.R;
import com.eljavi.mascotas.adapter.Adapter2;
import com.eljavi.mascotas.pojo.Mascotas;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class PerfilFragment extends Fragment {

    ArrayList<Mascotas> mascotas;
    private RecyclerView listaPerfil;



    @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil_recycler_view, container, false);


        //Antes del fragm=ent esto estaba en el MainActivity
        listaPerfil = (RecyclerView) v.findViewById(R.id.rvMascotas2);

        GridLayoutManager glm = new GridLayoutManager( getActivity(), 3);
        glm.setOrientation(LinearLayoutManager.VERTICAL);

        //La lista de mascotas (RecyclerView se debe comportar como un linearLayoutManager
        listaPerfil.setLayoutManager(glm);

        inicializarMascotasPerfil();

        inicializarAdaptador2();

        return v;


    }



    public void inicializarAdaptador2(){

        Adapter2 adaptador2 = new Adapter2(mascotas);
        listaPerfil.setAdapter(adaptador2);


    }


    public void inicializarMascotasPerfil(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascotas("Firulas", 4, R.drawable.perro_blanconegro));
        mascotas.add(new Mascotas("Garfield", 5, R.drawable.gato_garfield));
        mascotas.add(new Mascotas("Solovino", 7, R.drawable.perro_doberman));
        mascotas.add(new Mascotas("Killer", 4, R.drawable.perro_sabueso));
        mascotas.add(new Mascotas("Garras", 3, R.drawable.gato_gris));
        mascotas.add(new Mascotas("Pirata", 11, R.drawable.gato_pirata));
        mascotas.add(new Mascotas("Firulas", 4, R.drawable.perro_blanconegro));
        mascotas.add(new Mascotas("Garfield", 5, R.drawable.gato_garfield));
        mascotas.add(new Mascotas("Solovino", 7, R.drawable.perro_doberman));
        mascotas.add(new Mascotas("Killer", 4, R.drawable.perro_sabueso));
        mascotas.add(new Mascotas("Garras", 3, R.drawable.gato_gris));
        mascotas.add(new Mascotas("Pirata", 11, R.drawable.gato_pirata));


    }
}