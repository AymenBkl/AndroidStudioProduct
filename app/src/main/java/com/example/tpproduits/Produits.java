package com.example.tpproduits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Produits extends AppCompatActivity {
    com.example.tpproduits.Model.Produits produit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produits);
        InitView();

    }

    public void aficherprixsgarantie(View v){
        TextView t = (TextView) findViewById(R.id.prix);
        t.setText(String.valueOf(produit.getPrixSG()));
    }
    public void aficherprixgarantie(View v){
        TextView t = (TextView) findViewById(R.id.prix);
        t.setText(String.valueOf(produit.getPrixG()));
    }
    public void takeme(View v){


    }
    public void InitView(){
        produit = (com.example.tpproduits.Model.Produits) getIntent().getParcelableExtra("produit");
        TextView t1 = (TextView) findViewById(R.id.des);
        TextView t2 = (TextView) findViewById(R.id.liv);
        TextView t3 = (TextView) findViewById(R.id.Garantie);
        TextView t4 = (TextView) findViewById((R.id.link));
        t1.setText(produit.getDescription());
        t2.setText(produit.getLivraison());
        t3.setText(String.valueOf(produit.getGarantie()));
        t4.setText(produit.getLink());
        t4.setMovementMethod(LinkMovementMethod.getInstance());
        t4.setText(Html.fromHtml(produit.getLink()));
        RadioButton chk1 = (RadioButton)  findViewById(R.id.chk1);
        RadioButton chk2 = (RadioButton) findViewById(R.id.chk2);
        ImageView img = (ImageView) findViewById(R.id.imagproduit);
        img.setImageResource(produit.getIdImage());

    }
}
