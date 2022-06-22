function iniciar(){
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        console.log(this.responseText)
        document.getElementById("juego").style.display="block";
        document.getElementById("iniciar").style.display="none";
    }
    xhttp.open("GET", "/start");
    xhttp.send()
}

function comparar(intento){
    const intentos = "linea"+intento;
    const linea = document.getElementById(intentos)
    const classLine = linea.getElementsByClassName("inputNumber")
    const valor = classLine[0].value+classLine[1].value+classLine[2].value+classLine[3].value
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        intento++;
        document.getElementById(intentos).getElementsByClassName("res")[0].innerHTML=this.responseText;
        if(this.responseText.startsWith("Has Ganado!")){
            classLine[0].disabled =true;classLine[1].disabled =true;classLine[2].disabled =true;classLine[3].disabled =true;
            document.getElementById("submit").style.display="none";
            document.getElementById("retry").style.display="block";
        } else {
            if(intento<5){
                document.getElementById("linea"+intento).style.display="block";
            } else{
                document.getElementById(intentos).getElementsByClassName("res")[0].innerHTML="No tienes más intentos, Perdiste";
                document.getElementById("submit").style.display="none";
                document.getElementById("retry").style.display="block";
            }
            classLine[0].disabled =true;classLine[1].disabled =true;classLine[2].disabled =true;classLine[3].disabled =true;
        }
    }
    xhttp.open("GET", "/comparacion?numero="+ valor);
    xhttp.send()
}

function intento(){
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        comparar(this.responseText)
    }
    xhttp.open("GET", "/intentosNum");
    xhttp.send()
}