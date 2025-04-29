package entities;

public class TypeHebergement {
    private int id_type_hebergement;
    private String type_hebergement;

    public TypeHebergement() {}

    public TypeHebergement(int id_type_hebergement, String type_hebergement) {
        this.id_type_hebergement = id_type_hebergement;
        this.type_hebergement = type_hebergement;
    }

    public int getId_type_hebergement() {
        return id_type_hebergement;
    }
    public void setId_type_hebergement(int id_type_hebergement) {
        this.id_type_hebergement = id_type_hebergement;
    }
    public String getType_hebergement() {
    return type_hebergement;
    }
    public void setType_hebergement(String type_hebergement) {
        this.type_hebergement = type_hebergement;
    }

    @Override
    public String toString() {
        return "TypeHebergement{" +
                "id_type_hebergement=" + id_type_hebergement +
                ", type_hebergement='" + type_hebergement + '\'' +
                '}';
    }
}
