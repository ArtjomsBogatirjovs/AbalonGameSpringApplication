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

var c,ctx;

//onload=createGame;

//function to generate random circle parameters, x,y and radius

function randomize(){
    let rowCircles = 5;
    for (var i = 0; i < 61; i++) {
        c = document.getElementById("canvas");
        ctx = c.getContext("2d");
        var rr = 77.942 / 2 ;
        var rx = rr + rr * i * 2;
        var ry = rr;
        setTimeout(drawCircle(rx,ry,rr),1000);
    }
}
function drawCircle(rx,ry,rr){
    var myColors  =["blue","red","green","yellow"];
    var colorPicker = Math.ceil(4* Math.random() -1);
    ctx.strokeStyle = myColors[colorPicker];
    ctx.beginPath();
    ctx.arc(rx,ry,rr,0,2*Math.PI);
    ctx.stroke();
    ctx.closePath();
}