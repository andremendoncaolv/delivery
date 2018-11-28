package br.com.delivery.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "ENDERECOS")
public class Endereco extends AbstractEntity<Long> {

	@NotBlank
	@Size(min = 3, max = 255)
	@Column(nullable = false)
	private String rua;
	
	@NotBlank
	@Size(min = 3, max = 255)
	@Column(nullable = false)
	private String bairro;
	
	@NotBlank
	@Size(min = 3, max = 255)
	@Column(nullable = true)
	private String cidade;
	
	@Column(nullable = true, length = 15)
	private String estado;
	
	@Size(min = 9, max = 9, message = "{Size.endereco.cep}")
	@Column(nullable = true, length = 9)
	private String cep;
	
	@Digits(integer = 5, fraction = 0)
	@Column(nullable = true, length = 5)
	private Integer numero;
	
	@Size(max = 255)
	private String complemento;

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
}
