package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.Boleto;

public class BoletoDAOImpl extends HibernateGenericDAO<Boleto, Long> {
	
private static BoletoDAOImpl instance = null;
	
	private BoletoDAOImpl() {
		super(Boleto.class);
	}
	
	public static BoletoDAOImpl getInstance() {
		if (instance == null) {
			instance = new BoletoDAOImpl();
		}
		
		return instance;
	}
}
