package com.example.tpproduits;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tpproduits.Adapter.ProduitsAdapter;
import com.example.tpproduits.Model.Produits;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener {
    MediaPlayer mysound;
    ListView mylist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (mysound ==null) {
            mysound = MediaPlayer.create(getApplicationContext(), R.raw.mysong);
            mysound.start();
        }
        else {
            mysound.start();
        }
        mylist = (ListView) findViewById(R.id.products);
        List<Produits> produits = lesProduits();
        ProduitsAdapter padapter = new ProduitsAdapter(MainActivity.this,produits);
        mylist.setAdapter(padapter);
        mylist.setOnItemClickListener(this);
        mylist.setOnItemLongClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Produits o = (Produits) mylist.getItemAtPosition(position);
        String p = String.valueOf(o.getPrixG());
        Toast.makeText(MainActivity.this,p,Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this, com.example.tpproduits.Produits.class);
        Produits produit = (Produits) mylist.getItemAtPosition(position);
        intent.putExtra("produit",produit);
        mysound.pause();
        startActivity(intent);
        return false;
    }
    public List<Produits> lesProduits(){
        Resources res = getResources();
        String[] descriptions = res.getStringArray(R.array.Description);
        String[] livraison = res.getStringArray(R.array.Livraison);
        String[] links = res.getStringArray(R.array.Links);
        int[] prixg = res.getIntArray(R.array.PrixG);
        int[] prixsg = res.getIntArray(R.array.PrixSG);
        String[] idimage = res.getStringArray(R.array.idimage);
        int[] garantie = res.getIntArray(R.array.jours);
        List<Produits> produits = new ArrayList<Produits>();
        for (int i = 0;i<descriptions.length;i++){
            int id = getResources().getIdentifier(idimage[i], "drawable", getPackageName());
            produits.add(new Produits(descriptions[i],prixg[i],prixsg[i],links[i],livraison[i],garantie[i],id));
        }
        return produits;
    }

}
