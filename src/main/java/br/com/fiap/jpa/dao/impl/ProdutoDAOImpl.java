package br.com.fiap.jpa.dao.impl;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import br.com.fiap.jpa.entity.Produto;

public class ProdutoDAOImpl  extends HibernateGenericDAO<Produto, Long>  {
	
	private static ProdutoDAOImpl  instance = null;
	
	private ProdutoDAOImpl () {
		super(Produto.class);
	}
	
	public static ProdutoDAOImpl  getInstance() {
		if (instance == null) {
			instance = new ProdutoDAOImpl ();
		}
		
		return instance;
	}
	
	public List<Produto> listarProdutoPorValorMaior(float valor, EntityManager entityManager) {
		
		TypedQuery<Produto> consulta = entityManager.createNamedQuery("Produto.listarProdutoPorValorMaior", Produto.class);
		consulta.setParameter("valorProduto", valor);
		
		return consulta.getResultList();
	}
	
	public List<Produto> listarPorNomeValor(String nome, float valor, EntityManager entityManager){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Produto> criteriaQuery = builder.createQuery(Produto.class);
		
		Root<Produto> produto = criteriaQuery.from(Produto.class);
		
		List<Predicate> predicates = new ArrayList<>();
		
		if(nome != null) {
			Predicate predicate = builder.like(builder.upper(produto.get("nome")),"%"+ nome.toUpperCase() + "%");
			predicates.add(predicate);
		}
		
		if(valor != 0) {
			Predicate predicate = builder.equal(produto.get("valor"), valor);
			predicates.add(predicate);
		}
		
		criteriaQuery.select(produto);
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		TypedQuery<Produto> consulta = entityManager.createQuery(criteriaQuery);
		return consulta.getResultList();
			
	}
	
	
}
