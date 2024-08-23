package persistence;

public class SQL_BOX {
    //Client
    public static final String AJOUTER_CLIENT = "INSERT INTO Client (nom, prenom, courriel) VALUES (?, ?, ?)";
    //Type Animal
    public static final String AFFICHER_TOUT_TYPE_ANIMAL = "SELECT * FROM TypeAnimal order by type asc";

    public static final String RECHERCHER_TYPE_ANIMAL_PAR_NOM = "SELECT * FROM TypeAnimal WHERE nom = ?";

    public static final String AJOUTER_TYPE_ANIMAL = "INSERT INTO TypeAnimal (nom) VALUES (?)";

    public static final String SUPPRIMER_TYPE_ANIMAL_PAR_NOM = "DELETE FROM TypeAnimal WHERE nom = ?";

    public static final String MODIFIER_PRIX_ANIMAL = "UPDATE TypeAnimal SET nom = ? WHERE nom = ?";

    public  static final String RECHERCHER_PRIX_TYPE_ANIMAL_PAR_ID = "SELECT prixAnimal, nom, sexe FROM TypeAnimal WHERE id = ?";

    public static final String RECHERCHER_TYPE_ANIMAL_PAR_ID = "SELECT * FROM TypeAnimal WHERE id = ?";

    public static final String UPDATE_TYPE_ANIMAL_QUANTITER_BY_ID = "UPDATE TypeAnimal SET quantiteDisponible = ? WHERE id = ?";

    public static final String GET_QUANTITER_DISPONIBLE_BY_ID = "SELECT quantiteDisponible FROM TypeAnimal WHERE id = ?";
}
