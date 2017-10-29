package App;

import BancoDeDados.BancoDeDados;
import FakeNameService.FakeNameService;
import FakeNameService.IMercado;
import Mercado.MercadoFacade; 

public class Aplicacao {
	public static void main(String[] args) {
		initSubsystems();
		FakeNameService NS = FakeNameService.getInstance();
		NS.printNames();
		IMercado mercado = (IMercado)NS.get("Mercado");
		int idCliente = mercado.registraNovoCliente("Ze", 123);
		mercado.adicionaProduto(idCliente, 223);
		mercado.adicionaProduto(idCliente, 342);
		mercado.processarPagamento(idCliente);
		
		createOtherBanco();
		mercado.setIBanco("BancoNovo");
		System.out.println("try old client:" );
		int idCliente2 = mercado.registraNovoCliente("Ze", 100);
		mercado.adicionaProduto(idCliente2, 100);
		mercado.adicionaProduto(idCliente2, 150);
		mercado.processarPagamento(idCliente2);

		mercado.processarPagamento(idCliente);	
	}

	public static void initSubsystems() {
		FakeNameService NS = FakeNameService.getInstance();
		NS.set("Banco",new BancoDeDados());
		NS.set("Mercado",MercadoFacade.getMercado());
		NS.printNames();
		
	}

	public static void createOtherBanco() {
		FakeNameService NS = FakeNameService.getInstance();
		NS.set("BancoNovo",new BancoDeDados());
	}
	
}