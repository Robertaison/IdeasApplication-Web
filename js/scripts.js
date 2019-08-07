
// getAllElements
async function getElements(){
	const res = await fetch('https://sharing-thoughts.herokuapp.com');
	const data = await res.json();
	
	createBaloon(data);

	var btnBaloons = document.getElementsByClassName("baloon-modal")
	Array.from(btnBaloons).map(btn => {
		btn.onclick = () => {
			getElementsById(btn.dataset.baloon);
			modalBaloon.style.display = "block";
		}
	})
	
}


getElements();

// PO TSON AQUI



async function getElementsById(id) {
	try {
        const res = await fetch(`http://localhost:8080/${id}`);
        const data = await res.json();
		
		const modalHeader = document.getElementById("title-modal");
		modalHeader.innerHTML = data.title;
        const input = document.getElementById("title-thought");
        input.placeholder = data.title;   
        const inputDescription = document.getElementById("description-thought");
		inputDescription.placeholder = data.description;
		const inputId = document.getElementById('hidden-id');
		inputId.value = id;
    } catch (error) {
        alert('Falha ao conectar com o banco!')
    }
}


const form = document.getElementById('formulario');
form.addEventListener('submit', e => {
	const title = document.getElementById('title').value;
	const humor = document.getElementById('humorPost').value;
	const description = document.getElementById('description').value;
    
    const data = { title, description, humor };
	
	post(data);
    getElements();
    modal.style.display = 'none';
    e.preventDefault();
});

function post(data) {
    try {
		fetch('https://sharing-thoughts.herokuapp.com', {
			method: 'POST',
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(data)
        });
        alert('Pronto! Obrigado por colaborar!');
    } catch (error) {
        alert('Falha ao conectar com o banco!', error);
    }
}

const deletar = document.getElementById('delete');
deletar.onclick = function (e){
	const id = document.getElementById('hidden-id').value;
	deleteData(id);
    getElements();
	e.preventDefault;
}

function deleteData(id) {
	return fetch(`http://localhost:8080/${id}`, {
	  method: 'delete'
	})
	.then(response => response.json());
}

function updateId(id) {
	try{
		fetch(`http://localhost:8080/${id}`, {
			method: 'PATCH',
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(data)
        });
        alert('Alterações feitas com sucesso');
	}catch{
		alert('Não foi possível fazer alterações');
	}
}
// ATE AQUI HEM


// Get the modal
var modal = document.getElementById('myModal');
var modalBaloon = document.getElementById('myBaloonModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close");

// When the user clicks on the button, open the modal 
btn.onclick = function() {
	modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
Array.from(span).map((s) => {
		s.onclick = function() {
		modal.style.display = "none";
		modalBaloon.style.display = "none";
	}
})

// When the user clicks anywhere outside of the modal, close it
modal.onclick = function(event) {
    const content = modal.querySelector('.modal-content');
    
	if (event.target !== content && !content.contains(event.target)) {
		modal.style.display = "none";
	}
}

modalBaloon.onclick = function(event) {
    const content = modalBaloon.querySelector('.modal-content');
    
	if (event.target !== content && !content.contains(event.target)) {
		modalBaloon.style.display = "none";
	}
}

function createBaloon(data){
	const listComponent = data.map((item) => {
		 return (
			`<div class="baloon">
            	<div class="baloon-content">            
					<h1 class="baloon-title">${item.title}</h1>
					<p id="thought-data">${item.data}</p> 
                	<p class="baloon-description">${item.description}</p>
            	</div>
       		</div>`
		 )
		}).join('')
	
	const element = document.getElementById('thought');
	element.innerHTML = listComponent;
}





