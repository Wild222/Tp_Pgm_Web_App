<%-- 
    Document   : UI
    Created on : 15 juil. 2024, 13:09:14
    Author     : gabla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Acceuil</title>
    <style>
        .container {
            display: flex;
            align-items: flex-start;
        }
        .container img {
            margin: 20px;
         
        }
        .text-container {
            max-width: 300px; /* Adjust as needed */
            margin-top: 50px
        }
        .container-reverse {
            display: flex;
            flex-direction: row-reverse;
            align-items: flex-start;
        }
        .container-reverse img {
            margin-left: 20px;
            margin-right: 0;
        }
    </style>
</head>
<body>
<div>

    <div align="center">
        <h1>Bienvenuee à tous</h1>
        <p>
        <h3>
            Vous trouverez sur notre site une gamme de produits pour votre animal de compagnie. <br>
            Pour ceux qui veulent se procurer un animal, vous pourrez voir la galerie d'animaux disponibles.
        </h3>
        <p/>
        <div/>

        <form action="JSP/afficherAnimal.jsp" name="maFormAnimal">
            <div class="container">
                <img src="./image/ima_1.jpeg" width="800" height="350" alt="ima_1"/>
                <div class="text-container">                   
                    <h3>Voici quels types d'animaux seront disponibles pour vous :</h3>
                    <ul>
                        <li>Chien</li>
                        <li>Chat</li>
                        <li>Cheval</li>
                        <li>Oiseau</li>
                    </ul>
                    <input type="submit" value="Appuyer ICI" name="typeAnimal" />
                </div>
            </div>
        </form>

        <form action="controler/afficherProduitServlet" name="maFormProduit">
            <div class="container-reverse">
                <img src="./image/ima_2.jpeg" width="800" height="350" alt="ima_2"/>
                <div class="text-container">                 
                    <h3>Voici quels types de produits seront disponibles pour vous :</h3>
                    <ul>
                        <li>Nourriture pour chien, chat, souris, etc.</li>
                        <li>Collier pour chien, chat, etc.</li>
                        <li>Cage pour chien, chat, souris, etc.</li>
                        <li>Jouet pour chien, chat, souris, etc.</li>
                    </ul>
                    <input type="submit" value="Appuyer ICI" name="typeProduit" />
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
