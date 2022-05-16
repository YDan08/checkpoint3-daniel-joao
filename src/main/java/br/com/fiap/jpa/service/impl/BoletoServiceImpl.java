package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.BoletoDAOImpl;
import br.com.fiap.jpa.entity.Boleto;
import br.com.fiap.jpa.service.GenericService;

public class BoletoServiceImpl extends GenericService<Boleto, Long> {

	private static BoletoServiceImpl instance = null;

	private BoletoDAOImpl boletoDAO;

	private BoletoServiceImpl() {
		boletoDAO = BoletoDAOImpl.getInstance();
	}

	public static BoletoServiceImpl getInstance() {

		if (instance == null) {
			instance = new BoletoServiceImpl();
		}

		return instance;
	}

	@Override
	public void cadastrar(Boleto instance) {
		try {
			boletoDAO.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void atualizar(Boleto instance) {
		try {
			boletoDAO.atualizar(instance, getEntityManager());
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
			boletoDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public Boleto obter(Long id) {
		Boleto boleto = null;
		
		try {
			boleto = boletoDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
		return boleto;
	}

	@Override
	public List<Boleto> listar() {
		List<Boleto> boletos = null;
		
		try {
			boletos = boletoDAO.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
		return boletos;
	}
}
