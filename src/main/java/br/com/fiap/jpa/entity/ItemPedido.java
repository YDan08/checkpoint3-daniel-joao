package br.com.fiap.jpa.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_itemPedido")
@SequenceGenerator(name = "itemPedido", sequenceName = "SQ_TB_ITEM_PEDIDO", allocationSize = 1)
public class ItemPedido implements Serializable {

	
	private static final long serialVersionUID = 1841828560402831688L;
	
	public ItemPedido() {
		
	}
	

	public ItemPedido(int quantidade, Pedido pedido, Produto produto) {
		this.quantidade = quantidade;
		this.pedido = pedido;
		this.produto = produto;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemPedido")
	private Long id;
	
	@Column(name = "nr_quantidade")
	private int quantidade;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "produto_id")
	private Produto produto;

	public Long getId() {
		return id;
	}
	


	public void setId(Long id) {
		this.id = id;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	@Override
	public String toString() {
		return "ItemPedido [quantidade=" + quantidade + "]";
	}
	
	

}
