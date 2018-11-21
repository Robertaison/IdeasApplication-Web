// var request = new XMLHttpRequest();

// request.open('GET', 'http://localhost:8080/', true);

// request.onload = function () {

//   // Begin accessing JSON data here
//   var data = JSON.parse(this.response);

//   if (request.status >= 200 && request.status < 400 && request.status != 500) {
//     data.forEach(thought => {
//       console.log(thought.title);
//     });
//   } else {
//     console.log('error');
//   }
// }

// request.send();

// getAllElements
async function getElements(){
	const res = await fetch('http://localhost:8080/');
	const data = await res.json();
	const dados = data[0].description;

	var teste = document.getElementById("aqui");
	var a = document.createTextNode(dados);
	teste.appendChild(a);
}

async function getElementsById(){
	const res = await fetch('http://localhost:8080/2');
	const data = await res.json();
	const dados = data.title;
	var placeHolder = document.createTextNode(dados);

	var titleBaloon = document.getElementById("title").placeholder = placeHolder;
	console.log(placeHolder);
    // var teste = document.getElementById("aqui");
    // var a = document.createTextNode(dados);
    // teste.appendChild(a);
}


var form = document.getElementById('formulario');
form.addEventListener('submit', function(e) {

	var titlePost = document.getElementById('title').value;
	var humorPost = document.getElementById('humorPost');
	var descriptionPost = document.getElementById('description');
	const title = titlePost.value;
	// const options = {title: , description: descriptionPost.value, thumor: humorPost.value};
	
	// post(options);
    // alerta o valor do campo
    alert(title);
    modal.style.display = "none";

    // impede o envio do form
    // e.preventDefault();
});

// function post(objeto){


// 	(async () => {
// 		const rawResponse = await fetch('http://localhost:8080/', {
// 			method: 'POST',
// 			headers: {
// 				'Accept': 'application/json',
// 				'Content-Type': 'application/json'
// 			},
// 			body: JSON.stringify(objeto)
// 		});
// 		const content = await rawResponse.json();

// 		console.log(content);
// 	})();
// }
getElements();

// Get the modal
var modal = document.getElementById('myModal');
var modalBaloon = document.getElementById('myBaloonModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");
var btnBaloon = document.getElementById("baloonModal");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal 
btn.onclick = function() {
	modal.style.display = "block";
}

btnBaloon.onclick = function(){
	getElementsById();
	modalBaloon.style.display = "block";
	
}
// When the user clicks on <span> (x), close the modal
span.onclick = function() {
	modal.style.display = "none";
	modalBaloon.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
	if (event.target == modal) {
		modal.style.display = "none";
		modalBaloon.style.display = "none";
	}
}

//modal auto-expand
(document)
.one('focus.autoExpand', 'textarea.autoExpand', function(){
	var savedValue = this.value;
	this.value = '';
	this.baseScrollHeight = this.scrollHeight;
	this.value = savedValue;
})
.on('input.autoExpand', 'textarea.autoExpand', function(){
	var minRows = this.getAttribute('data-min-rows')|0, rows;
	this.rows = minRows;
	rows = Math.ceil((this.scrollHeight - this.baseScrollHeight) / 16);
	this.rows = minRows + rows;
});