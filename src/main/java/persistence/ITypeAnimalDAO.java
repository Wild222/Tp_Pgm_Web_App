package persistence;

import model.TypeAnimal;

import java.util.List;

public interface ITypeAnimalDAO {
    List<TypeAnimal> afficherTypeAnimal();
    TypeAnimal rechercherTypeAnimal(String nom);
    void ajouterTypeAnimal(TypeAnimal typeAnimal);
    void supprimerTypeAnimal(String nom);
    void modifierTypeAnimal(TypeAnimal typeAnimal);
    TypeAnimal getTypeAnimalById(int i);

}

