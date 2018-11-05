function changeFunc() {
    var selectBox = document.getElementById("hang");
    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
    window.open(selectedValue);
}

function reset() {
    var form = document.getElementById("fChat");

    form.reset();
}

function on(){
	var modal =  document.getElementById("fMess");

	if(modal.style.display == "none")
		modal.style.display = "block";
	else
		modal.style.display = "none";
}


function xoa(){
    var modal = document.getElementById("myModal");

    modal.style.display = "block";
}


function dong() {
    var modal = document.getElementById("myModal");

    modal.style.display = "none";

}