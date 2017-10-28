package App;

import SubsistemaMercadoVirtual.BancoDeDados;
import SubsistemaMercadoVirtual.Carrinho;
import SubsistemaMercadoVirtual.Cliente;

public class Aplicacao {
	public static void main(String[] args) {
		Facade f = new Facade();
		
		f.registrar("Zé", 123);
		f.comprar(223, 123);
		f.comprar(342, 123);
		f.fecharCompra(123);		
	}
}