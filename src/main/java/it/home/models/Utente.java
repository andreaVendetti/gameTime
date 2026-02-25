package it.home.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "utenti")
public class Utente {

	// gli diciamo che è un id
	@Id 
	// generated value = auto_increment e strategy è il tipo di algoritmo
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private int id;
	
	// mappedBy = nome campo di sql
	@OneToMany(mappedBy = "utente", cascade = CascadeType.MERGE, orphanRemoval = false)
	private List<TempoDiGioco> times = new ArrayList<>();
	
	@Column(length = 30)
	private String nome;
	
	@Column(length = 30)
	private String cognome;
	
	@Column
	private int eta;
	
	@Column(length = 30, unique = true)
	private String username;
	
	@Column(length = 255)
	private String pass;
	
	@Column
	private int admin;

	@Column(length = 30, unique = true)
	private String email;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
