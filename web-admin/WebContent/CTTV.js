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
    var txt9 = document.getElementById("txtsp9");
    var txt10 = document.getElementById("txtsp10");
    var txt11 = document.getElementById("txtsp11");
    var txt12 = document.getElementById("txtsp12");
    var save = document.getElementById("btsave");
    var edit = document.getElementById("btfix");
    if(txt.disabled == true && txt1.disabled == true && txt2.disabled == true && txt3.disabled == true && txt4.disabled == true && txt5.disabled == true && txt7.disabled == true && txt8.disabled == true && txt9.disabled == true && txt10.disabled == true && txt11.disabled == true && txt12.disabled == true)
    {
        txt.disabled = false;
        txt1.disabled = false;
        txt2.disabled = false;
        txt3.disabled = false;
        txt4.disabled = false;
        txt5.disabled = false;
        //txt6.disabled = false;
        txt7.disabled = false;
        txt8.disabled = false;
        txt9.disabled = false;
        txt10.disabled = false;
        txt11.disabled = false;
        txt12.disabled = false;
       
    }
    else if(txt.disabled == false && txt1.disabled == false && txt2.disabled == false && txt3.disabled == false && txt4.disabled == false && txt5.disabled == false && txt7.disabled == false && txt8.disabled == false && txt9.disabled == false && txt10.disabled == false && txt11.disabled == false && txt12.disabled == false)
    {
        txt.disabled = true;
        txt1.disabled = true;
        txt2.disabled = true;
        txt3.disabled = true;
        txt4.disabled = true;
        txt5.disabled = true;
        //txt6.disabled = true;
        txt7.disabled = true;
        txt8.disabled = true;
        txt9.disabled = true;
        txt10.disabled = true;
        txt11.disabled = true;
        txt12.disabled = true;

    }

    


}