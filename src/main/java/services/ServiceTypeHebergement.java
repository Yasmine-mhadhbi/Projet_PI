package services;

import entities.Hebergement;
import entities.TypeHebergement;
import utils.MyDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceTypeHebergement implements ITypeHebergement<TypeHebergement>{

    Connection con;

    public ServiceTypeHebergement() {
        con = MyDataBase.getInstance().getConnection();
    }

    @Override
    public String insererTypeHebergement(TypeHebergement Typehebergement) throws SQLException {

        int ID = Typehebergement.getId_type_hebergement();
        String Type = Typehebergement.getType_hebergement();

        if (ID < 1 || ID > 3) {
            System.out.println("ID doit être entre 1 e 3.");
        }

        switch (ID) {
            case 1:
                Type = "Hotel";
                break;
            case 2:
                Type = "Maison d'hôte";
                break;
            case 3:
                Type = "Appartement";
                break;
            default:
                return "Erreur : Type d'hébergement non reconnu.";
        }
        String req = "INSERT INTO typehebergement(id_type_hebergement, type_hebergement)VALUES(?,?)";
        PreparedStatement ps = con.prepareStatement(req);
        ps.setInt(1, ID);
        ps.setString(2, Type);
        ps.executeUpdate();

        return "Type d'hébergement '" + Type + "' inséré avec succès (ID = " + ID + ").";
    }

        public void ajouterTypeHebergement(TypeHebergement Typehebergement) throws SQLException {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez l'ID du type d'hébergement : ");
            int ID = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Entrez le nom du type d'hébergement : ");
            String Type = scanner.nextLine();

            String check = "SELECT COUNT(*) FROM typehebergement WHERE id_type_hebergement = ? AND LOWER(type_hebergement) = LOWER(?)";
            PreparedStatement checkps = con.prepareStatement(check);
            checkps.setInt(1, ID);
            checkps.setString(2, Type);
            ResultSet idResult = checkps.executeQuery();
            idResult.next();
            if (idResult.getInt(1) > 0) {
                System.out.println("ID ou Type existe déjà dans la base de données.");
                return;
            }
            else {
                String req = "INSERT INTO typehebergement(id_type_hebergement, type_hebergement) VALUES (?, ?)";

                PreparedStatement ps = con.prepareStatement(req);
                ps.setInt(1, ID);         // Ici tu utilises la valeur saisie
                ps.setString(2, Type);
                ps.executeUpdate();

                System.out.println("Type d'hébergement '" + Type + "' ajouté avec succès (ID = " + ID + ").");
            }

    }



    @Override
    public List<TypeHebergement> afficherTypeHebergements() throws SQLException {
        List<TypeHebergement> typeHebergements = new ArrayList<>();
        System.out.println("Entre l'ID du type d'hébergement : ");
        Scanner scanner = new Scanner(System.in);
        int ID = scanner.nextInt();
        scanner.nextLine();

        String req = "SELECT * FROM typehebergement WHERE id_type_hebergement = ?";
        PreparedStatement ps = con.prepareStatement(req);
        ps.setInt(1, ID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            TypeHebergement typeHebergement = new TypeHebergement(
                    rs.getInt("id_type_hebergement"),
                    rs.getString("type_hebergement"));
            typeHebergements.add(typeHebergement);
        }
        if(typeHebergements.isEmpty()){
            System.out.println("Le hebergement n'existe pas");
        }
        return typeHebergements;

    }

}
