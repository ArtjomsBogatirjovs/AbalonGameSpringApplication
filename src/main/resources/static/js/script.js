let isCreated = false;
function createGame() {
    if(isCreated){
        return;
    }
    let ul = document.getElementById('gameBoard');
    let li;
    for (let i = 1; i <= 50; ++i) {
        li = document.createElement('li'); // create a new list item
        li.className = 'tic';
        li.id = "" + i;
        ul.appendChild(li); // append the list item to the ul
    }
    isCreated = true;
}