package br.com.delivery.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;

@SuppressWarnings("serial")
@Entity
@Table(name = "CARDAPIOS")
public class Cardapio extends AbstractEntity<Long>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CARDAPIO_ID")
	private Long id;
	
	//private Long idCardapio;
	
	@Column
	private String nomeCardapio;
	
	@Column(name = "DESCRICAO_CARDAPIO")
	private String descricaoCardapio;
	
	@Column(name = "PRECO_CARDAPIO")	
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal precoCardapio;
	
	@OneToMany(mappedBy = "cardapio")
	private List<Pedido> pedido;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*public Long getIdCardapio() {
		return idCardapio;
	}

	public void setIdCardapio(Long idCardapio) {
		this.idCardapio = idCardapio;
	}*/

	public String getNomeCardapio() {
		return nomeCardapio;
	}

	public void setNomeCardapio(String nomeCardapio) {
		this.nomeCardapio = nomeCardapio;
	}

	public String getDescricaoCardapio() {
		return descricaoCardapio;
	}

	public void setDescricaoCardapio(String descricaoCardapio) {
		this.descricaoCardapio = descricaoCardapio;
	}

	public BigDecimal getPrecoCardapio() {
		return precoCardapio;
	}

	public void setPrecoCardapio(BigDecimal precoCardapio) {
		this.precoCardapio = precoCardapio;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}
}
