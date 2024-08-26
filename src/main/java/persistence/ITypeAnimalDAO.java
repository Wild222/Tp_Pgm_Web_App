package persistence;

import model.TypeAnimal;

import java.util.List;

public interface ITypeAnimalDAO {
    List<TypeAnimal> afficherTypeAnimal();
    List<TypeAnimal> rechercherTypeAnimalByPrix(double prixMax);
    TypeAnimal getTypeAnimalById(int i);
    TypeAnimal getQuantiterDisponibleById(int i);
    void updateTypeAnimalQuantiterParId(TypeAnimal typeAnimal,int i);
}

