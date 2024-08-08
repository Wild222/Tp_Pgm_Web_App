package service;

import model.TypeAnimal;
import persistence.TypeAnimalDAO_JDBC;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class PanierService {
    private TypeAnimalDAO_JDBC typeAnimalDAO;

    public PanierService(Connection connection) {
        this.typeAnimalDAO = new TypeAnimalDAO_JDBC(connection);
    }

    public double calculateTotalAmount(Map<Integer, Integer> panier) {
        double totalAmount = 0.0;

        for (Map.Entry<Integer, Integer> entry : panier.entrySet()) {
            int animalId = entry.getKey();
            int quantity = entry.getValue();
            TypeAnimal animal = typeAnimalDAO.getTypeAnimalById(animalId);

            if (animal != null) {
                totalAmount += animal.getPrixAnimal() * quantity;
            }
        }

        return totalAmount;
    }

    public int calculateTotalQuantity(Map<Integer, Integer> panier) {
        int totalQuantity = 0;

        for (int quantity : panier.values()) {
            totalQuantity += quantity;
        }

        return totalQuantity;
    }
}
