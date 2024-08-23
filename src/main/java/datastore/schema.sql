CREATE TABLE Client (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         nom VARCHAR(50) NOT NULL,
                         prenom VARCHAR(50) NOT NULL,
                         courriel VARCHAR(100) NOT NULL UNIQUE
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
