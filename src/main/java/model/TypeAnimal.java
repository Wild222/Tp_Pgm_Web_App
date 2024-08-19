package model;

public class TypeAnimal {
    private int id;
    private String nom;
    private String sexe;
    private int quantite;
    private int quantiteDisponible;
    private double prixAnimal;
    private String imageUrl;

    public TypeAnimal(int id, String nom, String sexe, int quantite, int quantiteDisponible, double prixAnimal, String imageUrl) {
        this.id = id;
        this.nom = nom;
        this.sexe = sexe;
        this.quantite = quantite;
        this.quantiteDisponible = quantiteDisponible;
        this.prixAnimal = prixAnimal;
        this.imageUrl = imageUrl;
    }

    public TypeAnimal() {
        // Default constructor
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

    public int getQuantiteDisponible() {
        return quantiteDisponible;
    }

    public void setQuantiteDisponible(int quantiteDisponible) {
        this.quantiteDisponible = quantiteDisponible;
    }

    public double getPrixAnimal() {
        return prixAnimal;
    }

    public void setPrixAnimal(double prixAnimal) {
        this.prixAnimal = prixAnimal;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "TypeAnimal{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", sexe='" + sexe + '\'' +
                ", quantiteDisponible=" + quantiteDisponible +
                ", prixAnimal=" + prixAnimal +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
