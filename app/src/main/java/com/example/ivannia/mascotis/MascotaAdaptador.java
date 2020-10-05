package com.example.ivannia.mascotis;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;
    /**
     * Created by ivannia on 29/9/2020.
     */

    public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.ContactoViewHolder> {
        ArrayList<Contacto> contactos;
        Activity activity;

        public MascotaAdaptador(ArrayList<Contacto> contactos, Activity activity){
            this.contactos = contactos;
            this.activity = activity;
        }

        //Infla el layout y lo pasa al view holder para que él obtenga c view
        @Override
        public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_main, parent, false);
            return new ContactoViewHolder(v);


        }
        //asocia c/elemt de la lista a cada view
        @Override
        public void onBindViewHolder(ContactoViewHolder contactoViewHolder, int position) {
            final Contacto contacto = contactos.get(position);
            contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
            contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
            contactoViewHolder.tvTelefonoCV.setText(contacto.getTelefono());

            contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Toast.makeText(activity, contacto.getNombre(), Toast,LENGTH_SHORT).show();
                    Intent intento = new Intent(activity, DetalleMascota.class);
                    intento.putExtra("nombre", contacto.getNombre());
                    intento.putExtra("telefono", contacto.getTelefono());
                    intento.putExtra("email", contacto.getEmail());
                    activity.startActivity(intento);
                }
            });
        }

        @Override
        public int getItemCount() {// Cantd de elemts que  contiene la list de contactos
            return contactos.size();
        }

        public static class ContactoViewHolder extends RecyclerView.ViewHolder{
            private ImageView imgFoto;
            private TextView tvNombreCV;
            private TextView tvTelefonoCV;

            public ContactoViewHolder(View itemView) {
                super(itemView);
                imgFoto=(ImageView) itemView.findViewById(R.id.imgFoto);
                tvNombreCV=(TextView) itemView.findViewById(R.id.tvNombre);
                tvTelefonoCV=(TextView) itemView.findViewById(R.id.tvTelefonoCV);
            }
        }
    }


