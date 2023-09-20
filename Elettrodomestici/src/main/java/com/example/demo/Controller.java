package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@RestController
public class Controller {
	
	@RequestMapping("/loadElet")
	public String index() {
		// "<script> location.href = \"login.html\" </script>";
		return "<script> location.href = \"caricamentoElettrodomestici.html\" </script>";
		
//		return "<!DOCTYPE html> \r\n" +
//		"<html lang=\"it\"> \r\n" +
//
//		"<head> \r\n" +
//		    "<meta charset=\"UTF-8\"> \r\n" +
//		    "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> \r\n" +
//		    "<link rel=\"stylesheet\" href=\"style.css\"> \r\n" +
//		    "<script src=\"https://kit.fontawesome.com/10df6efe8e.js\" crossorigin=\"anonymous\"></script> \r\n" +
//		    "<title>EnergiaInVista</title> \r\n" +
//		"</head> \r\n" +
//
//		"<body> \r\n" +
//		    "<header> \r\n" +
//		        "<div class=\"header-left\"> \r\n" +
//		            "<img src=\"icon.png\" alt=\"Icona\" class=\"icon\"> \r\n" +
//		            "<h1>EnergiaInVista</h1> \r\n" +
//		        "</div> \r\n" +
//		        "<div class=\"search-bar\"> \r\n" +
//		            "<input type=\"text\" id=\"search-input\" placeholder=\"Cerca Elettrodomestico\"> \r\n" +
//		            "<button id=\"search-button\" type=\"submit\"><i class=\"fas fa-search\"></i></button> \r\n" +
//		        "</div> \r\n" +
//		        "<nav> \r\n" +
//		            "<ul> \r\n" +
//		                "<li class=\"casella\"><a href=\"index.html\">Home</a></li> \r\n" +
//		                "<li class=\"casella dropdown\"> \r\n" +
//		                   "<a href=\"elettrodomestici.html\">Elettrodomestici</a> \r\n" +
//		                    "<div class=\"dropdown-content\"> \r\n" +
//		                        "<a href=\"#\">Elemento 1</a> \r\n" +
//		                        "<a href=\"#\">Elemento 2</a> \r\n" +
//		                        "<a href=\"#\">Elemento 3</a> \r\n" +
//		                        "<a href=\"#\">Elemento 4</a> \r\n" +
//		                        "<a href=\"#\">Elemento 5</a> \r\n" +
//		                        "<a href=\"#\">Elemento 6</a> \r\n" +
//		                    "</div> \r\n" +
//		                "</li> \r\n" +
//		                "<li class=\"casella\"><a href=\"login.html\" id=\"login-link\">Login</a></li> \r\n" +
//		            "</ul> \r\n" +
//		        "</nav> \r\n" +
//		    "</header> \r\n" +
//
//		    "<!-- Div contenente un titolo, un'immagine e una descrizione a destra --> \r\n" +
//		    "<div class=\"my-devices\"> \r\n" +
//		        "<div id=\"card-container\"></div> \r\n" +
//		    "</div> \r\n" +
//
//		    "<footer> \r\n" +
//		        "<p>&copy; 2023 EnergiaInVista. Tutti i diritti riservati.</p> \r\n" +
//		    "</footer> \r\n" +
//
//		    "<script src=\"script.js\"></script> \r\n" +
//		"</body> \r\n" +
//		"<script> \r\n" +
//
//		    "const immaginiTitoli = { \r\n" +
//		        "\"Asciugacapelli\": \"icone/airdryer.png\", \r\n" +
//		        "\"Condizionatore\": \"icone/conditioner_round.png\", \r\n" +
//		        "\"Lavastoviglie\": \"icone/dishwasher_round.png\", \r\n" +
//		        "\"Forno a Microonde\": \"icone/microwave_square.png\", \r\n" +
//		        "\"Mixer\": \"icone/mixer.png\", \r\n" +
//		        "\"Monitor\": \"icone/monitor_round.png\", \r\n" +
//		        "\"Forno\": \"icone/oven_square.png\", \r\n" +
//		        "\"PC\": \"icone/pc_round.png\", \r\n" +
//		        "\"Frigorifero\": \"icone/refrigerator.png\", \r\n" +
//		        "\"TV\": \"icone/tv_round.png\", \r\n" +
//		        "\"Aspirapolvere\": \"icone/vacuumcleaner.png\", \r\n" +
//		        "\"Scaldabagno\": \"icone/water_heater.png\", \r\n" +
//		        "\"Default\": \"icone/noimage.png\" \r\n" +
//		    "}; \r\n" +
//		    "const database = [ \r\n" +
//		        "{ \r\n" +
//		            "titolo: \"Asciugacapelli\", \r\n" +
//		            "descrizione: \"Asciugacapelli professionale ad alta potenza per asciugare i capelli in pochi minuti.\" \r\n" +
//		        "}, \r\n" +
//		        "{ \r\n" +
//		            "titolo: \"Condizionatore\", \r\n" +
//		            "descrizione: \"Condizionatore d'aria silenzioso ed efficiente per mantenere la tua casa fresca in estate.\" \r\n" +
//		        "}, \r\n" +
//		        "{ \r\n" +
//		            "titolo: \"Lavastoviglie\", \r\n" +
//		            "descrizione: \"Lavastoviglie ad alte prestazioni con programmi di lavaggio personalizzabili per piatti puliti in un attimo.\" \r\n" +
//		        "}, \r\n" +
//		        "{ \r\n" +
//		            "titolo: \"Forno a Microonde\", \r\n" +
//		            "descrizione: \"Forno a microonde compatto con diverse impostazioni di cottura per riscaldare e cuocere i tuoi pasti preferiti.\" \r\n" +
//		        "}, \r\n" +
//		        "{ \r\n" +
//		            "titolo: \"Mixer\", \r\n" +
//		            "descrizione: \"Mixer potente con lame in acciaio inossidabile per preparare frullati e bevande fresche.\" \r\n" +
//		        "}, \r\n" +
//		        "{ \r\n" +
//		            "titolo: \"Monitor\", \r\n" +
//		            "descrizione: \"Monitor ad alta risoluzione con schermo LED per una visualizzazione chiara delle immagini.\" \r\n" +
//		        "}, \r\n" +
//		        "{ \r\n" +
//		            "titolo: \"Forno\", \r\n" +
//		            "descrizione: \"Forno elettrico con funzioni di cottura multiple per preparare deliziosi piatti fatti in casa.\" \r\n" +
//		        "}, \r\n" +
//		        "{ \r\n" +
//		            "titolo: \"PC\", \r\n" +
//		            "descrizione: \"PC desktop veloce e affidabile con un potente processore per multitasking senza problemi.\" \r\n" +
//		        "}, \r\n" +
//		        "{ \r\n" +
//		            "titolo: \"Frigorifero\", \r\n" +
//		            "descrizione: \"Frigorifero spazioso con freezer integrato per conservare gli alimenti freschi per più a lungo.\" \r\n" +
//		        "}, \r\n" +
//		        "{ \r\n" +
//		            "titolo: \"TV\", \r\n" +
//		            "descrizione: \"TV a schermo piatto con una nitida qualità dell'immagine per l'intrattenimento a casa.\" \r\n" +
//		        "}, \r\n" +
//		        "{ \r\n" +
//		            "titolo: \"Aspirapolvere\", \r\n" +
//		            "descrizione: \"Aspirapolvere senza fili leggero e maneggevole per mantenere la tua casa pulita e ordinata.\" \r\n" +
//		        "}, \r\n" +
//		        "{ \r\n" +
//		            "titolo: \"Scaldabagno\", \r\n" +
//		            "descrizione: \"Scaldabagno a gas efficiente ed ecologico per l'acqua calda istantanea in casa tua.\" \r\n" +
//		        "}, \r\n" +
//		        "{ \r\n" +
//		            "titolo: \"Default\", \r\n" +
//		            "descrizione: \"Prodotto non specificato.\" \r\n" +
//		        "} \r\n" +
//		    "]; \r\n" +
//
//		    "document.addEventListener(\"DOMContentLoaded\", function () { \r\n" +
//		        "creaCardDaDati(database); \r\n" +
//		    "}); \r\n" +
//
//		    "const searchInput = document.getElementById(\"search-input\"); \r\n" +
//
//		    "searchInput.addEventListener(\"input\", function () { \r\n" +
//		        "const searchTerm = searchInput.value.toLowerCase(); \r\n" +
//		        "const filteredProducts = database.filter((prodotto) => \r\n" +
//		            "prodotto.titolo.toLowerCase().includes(searchTerm) \r\n" +
//		        "); \r\n" +
//		        "creaCardDaDati(filteredProducts); \r\n" +
//		    "}); \r\n" +
//
//		    // Costante per memorizzare i dati aggiunti alla lista
//		    "const Dati_Miei = []; \r\n" +
//
//		    "function creaCardDaDati(dati) { \r\n" +
//		        "const container = document.getElementById(\"card-container\"); \r\n" +
//		        "container.innerHTML = \"\"; \r\n" +
//
//		        "for (const elemento of dati) { \r\n" +
//		            "const card = document.createElement(\"div\"); \r\n" +
//
//		            // Aggiungi la classe .card-anim alla card per attivare l'animazione CSS
//		            "card.classList.add(\"card\", \"card-anim\"); \r\n" +
//
//		            "const immagine = document.createElement(\"img\"); \r\n" +
//		            "immagine.alt = elemento.titolo; \r\n" +
//
//		            // Verifica se c'è una corrispondenza di immagine per il titolo
//		            "if (elemento.titolo in immaginiTitoli) { \r\n" +
//		                "immagine.src = immaginiTitoli[elemento.titolo]; \r\n" +
//		            "} else { \r\n" +
//		                // Immagine predefinita se non c'è una corrispondenza
//		                "immagine.src = \"icone/default_square.png\"; \r\n" +
//		            "} \r\n" +
//
//		            "immagine.classList.add(\"general-icon\"); \r\n" +
//
//		            "const titolo = document.createElement(\"h4\"); \r\n" +
//		            "titolo.textContent = elemento.titolo; \r\n" +
//
//		            "const descrizione = document.createElement(\"p\"); \r\n" +
//		            "descrizione.textContent = elemento.descrizione; \r\n" +
//
//		            // Bottone "Aggiungi alla lista"
//		            "const addButton = document.createElement(\"button\"); \r\n" +
//		            "addButton.textContent = \"Aggiungi alla lista\"; \r\n" +
//		            "addButton.addEventListener(\"click\", function () { \r\n" +
//		                "aggiungiALista(elemento); \r\n" +
//		            "}); \r\n" +
//
//		            "card.appendChild(titolo); \r\n" +
//		            "card.appendChild(immagine); \r\n" +
//		            "card.appendChild(descrizione); \r\n" +
//		            "card.appendChild(addButton); \r\n" +
//
//		            "container.appendChild(card); \r\n" +
//		        "} \r\n" +
//		    "} \r\n" +
//
//		    // Chiamata alla funzione per creare le card
//		    "creaCardDaDati(database); \r\n" +
//
//		    // Funzione per aggiungere dati alla lista Dati_Miei
//		    "function aggiungiALista(elemento) { \r\n" +
//		        "Dati_Miei.push({ \r\n" +
//		            "titolo: elemento.titolo, \r\n" +
//		            "immagine: elemento.immagine, \r\n" +
//		            "descrizione: elemento.descrizione, \r\n" +
//		        "}); \r\n" +
//
//		        // Puoi fare qualcosa con i dati aggiunti, ad esempio visualizzarli o elaborarli ulteriormente.
//		        "console.log(\"Dati aggiunti alla lista:\", Dati_Miei); \r\n" +
//		    "} \r\n" +
//		"</script> \r\n" +
//
//		"</html> \r\n";
	}
	@PostMapping("/ricevi")
	public String riceviValore(@RequestBody JSONObject var) throws Exception,NumberFormatException{		
		System.out.println("Valore ricevuto da Javascript: "+var+"\n");
		parseElettrodomesticoObject(var); // Per inserire i dati nel database
		db(); // Prende i dati dal database e li mette in array 
		return "Sono Java, ho ricevuto il valore della variabile con successo";
	}
	
