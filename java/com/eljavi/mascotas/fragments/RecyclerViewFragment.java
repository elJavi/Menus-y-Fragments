package com.eljavi.mascotas.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eljavi.mascotas.R;
import com.eljavi.mascotas.adapter.Adapter;
import com.eljavi.mascotas.pojo.Mascotas;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;
    public FloatingActionButton actionButton;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        actionButton = (FloatingActionButton) v.findViewById(R.id.actionButton);
        //actionButton.setVisibility(View.VISIBLE);

        //Antes del fragm=ent esto estaba en el MainActivity
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //La lista de mascotas (RecyclerView se debe comportar como un linearLayoutManager
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();

        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        Adapter adaptador = new Adapter(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }


    public void inicializarListaMascotas(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascotas("Firulas", 4, R.drawable.perro_blanconegro));
        mascotas.add(new Mascotas("Garfield", 5, R.drawable.gato_garfield));
        mascotas.add(new Mascotas("Solovino", 7, R.drawable.perro_doberman));
        mascotas.add(new Mascotas("Killer", 4, R.drawable.perro_sabueso));
        mascotas.add(new Mascotas("Garras", 3, R.drawable.gato_gris));
        mascotas.add(new Mascotas("Pirata", 11, R.drawable.gato_pirata));
    }





}
