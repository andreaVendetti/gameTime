package it.home.models;

import java.time.LocalDate;
import java.time.LocalTime;

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

	@Column(name = "data_sessione")
	private LocalDate date;
	
	@Column(name = "inizio_sessione")
	private LocalTime inizioSessione;
	
	@Column(name = "fine_sessione")
	private LocalTime fineSessione;
	
	@Column(name = "tempo_di_gioco")
	private LocalTime oreGiocate;
	
	public LocalTime getOreGiocate() {
		return oreGiocate;
	}

	public void setOreGiocate(LocalTime oreGiocate) {
		this.oreGiocate = oreGiocate;
	}

	public LocalTime getInizioSessione() {
		return inizioSessione;
	}

	public void setInizioSessione(LocalTime inizioSessione) {
		this.inizioSessione = inizioSessione;
	}

	public LocalTime getFineSessione() {
		return fineSessione;
	}

	public void setFineSessione(LocalTime fineSessione) {
		this.fineSessione = fineSessione;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
