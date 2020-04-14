package com.example.tpproduits.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Produits implements Parcelable {
    private String Description;
    private int prixG;
    private int prixSG;
    private String link;
    private String Livraison;
    private int Garantie;
    private int idImage;

    public Produits(String Des, int prixg, int prigs, String link, String livraison, int Garantie, int idimage) {
        this.Description = Des;
        this.prixG = prixg;
        this.prixSG = prigs;
        this.link = link;
        this.Garantie = Garantie;
        this.Livraison = livraison;
        this.idImage = idimage;
    }


    protected Produits(Parcel in) {
        Description = in.readString();
        prixG = in.readInt();
        prixSG = in.readInt();
        link = in.readString();
        Livraison = in.readString();
        Garantie = in.readInt();
        idImage = in.readInt();
    }

    public static final Creator<Produits> CREATOR = new Creator<Produits>() {
        @Override
        public Produits createFromParcel(Parcel in) {
            return new Produits(in);
        }

        @Override
        public Produits[] newArray(int size) {
            return new Produits[size];
        }
    };

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getPrixG() {
        return prixG;
    }

    public void setPrixG(int prixG) {
        this.prixG = prixG;
    }

    public int getPrixSG() {
        return prixSG;
    }

    public void setPrixSG(int prixSG) {
        this.prixSG = prixSG;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLivraison() {
        return Livraison;
    }

    public void setLivraison(String livraison) {
        Livraison = livraison;
    }

    public int getGarantie() {
        return Garantie;
    }

    public void setGarantie(int garantie) {
        Garantie = garantie;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Description);
        dest.writeInt(prixG);
        dest.writeInt(prixSG);
        dest.writeString(link);
        dest.writeString(Livraison);
        dest.writeInt(Garantie);
        dest.writeInt(idImage);
    }



}
