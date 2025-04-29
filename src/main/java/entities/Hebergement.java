package entities;

import java.util.Date;

public class Hebergement {
    private int id_hebergement,Capacite_hebergement;
    private int id_type_hebergement;
    private String nom_hebergement, adresse_hebergement, description_hebergement;
    private double prix_hebergement;
    private Date date_dispo;


    public Hebergement() {}

    public Hebergement(int id_hebergement, int capacite_hebergement, int id_type_hebergement, String nom_hebergement, String adresse_hebergement, String description_hebergement, double prix_hebergement, Date date_dispo) {

        this.id_hebergement = id_hebergement;
        this.Capacite_hebergement = capacite_hebergement;
        this.id_type_hebergement = id_type_hebergement;
        this.nom_hebergement = nom_hebergement;
        this.adresse_hebergement = adresse_hebergement;
        this.description_hebergement = description_hebergement;
        this.prix_hebergement = prix_hebergement;
        this.date_dispo = date_dispo;
    }

    public Hebergement(int id_hebergement, int Capacite_hebergement, String nom_hebergement, String ville_hebergement, String description_hebergement, double prix_hebergement, Date date_dispo, TypeHebergement type_hebergement) {
        this.id_hebergement=id_hebergement;
        this.Capacite_hebergement=Capacite_hebergement;
        this.nom_hebergement=nom_hebergement;
        this.adresse_hebergement=adresse_hebergement;
        this.description_hebergement=description_hebergement;
        this.prix_hebergement=prix_hebergement;
        this.date_dispo=date_dispo;
    }
    public int getId_hebergement() {
        return id_hebergement;
    }
    public void setId_hebergement(int id_hebergement) {
        this.id_hebergement=id_hebergement;
    }
    public int getCapacite_hebergement() {
        return Capacite_hebergement;
    }
    public void setCapacite_hebergement(int capaciteHebergement) {
        Capacite_hebergement=capaciteHebergement;
    }
    public String getNom_hebergement() {
        return nom_hebergement;
    }
    public void setNom_hebergement(String nom_hebergement) {
        this.nom_hebergement=nom_hebergement;
    }
    public String getAdresse_hebergement() {
        return adresse_hebergement;
    }
    public void setAdresse_hebergement(String ville_hebergement){
        this.adresse_hebergement=ville_hebergement;
    }
    public String getDescription_hebergement() {
        return description_hebergement;
    }
    public void setDescription_hebergement(String description_hebergement) {
        this.description_hebergement = description_hebergement;
    }
    public double getPrix_hebergement() {
        return prix_hebergement;
    }
    public void setPrix_hebergement(double prix_hebergement) {
        this.prix_hebergement = prix_hebergement;
    }
    public Date getDate_dispo() {
        return date_dispo;
    }
    public void setDate_dispo(Date date_dispo) {
        this.date_dispo = date_dispo;
    }
    public int getId_type_hebergement() {
        return id_type_hebergement;
    }

    public void setId_type_hebergement(int id_type_hebergement) {
        this.id_type_hebergement = id_type_hebergement;
    }

    public int getType_hebergement() {
        return id_type_hebergement;
    }

    public void setType_hebergement(int id_type_hebergement) {
        this.id_type_hebergement = id_type_hebergement;
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
