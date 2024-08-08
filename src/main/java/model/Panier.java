package model;

import java.util.HashMap;
import java.util.Map;

public class Panier {
    private Map<Integer, Integer> animauxQuantites; // Map d'ID d'animaux à quantités

    public Panier() {
        animauxQuantites = new HashMap<>();
    }

    public void ajouterAnimal(int animalId, int quantite) {
        animauxQuantites.put(animalId, animauxQuantites.getOrDefault(animalId, 0) + quantite);
    }

    public Map<Integer, Integer> getAnimauxQuantites() {
        return animauxQuantites;
    }

    public boolean estVide() {
        return animauxQuantites.isEmpty();
    }
}
