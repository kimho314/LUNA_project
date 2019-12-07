window.addEventListener("load", function () {
    var btnPrint = document.getElementById("btn-print");

    btnPrint.onclick = function () {
        var x, y;
        x = parseInt(prompt("input x value"));
        y = parseInt(prompt("input y value"));
        btnPrint.value = x + y;        
    };
});