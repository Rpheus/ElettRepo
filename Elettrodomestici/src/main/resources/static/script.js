document.addEventListener("DOMContentLoaded", function () {

    const form = document.querySelector("form");

    const loginLink = document.getElementById("login-link");
    const profileLink = document.getElementById("profile-link");
    const dropdownContent = profileLink.querySelector(".dropdown-content");
    const loggedInContent = document.getElementById("logged-in-content");
    const loggedInName = document.getElementById("logged-in-name");
    const logoutButton = document.getElementById("logout-button");

    const infoIcon = document.getElementById("info-icon");
    const infoDiv = document.getElementById("info-div");

    // Definisci le tue email e password predefinite
    var emailPredefinita = "a@gmail.com";
    var passwordPredefinita = "123";

    // Aggiungi un gestore di eventi per l'icona "i"
    infoIcon.addEventListener("click", function () {
        if (infoDiv.style.display === "none" || infoDiv.style.display === "") {
            infoDiv.style.display = "block";
        } else {
            infoDiv.style.display = "none";
        }
    });

    form.addEventListener("submit", function (event) {
        event.preventDefault();
        document.getElementById("hide").removeAttribute("hidden");
        // Otteniamo i valori inseriti dall'utente
        const email = document.getElementById("email").value;
        const nome = document.getElementById("nome").value;
        const cognome = document.getElementById("cognome").value;
        const password = document.getElementById("password").value;

        // Confronta l'email e la password inserite con i valori predefiniti
        if (email === emailPredefinita && password === passwordPredefinita) {
            // Nascondi il modulo di login
            document.getElementById("login").style.display = "none";

            // Cambia il testo da "Login" a "Profilo"
            loginLink.textContent = "Profilo";

            // Mostra la casella "Profilo"
            profileLink.style.display = "inline-block";

            profileLink.addEventListener("mouseover", function () {
                document.getElementById("hide").style.visibility = "visible";
            });
            profileLink.addEventListener("mouseout", function () {
                document.getElementById("hide").style.visibility = "hidden";
            });

            // Aggiungi un gestore di eventi per il link di logout
            logoutButton.addEventListener("click", function () {
                // Ripristina il modulo di login
                document.getElementById("login").style.display = "block";

                // Resetta i campi del modulo di login
                form.reset();

                // Nascondi il contenuto dopo il logout
                loggedInContent.style.display = "none";

                // Cambia nuovamente il testo a "Login" dopo il logout
                loginLink.textContent = "Login";

                document.getElementById("hide").setAttribute("hidden", "true");
            });

            // Mostra il contenuto dopo il login
            loggedInName.textContent = nome + " " + cognome;
            loggedInContent.style.display = "block";

            // Mostra il menu a tendina
            dropdownContent.style.display = "block";
        } else {
            alert('Email o password errate. Riprova');
        }
    });
});

document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("device-form");

    form.addEventListener("submit", function (event) {
        event.preventDefault(); // Impedisce l'invio del modulo predefinito

        // Recupera i valori selezionati dai campi select
        const marca = document.getElementById("marca").value;
        const modello = document.getElementById("modello").value;
        const potenza = document.getElementById("potenza").value;

        // Crea un oggetto dati da inviare al server
        const data = {
            marca: marca,
            modello: modello,
            potenza: potenza
        }
    });
});
/*
function caricaDatiDalDatabase() {
    return [
        {
            nome: "Dispositivo 1",
            descrizione: "Questo è il dispositivo 1.",
            immagine: "device1.jpg"
        },
        {
            nome: "Dispositivo 2",
            descrizione: "Questo è il dispositivo 2.",
            immagine: "device2.jpg"
        },
        {
            nome: "Dispositivo 3",
            descrizione: "Questo è il dispositivo 3.",
            immagine: "device3.jpg"
        },
        {
            nome: "Dispositivo 4",
            descrizione: "Questo è il dispositivo 1.",
            immagine: "device1.jpg"
        }
    ];
}

// Carica i dati dal database e crea le card
const datiDalDatabase = caricaDatiDalDatabase();
creaCardDaDati(datiDalDatabase);
*/

function caricaDatiDalDatabase(marca, modello, potenza) {
    return [
        {
            nome: "Dispositivo 1",
            marca: marca,      // Inserisci la marca ricevuta come argomento
            modello: modello,  // Inserisci il modello ricevuto come argomento
            potenza: potenza,  // Inserisci la potenza ricevuta come argomento
            descrizione: "Questo è il dispositivo 1.",
            immagine: "device1.jpg"
        },
        // Aggiungi altri oggetti con i dati dei dispositivi
    ];
}

// Esegui questa funzione quando invii il modulo
document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("device-form");

    form.addEventListener("submit", function (event) {
        event.preventDefault(); // Impedisce l'invio del modulo predefinito

        // Recupera i valori selezionati dai campi select
        const marca = document.getElementById("marca").value;
        const modello = document.getElementById("modello").value;
        const potenza = document.getElementById("potenza").value;

        // Carica i dati dal database con i valori ricevuti
        const datiDalDatabase = caricaDatiDalDatabase(marca, modello, potenza);

        // Chiamata alla funzione per creare le card con i nuovi dati
        creaCardDaDati(datiDalDatabase);
    });
});

// Funzione per creare card HTML dai dati del database
function creaCardDaDati(dati) {
    const container = document.getElementById("card-container"); // Sostituisci con l'ID del tuo contenitore delle card

    dati.forEach(function (elemento) {
        const card = document.createElement("div");
        card.classList.add("card");

        const immagine = document.createElement("img");
        immagine.src = elemento.immagine;
        immagine.alt = elemento.nome;

        const titolo = document.createElement("h4");
        titolo.textContent = elemento.nome;

        const descrizione = document.createElement("p");
        descrizione.innerHTML = `Descrizione: ${elemento.descrizione}. <br>Marca: ${elemento.marca} <br>Modello: ${elemento.modello} <br>Potenza: ${elemento.potenza}`;

        card.appendChild(immagine);
        card.appendChild(titolo);
        card.appendChild(descrizione);

        container.appendChild(card);
    });
}