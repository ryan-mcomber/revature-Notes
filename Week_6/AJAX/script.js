// AJAX, Fetch

//capture the elements we need to grab data from
let pokeId = document.getElementById('poke-id');
let pokemonName = document.getElementById('name');
let renderedId = document.getElementById('id');

// add an event listener to the button, pass a callback function
btn.addEventListener("click",ajaxCall);
//define out callback function
function ajaxCall() {
    //here is where we open up the XMLHttpRequest object to fetch data from a server (or post)
    let idNum = pokeId.value;

    // 1 attain XML request object to send the request
    let xhr = new XMLHttpRequest();

    /**
     * 0. UNSENT: open() method not yet called
     * 1. OPENED: open() method has been called
     * 2. HEADERS_REQUEST: send() method has been called and the headers + status code of the HTTP response are available. 
     * 3. LOADING: downloading the full response from the server
     * 4. DONE: entire operation is complete and now we have a server response.
     */
    xhr.onreadystatechange = function(){
        //check that the ready state is 4 and that the status code is 200
        if (this.readyState ==4 && this.status == 200){
            // if so, grab the data
            let recievedPokemon = JSON.parse(xhr.responseText);

            console.log(recievedPokemon);
            //call the render HTML method and render the recieved JSON
            renderHTML(recievedPokemon);
        }
         
        

    }

    xhr.open("GET", `https://pokeapi.co/api/v2/pokemon/${idNum}`)

    xhr.send();
}

function renderHTML(data){

    pokemonName.innerHTML = "Name: "+data.name;
    renderedId.innerHTML = "ID: " + data.id;

    let image = document.getElementById('sprite');
    image.setAttribute("src",data.sprites.front_default);

    image.setAttribute("height",300);

}