package it.home.models;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tempo")
public class TempoDiGioco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(cascade = CascadeType.PERSIST)
	// name = nome del campo della tabella dove ci troviamo e referencedEcc = nome
	// del campo della pk di un altra tabella
	@JoinColumn(name = "utente", referencedColumnName = "id")
	private Utente utente;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "videogioco", referencedColumnName = "id")
	private Videogioco videogioco;

	@Column(name = "tempo_di_gioco")
	private LocalDateTime dateTime;
	
	public TempoDiGioco() {}
	
	public TempoDiGioco(int id, Utente utente, Videogioco videogioco, LocalDateTime tempo) {
		this.id = id;
		this.utente = utente;
		this.videogioco = videogioco;
		this.dateTime = tempo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Videogioco getVideogioco() {
		return videogioco;
	}

	public void setVideogioco(Videogioco videogioco) {
		this.videogioco = videogioco;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

}
