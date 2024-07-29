<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - TP2-PROGRAMMATIONS APPS WEB</title>
    <title>Accueuil</title>
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

<a href="control/testServlet">Hello Servlet</a>
<h1><%= "Bienvenue sur notre site de produits pour animaux" %>
</h1>
    <div align="center">
        <h1>Bienvenue à tous</h1>
        <h3>
            --Vous trouverez sur notre site une gamme de produits pour votre animal de compagnie. <br>
            Pour ceux qui veulent se procurer un animal, vous pourrez voir la galerie d'animaux disponibles.
        </h3>

        </div>

        <form action="afficherAnimal.jsp" name="maFormAnimal">
            <div class="container">
                <img src="images/ima_1.jpeg" width="650" height="350" alt="ima_1"/>
                <div class="text-container">
                    <h3>Animaux en stock :</h3>
                    <ul>
                        <li>Chien</li>
                        <li><a id="chien" href="detailchien" alt = "detailchien">Description</a></li>
                        <li>Chat</li>
                        <li>Cheval</li>
                        <li>Oiseau</li>
                        <li>Hamster</li>
                        <li>Perroquet</li>
                    </ul>
                    <input type="submit" value="Appuyer ICI" name="typeAnimal" />
                </div>
            </div>
        </form>

        <form action="JSP/afficherProduit.jsp" name="maFormProduit">
            <div class="container-reverse">
                <img src="images/ima_2.jpeg" width="800" height="350" alt="ima_2"/>
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