package br.ifpe.web3.eleitor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Eleitor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEleitor;
	@Column(length = 50, nullable = false)
	private String nomeEleitor;
	@Column(length = 50, nullable = false)
	private String bloco;
	@Column(length = 5, nullable = false)
	private Integer numeroApt;
	@Column(length = 12, nullable = false)
	private String telefone;

	public Integer getIdEleitor() {
		return idEleitor;
	}

	public void setIdEleitor(Integer idEleitor) {
		this.idEleitor = idEleitor;
	}

	public String getNomeEleitor() {
		return nomeEleitor;
	}

	public void setNomeEleitor(String nomeEleitor) {
		this.nomeEleitor = nomeEleitor;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public Integer getNumeroApt() {
		return numeroApt;
	}

	public void setNumeroApt(Integer numeroApt) {
		this.numeroApt = numeroApt;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
