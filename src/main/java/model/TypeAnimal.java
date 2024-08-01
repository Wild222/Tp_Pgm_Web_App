package model;

public class TypeAnimal {
    private int id; 
    private String nom;
    private String sexe;
   // private int quantite;
    private double prixAnimal;
    private String imageUrl;

    public TypeAnimal(String nom,  String sexe,double prixAnimal, String imageUrl) {
        this.nom = nom;
        this.sexe = sexe;
        this.prixAnimal = prixAnimal;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public TypeAnimal() {

    }

    @Override
    public String toString() {
        return "TypeAnimal{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", sexe='" + sexe + '\'' +
                ", prixAnimal=" + prixAnimal +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public double getPrixAnimal() {
        return prixAnimal;
    }

    public void setPrixAnimal(double prixAnimal) {
        this.prixAnimal = prixAnimal;
    }

}
