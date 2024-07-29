package model;

public class ProduitAnimal {
    private int id; 
    private String nom;
    private String description;
    private int quantite;
    private double prix;


    // Constructeur par défaut
    public ProduitAnimal() {
    }

    // Constructeur avec paramètres
    public ProduitAnimal( String nom, String description, int quantite,double prix) {
        this.nom = nom;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;

    }

    // Getters et Setters
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    // Méthode toString pour l'affichage
    @Override
    public String toString() {
        return "ProduitAnimal{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                ", quantite=" + quantite +
                '}';
    }
}
