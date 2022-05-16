package br.com.fiap.jpa.dao.impl;


import br.com.fiap.jpa.entity.ItemPedido;


public class ItemPedidoDAOImpl extends HibernateGenericDAO<ItemPedido, Long> {

private static ItemPedidoDAOImpl instance = null;
	
	private ItemPedidoDAOImpl() {
		super(ItemPedido.class);
	}
	
	public static ItemPedidoDAOImpl getInstance() {
		if (instance == null) {
			instance = new ItemPedidoDAOImpl();
		}
		
		return instance;
	}
}
