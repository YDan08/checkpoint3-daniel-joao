package br.com.fiap.jpa;

import br.com.fiap.jpa.service.impl.PedidoServiceImpl;
import br.com.fiap.jpa.service.impl.ProdutoServiceImpl;

public class App {

	public static void main(String[] args) {
		
		//Instanciando service para executar operações na entidade Aluno
		
		PedidoServiceImpl pedidoService = PedidoServiceImpl.getInstance();
		ProdutoServiceImpl produtoService = ProdutoServiceImpl.getInstance();
		
		System.out.println("============ Listar por cpf==============");
		
		pedidoService.listarPorCpf("111.111.111-11").forEach(System.out::println);
		
		System.out.println("============ Listar produtos  por valor mair que==============");
		
		produtoService.listarProdutoPorValorMaior(100).forEach(System.out::println);
		
		System.out.println("============ Listar pedido com boleto==============");
		
		pedidoService.listarPedidoBoleto().forEach(System.out::println);
		
		System.out.println("============ Filtro produto==============");
		
		produtoService.listarPorNomeValor("Caderno",15).forEach(System.out::println);
		
	}
}
