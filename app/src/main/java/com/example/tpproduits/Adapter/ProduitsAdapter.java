package com.example.tpproduits.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tpproduits.Model.Produits;
import com.example.tpproduits.Model.ViewHolderImage;
import com.example.tpproduits.R;

import java.util.List;

public class ProduitsAdapter extends ArrayAdapter<Produits> {
    List<Produits> produit;

    public ProduitsAdapter(Context context, List<Produits> produits){
        super(context,0,produits);
        this.produit = produits;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.produit, parent, false);
        }
        ViewHolderImage vholder = (ViewHolderImage) convertView.getTag();
        if (vholder == null) {
            vholder = new ViewHolderImage();
            vholder.img = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(vholder);
        }
        Produits produit = getItem(position);
        vholder.img.setImageResource(produit.getIdImage());

        return convertView;
    }


}
