package com.eljavi.mascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.eljavi.mascotas.adapter.Adapter;
import com.eljavi.mascotas.fragments.PerfilFragment;
import com.eljavi.mascotas.fragments.RecyclerViewFragment;
import com.eljavi.mascotas.pojo.Mascotas;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    //Los views del fragment
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public FloatingActionButton actionButton;

    ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        actionButton = (FloatingActionButton) findViewById(R.id.actionButton);
        actionButton.setVisibility(View.GONE);


        setUpViewPager();

        Toolbar toolbarMenu = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }




    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    //Poner en orbita los fragments
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), 0, agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        //Asignar un icono a cada fragment
        tabLayout.getTabAt(0).setIcon(R.drawable.casa_perro);
        tabLayout.getTabAt(1).setIcon(R.drawable.perro);

    }

    //BOTON QUE LANZA A LA SEGUNDA ACTIVIDAD
    //Esta funcion no funciono porque el boton esta en el menu
    //Se usa el switch case de la funcion de hasta abajo
    public void launchSegunda(View view){
        Intent i = new Intent(MainActivity.this, SegundaActivity.class);
        startActivity(i);
    }



    //PARA CREAR EL MENU DE OPCIONES LAS SIGUIENTES FUNCIONES
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.mContacto:
                Intent contacto = new Intent(this, ContactoActivity.class);
                startActivity(contacto);
                break;

            case R.id.mAcerca:
                Intent acerca = new Intent(this, AcercaActivity.class);
                startActivity(acerca);
                break;

            case R.id.mActionBar:                                                   ////////////OPCION DEL ACTION VIEW ESTRELLA QUE ESTA EN menu_opciones.xml
                Intent i = new Intent(MainActivity.this, SegundaActivity.class);
                startActivity(i);
                break;

        }

        return super.onOptionsItemSelected(item);
    }




















}


