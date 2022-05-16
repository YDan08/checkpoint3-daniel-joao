package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pedido")
@SequenceGenerator(name = "pedido", sequenceName = "SQ_TB_PEDIDO", allocationSize = 1)
public class Pedido implements Serializable {

	
	private static final long serialVersionUID = 7924199290088520906L;
	
	public Pedido() {
		
	}

	

	public Pedido(int numeroPedido, float valorTotal, String cpfCliente, Boleto boleto) {
		super();
		this.numeroPedido = numeroPedido;
		this.valorTotal = valorTotal;
		this.cpfCliente = cpfCliente;
		this.boleto = boleto;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido")
	private Long id;
	
	@Column(name = "nr_pedido")
	private int numeroPedido;
	
	@Column(name = "vl_total")
	private float valorTotal;
	
	@Column(name = "nr_cpf")
	private String cpfCliente;
	

	@OneToOne(optional = false)
	@JoinColumn(name = "boleto_id")
	private Boleto boleto;
	

	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itemPedido;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public Boleto getBoleto() {
		return boleto;
	}

	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
	}

	@Override
	public String toString() {
		return "Pedido \nNumero Pedido: " + this.getNumeroPedido()
		+ "\nValor Total: " + this.getValorTotal()
		+ "\nCPF Cliente: " + this.getCpfCliente()
		+ "\nBoleto: " + this.getBoleto();
	}
	
	
	
}
