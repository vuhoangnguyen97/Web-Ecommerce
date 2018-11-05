function bt1() {
    var txt = document.getElementById("txtsp");
    var txt1 = document.getElementById("txtsp1");
    var txt2 = document.getElementById("txtsp2");
    var txt3 = document.getElementById("txtsp3");
    var txt4 = document.getElementById("txtsp4");
    var txt5 = document.getElementById("txtsp5");
    var txt6 = document.getElementById("txtsp6");
    var txt7 = document.getElementById("txtsp7");
    var txt8 = document.getElementById("txtsp8");
    var save = document.getElementById("btsave");
    var edit = document.getElementById("btfix");
    var modal = document.getElementById("myModal");
    
    modal.style.display = "none";

    if(txt.disabled == true && txt1.disabled == true && txt2.disabled == true && txt3.disabled == true && txt4.disabled == true && txt5.disabled == true && txt6.disabled == true && txt7.disabled == true && txt8.disabled == true)
    {
        txt.disabled = false;
        txt1.disabled = false;
        txt2.disabled = false;
        txt3.disabled = false;
        txt4.disabled = false;
        txt5.disabled = false;
        txt6.disabled = false;
        txt7.disabled = false;
        txt8.disabled = false;
       
    }
    else if(txt.disabled == false && txt1.disabled == false && txt2.disabled == false && txt3.disabled == false && txt4.disabled == false && txt5.disabled == false && txt6.disabled == false && txt7.disabled == false && txt8.disabled == false)
    {
        txt.disabled = true;
        txt1.disabled = true;
        txt2.disabled = true;
        txt3.disabled = true;
        txt4.disabled = true;
        txt5.disabled = true;
        txt6.disabled = true;
        txt7.disabled = true;
        txt8.disabled = true;

    }


}

function bt() {
    var save = document.getElementById("btsave");
    var edit = document.getElementById("btfix");

    save.style.display = "block";
}


function luu2() {
    var txt = document.getElementById("txtsp");
    var txt1 = document.getElementById("txtsp1");
    var txt2 = document.getElementById("txtsp2");
    var txt3 = document.getElementById("txtsp3");
    var txt4 = document.getElementById("txtsp4");
    var txt5 = document.getElementById("txtsp5");
    var txt6 = document.getElementById("txtsp6");
    var txt7 = document.getElementById("txtsp7");
    var txt8 = document.getElementById("txtsp8");
    var save = document.getElementById("btsave");
    var edit = document.getElementById("btfix");

    if(txt.disabled == false && txt1.disabled == false && txt2.disabled == false && txt3.disabled == false && txt4.disabled == false && txt5.disabled == false && txt6.disabled == false && txt7.disabled == false && txt8.disabled == false)
    {
        txt.disabled = true;
        txt1.disabled = true;
        txt2.disabled = true;
        txt3.disabled = true;
        txt4.disabled = true;
        txt5.disabled = true;
        txt6.disabled = true;
        txt7.disabled = true;
        txt8.disabled = true;

    }
}


function luu() {
    var save = document.getElementById("btsave");
    var edit = document.getElementById("btfix");

    edit.style.display = "none";
    Function.bt1;
}


function show() {
    var modal = document.getElementById("myModal");
    var yes = document.getElementById("yes");
    var no = document.getElementById("no");
    var them = document.getElementById("btthem");

    modal.style.display = "block";

}

function show1() {
    var modal = document.getElementById("myModal");
    var modal1 = document.getElementById("myModal1");
    var yes = document.getElementById("yes");
    var no = document.getElementById("no");
    var them = document.getElementById("btthem");

    modal1.style.display = "block";

}

function dong() {
    var modal = document.getElementById("myModal");

    modal.style.display = "none";

}

function dong1() {
    var modal1 = document.getElementById("myModal1");

    modal1.style.display = "none";

}





