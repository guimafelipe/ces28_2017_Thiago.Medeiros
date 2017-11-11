package userPointOfViewTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import DB.API_DB_PS;
import DB.DB_PS;
import DB.Produto;
import DB.Servico;

public class Item_05_2 {

	private DB_PS DB_prod_serv;
	private API_DB_PS API_prod_serv;
	
	@Test
	public void Usuario_só_pode_criar_PS_pela_API_da_BDPS() {
		//Produto itemExemplo1 = new Produto("Nome",1,"");
		//Servico itemExemplo2 = new Servico("Nome",1,"");
		
		//As linhas acima geram erro de compilação, pois os construtores de
		//produto são restritos ao pacote de DB, do qual o usuário não faz parte.
		
		//API_prod_serv = API_DB_PS.getInstance();
		//Produto batata = API_prod_serv.createProduto("Batata", 1.0, "outros");
		
		//Observemos que a linha acima não gerá erro de compilação.
		//Portanto, assim o usuário poderia gerar o produto/serviço para adicionar à BD.
		
		//Entretanto, tal linha não pode ser executada uma vez que estámos fora do pacote DB
		//e não conseguimos mockar a BD.
		
	}

}