	@PostMapping("/stampa")
	public String stampaValore() throws Exception,NumberFormatException{		
		db(); // Prende i dati dal database e li mette in array 
		return "Sono Java, ho caricati i dati dal database con successo";
	}

	private static void parseElettrodomesticoObject(JSONObject elettrodomestico) throws Exception{
		try {
			String tipologia = (String) elettrodomestico.get("Tipologia");
			String marca = (String) elettrodomestico.get("Marca");
			String modello = (String) elettrodomestico.get("Modello");
			String potenza = (String) elettrodomestico.get("Potenza");
			String potenzaEco = (String) elettrodomestico.get("PotenzaEco");
			String potenzaSec = (String) elettrodomestico.get("PotenzaSec");
			if(elettrodomestico.get("Potenza")=="") {
				potenza="0";
			}
			if(elettrodomestico.get("PotenzaEco")=="") {
				potenzaEco="0";
			}
			if(elettrodomestico.get("PotenzaSec")=="") {
				potenzaSec="0";
			}
			Elettrodomestico el = new Elettrodomestico(tipologia, marca, modello, potenza, potenzaEco, potenzaSec);
			System.out.println(el);
			loadOnDB(el);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void loadOnDB(Elettrodomestico el) throws Exception, NumberFormatException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/";
		String username = "root";
		String password = "root1";
		Connection con = DriverManager.getConnection(url, username, password);
		Statement stmt = con.createStatement();
		String sql1 = "USE ENERGIAINVISTA;";
		stmt.execute(sql1);
		String sql2="INSERT INTO ELETTRODOMESTICI(TIPOLOGIA, MARCA, MODELLO, POTENZA_WATT, POTENZA_MOD_ECO, POTENZA_MOD_SEC) VALUES(?,?,?,?,?,?)";
		PreparedStatement prepared=con.prepareStatement(sql2);
		prepared.setString(1,el.getTipologia());
		prepared.setString(2,el.getMarca());
		prepared.setString(3,el.getModello());
		prepared.setInt(4,Integer.parseInt(el.getPotenza()));
		prepared.setInt(5,Integer.parseInt(el.getPotenzaEco()));
		prepared.setInt(6,Integer.parseInt(el.getPotenzaSec()));
		prepared.executeUpdate();
	}
	
	public static void db()throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/energiainvista","root","root1");
		Statement stmt=con.createStatement();
		ResultSet rst=stmt.executeQuery("SELECT COUNT(TIPOLOGIA) AS NUMERO FROM ELETTRODOMESTICI;");
		int ele=0;
		while(rst.next()) {
			ele=rst.getInt("NUMERO");
		}
		System.out.println(ele);
		ResultSet rst1=stmt.executeQuery("SELECT * FROM ELETTRODOMESTICI;");
		String tipologia="[";
		String marca="[";
		String modello="[";
		String pW="[";
		String pWE="[";
		String pWS="[";
		String tipologia1="";
		String marca1="";
		String modello1="";
		int pW1=0;
		int pWE1=0;
		int pWS1=0;
		while(rst1.next()) {
			ele=ele-1;
			tipologia1=rst1.getString("TIPOLOGIA");
			marca1=rst1.getString("MARCA");
			modello1=rst1.getString("MODELLO");
			pW1=rst1.getInt("POTENZA_WATT");
			pWE1=rst1.getInt("POTENZA_MOD_ECO");
			pWS1=rst1.getInt("POTENZA_MOD_SEC");
			tipologia=tipologia+"\"tipologia\":\""+tipologia1+"\",";
			marca=marca+"\"marca\":\""+marca1+"\",";
			modello=modello+"\"modello\":\""+modello1+"\",";
			pW=pW+"\"potenza_watt\":"+pW1+",";
			pWE=pWE+"\"potenza_mod_eco\":"+pWE1+",";
			pWS=pWS+"\"potenza_mod_sec\":"+pWS1+",";
			if(ele==1) {
				tipologia=tipologia+"\"tipologia\":\""+tipologia1+"\"]";
				marca=marca+"\"marca\":\""+marca1+"\"]";
				modello=modello+"\"modello\":\"\""+modello1+"\"]";
				pW=pW+"\"potenza_watt\":"+pW1+"]";
				pWE=pWE+"\"potenza_mod_eco\""+pWE1+"]";
				pWS=pWS+"\"potenza_mod_sec\":"+pWS1+"]";
			}
		}
		System.out.println(tipologia);
	}
	
}