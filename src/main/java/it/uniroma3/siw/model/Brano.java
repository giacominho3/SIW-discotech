package it.uniroma3.siw.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Brano {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nome;
	private String genere;
	@Column(nullable = false)
	private LocalDate data;

	@ManyToOne
	private Autore autore;

	public Brano() {

	}

	public Brano(String n, LocalDate d, Autore a) {
		this();
		this.nome = n;
		this.data = d;
		this.autore = a;
	}

	public Brano(String n, String g, LocalDate d, Autore a) {
		this(n, d, a);
		this.genere = g;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

}
