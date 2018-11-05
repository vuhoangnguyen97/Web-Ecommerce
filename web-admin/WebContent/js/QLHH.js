var modal = document.getElementById('myModal');
var bt = document.getElementById("btthem");
var span = document.getElementsByClassName("close")[0];


bt.onclick = function(){
    modal.style.display = "block";
}

span.onclick = function(){
    modal.style.display = "none";
}

window.onclick = function(){
    if(event.target == modal){
        modal.style.display = "none";
    }
}




