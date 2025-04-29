package services;
import entities.*;
import utils.MyDataBase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceHebergement implements IHebergement<Hebergement> {
    Connection con;

    public ServiceHebergement() {
        con = MyDataBase.getInstance().getConnection();
    }

    @Override
    public void ajouterHebergement(Hebergement hebergement) throws SQLException {
        String req = "INSERT INTO hebergement(nom_hebergement,ville_hebergement,type_hebergement,description_hebergement,prix_hebergement)VALUES(?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(req);
        ps.setString(1, hebergement.getNom_hebergement());
        ps.setString(2, hebergement.getAdresse_hebergement());
        ps.setString(4, hebergement.getDescription_hebergement());
        ps.setDouble(5, hebergement.getPrix_hebergement());
        ps.executeUpdate();
        System.out.println("Hebergement ajouté");

    }

    @Override
    public void supprimerHebergement(Hebergement hebergement) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        String req = "DELETE FROM hebergement WHERE id_hebergement = ?";
        PreparedStatement ps = con.prepareStatement(req);
        ps.setInt(1, hebergement.getId_hebergement());
        ps.executeUpdate();
    }

    @Override
    public void modifierHebergements(Hebergement hebergement) throws SQLException {
    String req = "UPDATE hebergement Set nom_hebergement=? , ville_hebergement=?, type_hebergement=? ,description_hebergement=? ,prix_hebergement=? WHERE id_hebergement = ?";
        PreparedStatement ps = con.prepareStatement(req);
        ps.setString(1,hebergement.getNom_hebergement() );
        ps.setString(2,hebergement.getAdresse_hebergement());
        ps.setString(4,hebergement.getDescription_hebergement());
        ps.setDouble(5,hebergement.getPrix_hebergement());
        ps.setInt(6,hebergement.getId_hebergement());
        ps.executeUpdate();
    }

    @Override
    public List<Hebergement> afficherHebergements() throws SQLException {
        List<Hebergement> hebergements = new ArrayList<>();
        System.out.println("Entre l'ID de l'hebergement : ");
        Scanner scanner = new Scanner(System.in);
        int idHebergement = scanner.nextInt();

        String req = "SELECT * FROM hebergement WHERE id_hebergement = ?";
        PreparedStatement ps = con.prepareStatement(req);
        ps.setInt(1, idHebergement);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Hebergement hebergement = new Hebergement(
                    rs.getInt("id_hebergemrnt"),
                    rs.getInt("Capacite_hebergement"),
                    rs.getInt("id_Type_hebergement"),
                    rs.getString("nom_hebergement"),
                    rs.getString("adresse_hebergement"),
                    rs.getString("description_hebergement"),
                    rs.getDouble("prix_hebergement"),
                    rs.getDate("Date_dispo"));
                    hebergements.add(hebergement);
        }
        if(hebergements.isEmpty()){
            System.out.println("Le hebergement n'existe pas");
        }
        return hebergements;

    }
}

