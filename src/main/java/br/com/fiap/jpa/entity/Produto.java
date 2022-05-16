package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produto")
@SequenceGenerator(name = "produto", sequenceName = "SQ_TB_PRODUTO", allocationSize = 1)
@NamedQueries({
	@NamedQuery(name = "Produto.listarProdutoPorValorMaior", query = "SELECT p FROM Produto p WHERE p.valor >=  :valorProduto"),
})
public class Produto implements Serializable {

	private static final long serialVersionUID = -5330826672012446375L;

	public Produto() {
		
	}
	
	public Produto(String nome, float valor) {
		this.nome = nome;
		this.valor = valor;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
	private Long id;
	
	@Column(name = "ds_nome", nullable = false)
	private String nome;
	
	@Column(name = "vl_produto", nullable = false)
	private float valor;
	
	@OneToMany(mappedBy = "produto")
	private List<ItemPedido> itemPedido;

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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}

	@Override
	public String toString() {
		return "Produto \nNome=" 
	+ this.getNome() 
	+ "\nValor=" + this.getValor();
	}
	
	
}
