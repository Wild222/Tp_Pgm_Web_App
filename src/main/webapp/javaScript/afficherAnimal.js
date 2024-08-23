/*document.addEventListener('DOMContentLoaded', function() {
    var btnAnimals = document.getElementsByClassName('btnAnimal'); // Single variable for clarity
    var counterSpan = document.getElementById('basketCounter');

    // Iterate over each button in the collection
    for(var i = 0; i < btnAnimals.length; i++) {
        var btn = btnAnimals[i];
        btn.addEventListener('click', function() { // Attach event listener to each button individually
            var currentCount = parseInt(counterSpan.textContent);
            counterSpan.textContent = currentCount + 1; // Increment the counter
        });
    }
});*/

// Récupérer tous les boutons et le compteur
var btnAnimals = document.querySelectorAll('.quantity-button button'); // Assurez-vous que votre sélecteur correspond aux boutons
var counterSpan = document.getElementById('basket-counter'); // Assurez-vous que l'ID de votre compteur est correct

// Initialiser le compteur à partir de la quantité existante, si nécessaire
let totalQuantity = parseInt(counterSpan.textContent) || 0;

// Fonction pour mettre à jour le compteur
function updateCounter(amount) {
    totalQuantity += amount; // Ajouter ou soustraire la quantité
    counterSpan.textContent = totalQuantity; // Mettre à jour l'affichage du compteur
}

// Itérer sur chaque bouton
for (var i = 0; i < btnAnimals.length; i++) {
    var btn = btnAnimals[i];

    // Vérifier le type de bouton (ajouter ou supprimer) par son nom
    btn.addEventListener('click', function(event) {
        var buttonType = event.target.name; // Récupérer le nom du bouton ("ajouter" ou "supprimer")

        if (buttonType === 'ajouter') {
            updateCounter(1); // Incrémente le compteur de 1
        } else if (buttonType === 'supprimer') {
            updateCounter(-1); // Décrémente le compteur de 1
        }
    });
}