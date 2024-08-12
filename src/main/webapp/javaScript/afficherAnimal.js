document.addEventListener('DOMContentLoaded', function() {
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
});