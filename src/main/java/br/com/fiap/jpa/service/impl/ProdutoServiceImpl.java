package br.com.fiap.jpa.service.impl;


import java.util.List;


import br.com.fiap.jpa.dao.impl.ProdutoDAOImpl;
import br.com.fiap.jpa.entity.Produto;
import br.com.fiap.jpa.service.GenericService;

public class ProdutoServiceImpl extends GenericService<Produto,Long >{

	private static ProdutoServiceImpl instance = null;
	
	private ProdutoDAOImpl produtoDAO;
	
	private ProdutoServiceImpl() {
		produtoDAO = ProdutoDAOImpl.getInstance();
	}
	
	public static ProdutoServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new ProdutoServiceImpl();
		}
		
		return instance;
	}

	@Override
	public void cadastrar(Produto instance) {
		try {
			produtoDAO.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void atualizar(Produto instance) {
		try {
			produtoDAO.atualizar(instance, getEntityManager());
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
			produtoDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public Produto obter(Long id) {
		Produto produto = null;
		
		try {
			produto = produtoDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
		return produto;
	}

	@Override
	public List<Produto> listar() {
		List<Produto> produtos = null;
		
		try {
			produtos = produtoDAO.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
		return produtos;
	}
	
	public List<Produto> listarProdutoPorValorMaior(float valor){
		List<Produto> produtos = null;
		try {
			produtos = produtoDAO.listarProdutoPorValorMaior(valor,getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return produtos;
	}
	
	public List<Produto> listarPorNomeValor(String nome, float valor){
		List<Produto> produtos = null;
		try {
			produtos = produtoDAO.listarPorNomeValor(nome,valor,getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return produtos;
	}
}
