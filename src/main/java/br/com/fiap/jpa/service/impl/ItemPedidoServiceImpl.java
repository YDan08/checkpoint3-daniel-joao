package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.ItemPedidoDAOImpl;
import br.com.fiap.jpa.entity.ItemPedido;
import br.com.fiap.jpa.service.GenericService;

public class ItemPedidoServiceImpl extends GenericService<ItemPedido,Long > {

	private static ItemPedidoServiceImpl instance = null;
	
	private ItemPedidoDAOImpl itemPedidoDAO;
	
	private ItemPedidoServiceImpl() {
		itemPedidoDAO = ItemPedidoDAOImpl.getInstance();
	}
	
	public static ItemPedidoServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new ItemPedidoServiceImpl();
		}
		
		return instance;
	}

	@Override
	public void cadastrar(ItemPedido instance) {
		try {
			itemPedidoDAO.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void atualizar(ItemPedido instance) {
		try {
			itemPedidoDAO.atualizar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void remover(Long id) {
		try {
			itemPedidoDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public ItemPedido obter(Long id) {
		ItemPedido itemPedido = null;
		
		try {
			itemPedido = itemPedidoDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
		return itemPedido;
	}

	@Override
	public List<ItemPedido> listar() {
		List<ItemPedido> itemPedidos = null;
		
		try {
			itemPedidos = itemPedidoDAO.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
		return itemPedidos;
	}
}
