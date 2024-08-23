function rechercherParPrix() {

    var maxPrice = parseFloat(document.getElementById('priceInput').value);
    if (isNaN(maxPrice)) {
        maxPrice = Infinity; // If the input is not a number, set to Infinity
    }


    var cardItems = document.getElementsByClassName('card');

    for (var i = 0; i < cardItems.length; i++) {
        // Obtenir le prix
        var priceText = cardItems[i].querySelector('.descript-dest').textContent;
        var priceMatch = priceText.match(/Prix:\s*([\d.,]+)\$/);

        var price = priceMatch ? parseFloat(priceMatch[1].replace(',', '.')) : Infinity;
        console.log("Parsed price:", price);

        if (price > maxPrice) {
            cardItems[i].style.display = 'none'; // Hide cards more expensive than maxPrice
        } else {
            cardItems[i].style.display = ''; // Show cards within price range
        }
    }
}
//recherche par noms