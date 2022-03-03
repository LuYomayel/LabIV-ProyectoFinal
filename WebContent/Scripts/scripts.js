/*let form  = document.getElementById('form');
var select = document.getElementById('Nacionalidad');
form.addEventListener('change', function() {
	form.Provincia.name = 'Provincia='+form.Nacionalidad.value;
    console.log(form.Nacionalidad.value);
    console.log(form.Provincia.name);
    console.log(form.Localidad.value);
    //form.Provincia.value = form.Nacionalidad.value;
});*/

var goToServer= function(){
var idPais=document.getElementById('Nacionalidad').value;
window.location.href='ServletAlumno?'+'ProvinciaListar='+idPais+'&idPais='+idPais;
}
var goToServer1= function(){
	var idPais=document.getElementById('Nacionalidad').value;
	var idProvincia=document.getElementById('Provincia').value;
	window.location.href='ServletAlumno?'+'LocalidadListar='+idProvincia+'&idPais='+idPais;
	}
/*
fetch('http://localhost:8080/ServletAlumno/Agregar=1', {
	  method: 'POST',
	  body: JSON.stringify({ variable: variableAEnviar })
	})
	.then(res => res.json()) // en caso obtengas una respuesta en JSON
	.then(data => console.log(data))
	.catch(err => console.error(err))
*/
var direccionesRoc=new Array();
var direccionesAca=new Array();
direccionesRoc[0]="rock1.htm";
direccionesRoc[1]="rock2.htm";
direccionesAca[0]="barroco.htm";
direccionesAca[1]="sigloxx.htm";
direccionesAca[2]="romantico.htm";
 
function direccion(form){
var selec = form.tipos.options;
var combo = form.estilo.options;
if (selec[1].selected == true){
document.form.action=direccionesRoc[combo.selectedIndex];
}
if (selec[2].selected == true){
form.action=direccionesAca[combo.selectedIndex];
}
 
/*Se puede quitar una vez vemos que funciona*/
alert(form.action);
 
}
 
 
 
function agregarOpciones(form)
{
	console.log('Hola mundo ');
var selec = form.tipos.options;
var combo = form.estilo.options;
combo.length = null;
 
if (selec[0].selected == true)
{
var seleccionar = new Option("Esperando selección");
console.log('Hola mundo 1');
combo[0] = seleccionar;
}
 
if (selec[1].selected == true)
{
	console.log('Hola mundo 2');
var popular1 = new Option("Rock de los 90");
var popular2 = new Option("Rock de los 80");
combo[0] = popular1;
combo[1] = popular2;
}
 
if (selec[2].selected == true)
{
var academica1 = new Option("Musica del Barroco");
var academica2 = new Option("Musica del Siglo XX");
var academica3 = new Option("Música del Romantisismo");
combo[0] = academica1;
combo[1] = academica2;
combo[2] = academica3;
}
}
