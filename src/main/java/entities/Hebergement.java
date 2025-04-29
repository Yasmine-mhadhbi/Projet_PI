package entities;

import java.sql.Date;


public class Hebergement {
    private int id_hebergement,id_type_hebergement,Capacite_hebergement;
    private String nom_hebergement, adresse_hebergement, description_hebergement;
    private double prix_hebergement;
    private java.sql.Date date_dispo;


    public Hebergement() {}

    public Hebergement(int id_hebergement,  int id_type_hebergement, int capacite_hebergement, String nom_hebergement, String adresse_hebergement, String description_hebergement, double prix_hebergement, Date date_dispo) {

        this.id_hebergement = id_hebergement;
        this.id_type_hebergement = id_type_hebergement;
        this.Capacite_hebergement = capacite_hebergement;
        this.nom_hebergement = nom_hebergement;
        this.adresse_hebergement = adresse_hebergement;
        this.description_hebergement = description_hebergement;
        this.prix_hebergement = prix_hebergement;
        this.date_dispo = date_dispo;
    }


    public int getCapacite_hebergement() {
        return Capacite_hebergement;
    }
    public String getNom_hebergement() {
        return nom_hebergement;
    }
    public String getAdresse_hebergement() {
        return adresse_hebergement;
    }
    public String getDescription_hebergement() {
        return description_hebergement;
    }
    public double getPrix_hebergement() {
        return prix_hebergement;
    }
    public Date getDate_dispo() {
        return date_dispo;
    }
    public int getId_type_hebergement() {
        return id_type_hebergement;
    }




    @Override
    public String toString() {
        return "Hebergement{" +
                "id_hebergement=" + id_hebergement +
                ", Capacite_hebergement=" + Capacite_hebergement +
                ", id_type_hebergement=" + id_type_hebergement +
                ", nom_hebergement='" + nom_hebergement + '\'' +
                ", adresse_hebergement='" + adresse_hebergement + '\'' +
                ", description_hebergement='" + description_hebergement + '\'' +
                ", prix_hebergement=" + prix_hebergement +
                ", date_dispo=" + date_dispo +
                '}';
    }
}
