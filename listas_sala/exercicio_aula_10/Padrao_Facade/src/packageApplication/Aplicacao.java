package packageApplication;

import mercadoVirtual.Carrinho;
import mercadoVirtual.Cliente;
import mercadoVirtual.Façade;
import mercadoVirtual.Produto;

public class Aplicacao {
	public static void main(String[] args) {
		Façade facade = new Façade();

		// registrar comprador
		facade.addCliente("ZÉ", 123);

		// realizar uma compra
		facade.buyProduto(123, 223);

		// realizar outra compra
		facade.buyProduto(123, 342);

		// fechar compra
		facade.fecharCompra(123);
	}
}