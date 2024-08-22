-- Création de la table pour les produits d'animaux
CREATE TABLE ProduitsAnimaux (
                                 id INT AUTO_INCREMENT PRIMARY KEY,
                                 nom VARCHAR(100) NOT NULL,
                                 description TEXT,
                                 quantiteDisponible INT NOT NULL,
                                 prix DOUBLE NOT NULL,
                                 imageUrl VARCHAR(255)
);

-- Créer la table TypeAnimal
CREATE TABLE TypeAnimal (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            nom VARCHAR(50) NOT NULL,
                            description VARCHAR(255) NOT NULL,
                            quantiteDisponible INT NOT NULL,
                            prixAnimal DOUBLE NOT NULL,
                            imageUrl VARCHAR(255),
                            type VARCHAR(50) NOT NULL  -- Nouvelle colonne ajoutée
);
