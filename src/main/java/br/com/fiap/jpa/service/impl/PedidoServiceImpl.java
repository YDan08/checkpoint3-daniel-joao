package br.com.fiap.jpa.service.impl;

import java.util.List;
import br.com.fiap.jpa.dao.impl.PedidoDAOImpl;
import br.com.fiap.jpa.entity.Pedido;
import br.com.fiap.jpa.service.GenericService;

public class PedidoServiceImpl extends GenericService<Pedido,Long > {

private static PedidoServiceImpl instance = null;
	
	private PedidoDAOImpl pedidoDAO;
	
	private PedidoServiceImpl() {
		pedidoDAO = PedidoDAOImpl.getInstance();
	}
	
	public static PedidoServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new PedidoServiceImpl();
		}
		
		return instance;
	}

	@Override
	public void cadastrar(Pedido instance) {
		try {
			pedidoDAO.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void atualizar(Pedido instance) {
		try {
			pedidoDAO.atualizar(instance, getEntityManager());
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
			pedidoDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public Pedido obter(Long id) {
		Pedido pedido = null;
		
		try {
			pedido = pedidoDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
		return pedido;
	}

	@Override
	public List<Pedido> listar() {
		List<Pedido> pedidos = null;
		
		try {
			pedidos = pedidoDAO.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
		return pedidos;
	}
	
	public List<Pedido> listarPorCpf(String cpf){
		List<Pedido> pedidos = null;
		try {
			pedidos = pedidoDAO.listarPorCpf(cpf,getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return pedidos;
	}
	
	public List<Pedido> listarPedidoBoleto(){
		List<Pedido> pedidos = null;
		try {
			pedidos = pedidoDAO.listarPedidoBoleto(getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return pedidos;
	}
}

