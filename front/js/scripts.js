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

async function getElements(){
  const res = await fetch('http://localhost:8080/');
  const data = await res.json();
  const dados = data[1].description;

  var teste = document.getElementById("aqui");
  var a = document.createTextNode(dados);
  teste.appendChild(a);
}

async function getElementsById(){
    const res = await fetch('http://localhost:8080/2');
    const data = await res.json();
    const dados = data;
    
    console.log(dados);
    // var teste = document.getElementById("aqui");
    // var a = document.createTextNode(dados);
    // teste.appendChild(a);
}

function myFunction() {
    modal.style.display = "block";
}

getElementsById();
getElements();

// // Get the modal
// var modal = document.getElementById('myModal');

// // Get the button that opens the modal
// var btn = document.getElementById("myBtn");

// // Get the <span> element that closes the modal
// var span = document.getElementsByClassName("close")[0];

// var aqui = document.getElementById("aqui");
// aqui.appendChild(getElements);

// // When the user clicks on the button, open the modal 
// btn.onclick = function() {
//     modal.style.display = "block";
// }

// // When the user clicks on <span> (x), close the modal
// span.onclick = function() {
//     modal.style.display = "none";
// }

// // When the user clicks anywhere outside of the modal, close it
// window.onclick = function(event) {
//     if (event.target == modal) {
//         modal.style.display = "none";
//     }
// }

// //modal auto-expand
// $(document)
//     .one('focus.autoExpand', 'textarea.autoExpand', function(){
//         var savedValue = this.value;
//         this.value = '';
//         this.baseScrollHeight = this.scrollHeight;
//         this.value = savedValue;
//     })
//     .on('input.autoExpand', 'textarea.autoExpand', function(){
//         var minRows = this.getAttribute('data-min-rows')|0, rows;
//         this.rows = minRows;
//         rows = Math.ceil((this.scrollHeight - this.baseScrollHeight) / 16);
//         this.rows = minRows + rows;
//     });