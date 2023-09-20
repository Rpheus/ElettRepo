package com.example.demo;

public class Elettrodomestico {
	String tipologia, marca, modello, potenza, potenzaEco, potenzaSec;

	public Elettrodomestico(String tipologia, String marca, String modello, String potenza, String potenzaEco,
			String potenzaSec) {
		this.tipologia = tipologia;
		this.marca = marca;
		this.modello = modello;
		this.potenza = potenza;
		this.potenzaEco = potenzaEco;
		this.potenzaSec = potenzaSec;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getPotenza() {
		return potenza;
	}

	public void setPotenza(String potenza) {
		this.potenza = potenza;
	}

	public String getPotenzaEco() {
		return potenzaEco;
	}

	public void setPotenzaEco(String potenzaEco) {
		this.potenzaEco = potenzaEco;
	}

	public String getPotenzaSec() {
		return potenzaSec;
	}

	public void setPotenzaSec(String potenzaSec) {
		this.potenzaSec = potenzaSec;
	}

	@Override
	public String toString() {
		return "Elettrodomestico [tipologia=" + tipologia + ", marca=" + marca + ", modello=" + modello + ", potenza="
				+ potenza + ", potenzaEco=" + potenzaEco + ", potenzaSec=" + potenzaSec + "]";
	}
	
	

}
