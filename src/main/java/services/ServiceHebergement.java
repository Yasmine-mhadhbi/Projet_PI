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
        try{
            if(hebergement.getNom_hebergement() == null || hebergement.getNom_hebergement().trim().isEmpty()){
                System.out.println("Le nom ne peut pas être vide.");
            }

            int ID = hebergement.getId_type_hebergement();
            if (ID < 1 || ID > 3) {
                System.out.println("ID doit être entre 1 e 3.");
            }
            String req = "INSERT INTO hebergement(id_type_hebergement, nom_hebergement, adresse_hebergement, description_hebergement,Capacite_hebergement,prix_hebergement,date_dispo)VALUES(?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(req);

            ps.setInt(1, hebergement.getId_type_hebergement());
            ps.setString(2, hebergement.getNom_hebergement());
            ps.setString(3, hebergement.getAdresse_hebergement());
            ps.setString(4, hebergement.getDescription_hebergement());
            ps.setInt(5, hebergement.getCapacite_hebergement());
            ps.setDouble(6, hebergement.getPrix_hebergement());
            ps.setDate(7, hebergement.getDate_dispo());
            ps.executeUpdate();
           System.out.println("Hebergement ajouté avec succès !");

        }
        catch(SQLException e){
            System.out.println(e);
        }

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

