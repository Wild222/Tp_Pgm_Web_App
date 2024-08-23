
INSERT INTO TypeAnimal (nom, description, quantiteDisponible, prixAnimal, imageUrl) VALUES
                                                                                 ('Chien', 'M', 10, 200.0, 'http://localhost:8080/TP_Pgm_Web_App-1.0-SNAPSHOT/images/labradorR.jpeg'),
                                                                                 ('Chat', 'F', 15, 150.0, 'http://localhost:8080/TP_Pgm_Web_App-1.0-SNAPSHOT/images/chat1.jpg'),
                                                                                 ('Cheval', 'M', 5, 1000.0, 'http://localhost:8080/TP_Pgm_Web_App-1.0-SNAPSHOT/images/cheval1.jpg'),
                                                                                 ('Oiseau', 'F', 20, 50.0, 'http://localhost:8080/TP_Pgm_Web_App-1.0-SNAPSHOT/images/perroquet.jpg'),
                                                                                 ('Hamster', 'F', 25, 56.34, 'http://localhost:8080/TP_Pgm_Web_App-1.0-SNAPSHOT/images/hamster1.jpg'),
                                                                                 ('Cobbaye', 'M', 8, 44.32, 'http://localhost:8080/TP_Pgm_Web_App-1.0-SNAPSHOT/images/cobbaye.jpg');


INSERT INTO TypeAnimal (nom, description, quantiteDisponible, prixAnimal, imageUrl, type) VALUES
-- 4 Chats avec des noms personnalisés
('Mimi', 'Animal de compagnie indépendant et joueur.', 4, 150.00, 'http://localhost:8080/TP_Pgm_Web_App-1.0-SNAPSHOT/images/chat1.jpg', 'Chat'),
('Minou', 'Animal de compagnie affectueux et curieux.', 4, 150.00, 'http://localhost:8080/TP_Pgm_Web_App-1.0-SNAPSHOT/images/chat2.jpeg', 'Chat'),
('Choupette', 'Chat câlin et joueur.', 4, 150.00, 'http://localhost:8080/TP_Pgm_Web_App-1.0-SNAPSHOT/images/chat3.jpeg', 'Chat'),
('Félix', 'Chat malin et agile.', 4, 150.00, 'http://localhost:8080/TP_Pgm_Web_App-1.0-SNAPSHOT/images/chat4.jpeg', 'Chat'),

-- 4 Chevaux avec des noms personnalisés
('Pégase', 'Animal de travail et de loisir, idéal pour l’équitation.', 4, 1200.00, 'http://localhost:8080/TP_Pgm_Web_App-1.0-SNAPSHOT/images/cheval1.jpg', 'Cheval'),
('Star', 'Cheval rapide et élégant.', 4, 1200.00, 'http://localhost:8080/TP_Pgm_Web_App-1.0-SNAPSHOT/images/cheval2.jpeg', 'Cheval'),
('Comète', 'Cheval fidèle et brave.', 4, 1200.00, 'http://localhost:8080/TP_Pgm_Web_App-1.0-SNAPSHOT/images/cheval3.jpeg', 'Cheval'),
('Foudre', 'Cheval plein d’énergie.', 4, 1200.00, 'http://localhost:8080/TP_Pgm_Web_App-1.0-SNAPSHOT/images/cheval4.jpeg', 'Cheval'),

-- 5 Chiens avec des noms personnalisés
('Rex', 'Chien loyal et protecteur.', 5, 300.00, 'http://localhost:8080/TP_Pgm_Web_App-1.0-SNAPSHOT/images/chien1.jpg', 'Chien'),
('Buddy', 'Chien amical et joueur.', 5, 300.00, 'http://localhost:8080/TP_Pgm_Web_App-1.0-SNAPSHOT/images/chien2.jpeg', 'Chien'),
('Bella', 'Chienne affectueuse et douce.', 5, 300.00, 'http://localhost:8080/TP_Pgm_Web_App-1.0-SNAPSHOT/images/chien3.jpeg', 'Chien'),
('Max', 'Chien intelligent et curieux.', 5, 300.00, 'http://localhost:8080/TP_Pgm_Web_App-1.0-SNAPSHOT/images/chien4.jpeg', 'Chien'),
('Luna', 'Chienne joyeuse et pleine d’énergie.', 5, 300.00, 'http://localhost:8080/TP_Pgm_Web_App-1.0-SNAPSHOT/images/chien5.jpeg', 'Chien'),

-- 3 Hamsters avec des noms personnalisés
('Nibbles', 'Petit rongeur domestique, parfait pour les enfants.', 3, 20.00, 'http://localhost:8080/TP_Pgm_Web_App-1.0-SNAPSHOT/images/hamster1.jpg', 'Rongeur'),
('Fuzzy', 'Hamster curieux et affectueux.', 3, 20.00, 'http://localhost:8080/TP_Pgm_Web_App-1.0-SNAPSHOT/images/hamster2.jpg', 'Rongeur'),
('Pip', 'Hamster joueur et énergique.', 3, 20.00, 'http://localhost:8080/TP_Pgm_Web_App-1.0-SNAPSHOT/images/hamster3.jpeg', 'Rongeur'),

-- 2 Lapins avec des noms personnalisés
('Bunny', 'Lapin doux et affectueux.', 2, 40.00, 'http://localhost:8080/TP_Pgm_Web_App-1.0-SNAPSHOT/images/lapin1.jpeg', 'Rongeur'),
('Câlin', 'Lapin sociable et joueur.', 2, 40.00, 'http://localhost:8080/TP_Pgm_Web_App-1.0-SNAPSHOT/images/lapin2.jpeg', 'Rongeur'),

-- 3 Oiseaux avec des noms personnalisés
('Chirp', 'Oiseau chanteur coloré et joyeux.', 3, 50.00, 'http://localhost:8080/TP_Pgm_Web_App-1.0-SNAPSHOT/images/oiseau1.jpeg', 'Oiseau'),
('Sunny', 'Oiseau lumineux et énergique.', 3, 50.00, 'http://localhost:8080/TP_Pgm_Web_App-1.0-SNAPSHOT/images/oiseau2.jpg', 'Oiseau'),
('Tweet', 'Oiseau amical et bavard.', 3, 50.00, 'http://localhost:8080/TP_Pgm_Web_App-1.0-SNAPSHOT/images/oiseau3.jpg', 'Oiseau');
