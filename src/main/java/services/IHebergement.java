package services;

import entities.Hebergement;

import java.sql.SQLException;
import java.util.List;

public interface IHebergement <T>{
    public void ajouterHebergement(T hebergement) throws SQLException;
    public void supprimerHebergement(T hebergement) throws SQLException;
    public void modifierHebergements(T hebergemengt)   throws SQLException;
    public List<Hebergement> afficherHebergements() throws SQLException;
}
