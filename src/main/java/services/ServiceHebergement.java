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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nom d'hébergement : ");
        String NOM = scanner.nextLine();
        System.out.print("Entrez l'adresse' d'hébergement : ");
        String ADRESSE = scanner.nextLine();

        String check = "SELECT COUNT(*) FROM hebergement WHERE LOWER(nom_hebergement) = LOWER(?) AND LOWER(adresse_hebergement) = LOWER(?)";
        PreparedStatement checkps = con.prepareStatement(check);
        checkps.setString(1, NOM);
        checkps.setString(2, ADRESSE);
        ResultSet idResult = checkps.executeQuery();
        idResult.next();
        if (idResult.getInt(1) > 0) {
            System.out.println("cet hébergement existe déjà dans la base de données.");
            return;
        }
        else {
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
            System.out.println("Hébergement ajouté avec succès !");
        }



    }

    @Override
    public void supprimerHebergement(Hebergement hebergement) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez l'ID d'hébergement : ");
        int ID = scanner.nextInt();
        scanner.nextLine();
        String check = "SELECT COUNT(*) FROM hebergement WHERE id_hebergement = ? ";
        PreparedStatement checkps = con.prepareStatement(check);
        checkps.setInt(1, ID);
        ResultSet idResult = checkps.executeQuery();
        idResult.next();
        if (idResult.getInt(1) == 1) {
            String req = "DELETE FROM hebergement WHERE id_hebergement = ?";
            PreparedStatement ps = con.prepareStatement(req);
            ps.setInt(1, ID);
            ps.executeUpdate();
            System.out.println("hébergement supprimé");
        }
        else {
            System.out.println("hébergement n'existe pas dans la base de données");
        }
    }

    @Override
    public void modifierHebergements(Hebergement hebergement) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez l'ID d'hébergement : ");
        int ID = scanner.nextInt();
        scanner.nextLine();
        String check = "SELECT COUNT(*) FROM hebergement WHERE id_hebergement = ? ";
        PreparedStatement checkps = con.prepareStatement(check);
        checkps.setInt(1, ID);
        ResultSet idResult = checkps.executeQuery();
        idResult.next();
        if (idResult.getInt(1) == 1) {
            // Saisie des nouvelles valeurs
            System.out.print("Nouveau ID du type d'hébergement : ");
            int idType = scanner.nextInt();
            scanner.nextLine(); // vider la ligne

            System.out.print("Nouveau nom d'hébergement : ");
            String nom = scanner.nextLine();

            System.out.print("Nouvelle adresse : ");
            String adresse = scanner.nextLine();

            System.out.print("Nouvelle description : ");
            String description = scanner.nextLine();

            System.out.print("Nouvelle capacité : ");
            int capacite = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nouveau prix : ");
            double prix = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Nouvelle date de disponibilité (format : YYYY-MM-DD) : ");
            String dateStr = scanner.nextLine();
            Date date = Date.valueOf(dateStr); // conversion

            String req = "UPDATE hebergement Set id_type_hebergement = ?, nom_hebergement = ?, adresse_hebergement = ?, description_hebergement = ?,Capacite_hebergement = ?,prix_hebergement = ?,date_dispo = ? WHERE id_hebergement = ?";
            PreparedStatement ps = con.prepareStatement(req);
            ps.setInt(1, hebergement.getId_type_hebergement());
            ps.setString(2, hebergement.getNom_hebergement());
            ps.setString(3, hebergement.getAdresse_hebergement());
            ps.setString(4, hebergement.getDescription_hebergement());
            ps.setInt(5, hebergement.getCapacite_hebergement());
            ps.setDouble(6, hebergement.getPrix_hebergement());
            ps.setDate(7, hebergement.getDate_dispo());
            ps.setInt(8, ID);
            ps.executeUpdate();
            System.out.println("hébergement modifié avec succés");
        }
        else {
        System.out.println("hébergement n'existe pas dans la base de données");
        }
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

