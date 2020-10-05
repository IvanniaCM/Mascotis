package com.example.ivannia.mascotis;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm= new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);


        listaContactos.setLayoutManager(llm);
        inicializaListaContactos();
        inicializarAdaptador();

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);


    }
    public void  irSegundaActividad(View view){
        Intent adelante = new Intent(this, DetalleMascota.class);
        startActivity(adelante);
    }
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(contactos);
        listaContactos.setAdapter(adaptador);
        adaptador= new MascotaAdaptador(contactos, this);
        listaContactos.setAdapter();


    }
    public void inicializaListaContactos(){
        contactos = new ArrayList<Contacto>();

        contactos.add (new Contacto(R.drawable.images, "Josué Tapia", "54554544", "Josué@gmail.com"));
        contactos.add (new Contacto(R.drawable.images2,"Maria Sequeira", "5455554", "Maria@gmail.com"));
        contactos.add (new Contacto(R.drawable.images3, "jose Oscar", "58754544", "jose@gmail.com"));
        contactos.add (new Contacto(R.drawable.images4, "Melany Carrillo", "54554785", "Melany@gmail.com"));
        contactos.add (new Contacto(R.drawable.images, "Mario Bros", "5454644", "Mario@gmail.com"));

    }
}


