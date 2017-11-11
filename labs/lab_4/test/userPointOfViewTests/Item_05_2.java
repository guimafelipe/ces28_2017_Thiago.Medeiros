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
	public void Usuario_s�_pode_criar_PS_pela_API_da_BDPS() {
		//Produto itemExemplo1 = new Produto("Nome",1,"");
		//Servico itemExemplo2 = new Servico("Nome",1,"");
		
		//As linhas acima geram erro de compila��o, pois os construtores de
		//produto s�o restritos ao pacote de DB, do qual o usu�rio n�o faz parte.
		
		//API_prod_serv = API_DB_PS.getInstance();
		//Produto batata = API_prod_serv.createProduto("Batata", 1.0, "outros");
		
		//Observemos que a linha acima n�o ger� erro de compila��o.
		//Portanto, assim o usu�rio poderia gerar o produto/servi�o para adicionar � BD.
		
		//Entretanto, tal linha n�o pode ser executada uma vez que est�mos fora do pacote DB
		//e n�o conseguimos mockar a BD.
		
	}

}
