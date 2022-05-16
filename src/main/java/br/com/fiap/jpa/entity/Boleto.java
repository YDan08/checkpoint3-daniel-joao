package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_boleto")
@SequenceGenerator(name = "boleto", sequenceName = "SQ_TB_BOLETO", allocationSize = 1)
public class Boleto implements Serializable {
	
	
	private static final long serialVersionUID = 8717590380409050100L;
	
	public Boleto() {
		
	}
	
	

	public Boleto(String nossoNumero, LocalDateTime dataVencimento, int valor, String codigoBarras) {
		this.nossoNumero = nossoNumero;
		this.dataVencimento = dataVencimento;
		this.valor = valor;
		this.codigoBarras = codigoBarras;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "boleto")
	private Long id;
	
	@Column(name = "NR_NOSSONUMERO")
	private String nossoNumero;
	
	@Column(name = "dt_vencimento")
	private LocalDateTime dataVencimento;
	
	@Column(name = "valor")
	private int valor;
	
	@Column(name = "NR_CODIGOBARRAS")
	private String codigoBarras;
	
	
	 @OneToOne(mappedBy = "boleto", cascade = CascadeType.ALL)
		@PrimaryKeyJoinColumn
		private Pedido pedido;
	

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNossoNumero() {
		return nossoNumero;
	}

	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	public LocalDateTime getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDateTime dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "Boleto [nossoNumero=" + nossoNumero + ", dataVencimento=" + dataVencimento + ", valor=" + valor
				+ ", codigoBarras=" + codigoBarras + "]";
	}
	
	
}
