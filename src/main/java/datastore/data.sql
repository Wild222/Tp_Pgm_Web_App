INSERT INTO ProduitsAnimaux (nom, description, quantiteDisponible, prix) VALUES
                                                                             ('Croquettes pour chiens', 'Croquettes premium pour chiens adultes.', 500, 29.99),
                                                                             ('Litière pour chat', 'Litière agglomérante pour chat .', 300, 12.50),
                                                                             ('Collier anti-puces', 'Collier répulsif contre les puces et les tiques pour chiens et chats.', 150, 19.99),
                                                                             ('Jouet pour chat', 'Jouet interactif pour chats.', 200, 8.99),
                                                                             ('Harnais pour chien', 'Harnais ajustable pour chiens .', 120, 15.75),
                                                                             ('Nourriture pour poissons', 'Aliments en flocons pour poissons.', 400, 5.99),
                                                                             ('Cage pour rongeurs', 'Cage avec accessoires pour hamsters et gerbilles.', 50, 39.95),
                                                                             ('Shampoing pour chien', 'Shampoing pour chiens.', 180, 11.49),
                                                                             ('Terrarium pour reptiles', 'Terrarium en verre pour reptiles avec éclairage LED intégré.', 30, 89.99),
                                                                             ('Litière pour rongeurs', 'Litière biodégradable pour lapins.', 100, 14.25);

INSERT INTO TypeAnimal (nom, sexe, prixAnimal) VALUES
                                                   ('chien', 'M', 200.0),
                                                   ('chat', 'F', 150.0),
                                                   ('cheval', 'M', 1000.0),
                                                   ('oiseau', 'F', 50.0);

select * from ProduitsAnimaux