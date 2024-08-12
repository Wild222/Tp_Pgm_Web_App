package model;

public class PanierItem {
    private int id;
    private int quantite;


    public PanierItem(int id, int quantite) {
        this.id = id;
        this.quantite = quantite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

}
