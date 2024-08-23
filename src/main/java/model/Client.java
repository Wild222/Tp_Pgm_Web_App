package model;

public class Client {

    private String nom;
    private String prenom;
    private String courriel;

    // Constructeur par défaut
    public Client() {
    }

    // Constructeur avec paramètres
    public Client(String nom, String prenom, String courriel) {
        this.nom = nom;
        this.prenom = prenom;
        this.courriel = courriel;
    }

    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    // Méthode toString pour affichage
    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", courriel='" + courriel + '\'' +
                '}';
    }
}
