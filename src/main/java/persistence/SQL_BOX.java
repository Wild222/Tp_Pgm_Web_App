package persistence;

public class SQL_BOX {
//Produit Animal
    public static final String RECHERCHER_PRODUIT_PAR_ID = "SELECT * FROM PRODUIT_ANIMAL WHERE id = ?";

    public static final String AFFICHER_TOUT_PRODUIT_ANIMAL = "SELECT * FROM PRODUIT_ANIMAL";

    public static final String RECHERCHER_PRODUIT_ANIMAL_BY_ID = "SELECT * FROM PRODUIT_ANIMAL WHERE id = ?";

    public static final String INSERT_PRODUIT_ANIMAL = "INSERT INTO PRODUIT_ANIMAL (nom, description, prix, quantite) VALUES (?, ?, ?, ?)";

    public static final String MODIFIER_PRODUIT_ANIMAL = "UPDATE PRODUIT_ANIMAL SET nom = ?, description = ?, prix = ?, quantite = ? WHERE id = ?";

    public static final String SUPPRIMER_PRODUIT_ANIMAL = "DELETE FROM PRODUIT_ANIMAL WHERE id = ?";

    //Type Animal
    public static final String AFFICHER_TOUT_TYPE_ANIMAL = "SELECT * FROM TYPE_ANIMAL";

    public static final String RECHERCHER_TYPE_ANIMAL_PAR_NOM = "SELECT * FROM TYPE_ANIMAL WHERE nom = ?";

    public static final String AJOUTER_TYPE_ANIMAL = "INSERT INTO TYPE_ANIMAL (nom) VALUES (?)";

    public static final String SUPPRIMER_TYPE_ANIMAL_PAR_NOM = "DELETE FROM TYPE_ANIMAL WHERE nom = ?";

    public static final String MODIFIER_PRIX_ANIMAL = "UPDATE TYPE_ANIMAL SET nom = ? WHERE nom = ?";
}
