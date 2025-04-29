package services;
import entities.Hebergement;
import entities.TypeHebergement;

import java.sql.SQLException;
import java.util.List;

public interface ITypeHebergement <T>{
    public String insererTypeHebergement(T Typehebergement) throws SQLException;
    public void ajouterTypeHebergement(T Typehebergement) throws SQLException;
    public List<TypeHebergement> afficherTypeHebergements() throws SQLException;

}
