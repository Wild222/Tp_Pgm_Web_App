package persistence;

public class SQL_BOX {
    //Client
    public static final String AJOUTER_CLIENT = "INSERT INTO Client (nom, prenom, courriel) VALUES (?, ?, ?)";

    //Type Animal
    public static final String AFFICHER_TOUT_TYPE_ANIMAL = "SELECT * FROM TypeAnimal order by type asc";

    public static final String RECHERCHER_TYPE_ANIMAL_PAR_PRIX = "SELECT * FROM TypeAnimal WHERE prixAnimal <= ?";

    public static final String RECHERCHER_TYPE_ANIMAL_PAR_ID = "SELECT * FROM TypeAnimal WHERE id = ?";

    public static final String UPDATE_TYPE_ANIMAL_QUANTITER_BY_ID = "UPDATE TypeAnimal SET quantiteDisponible = ? WHERE id = ?";

    public static final String GET_QUANTITER_DISPONIBLE_BY_ID = "SELECT quantiteDisponible FROM TypeAnimal WHERE id = ?";
}
