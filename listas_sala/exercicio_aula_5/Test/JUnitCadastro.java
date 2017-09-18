import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import Back_End.DBClientes;
import Back_End.cadastro;

public class JUnitCadastro {
    DBClientes dBclientes = mock(DBClientes.class);
    cadastro cad = new cadastro(dBclientes);
    
	@Before
	public void setUp() {        
		//item a)
		when(dBclientes.verificaCPF(1111111111)).thenReturn(true);
		
		//item b) <- nao existe no roteiro!
		
		//item c)
		when(dBclientes.verificaCPF(555555555)).thenReturn(false);		
	}
	
	@Test
	public void Teste_a() {
		cad.add_cliente(1111111111, "Jose da Silva", "H8B, ap. 233", 996966969);
		verify(dBclientes, times(1)).verificaCPF(1111111111);
	}

	@Test
	public void Teste_b(){
		//nao existe no roteiro!
	} 
	
	@Test
	public void Teste_c() {
		cad.add_cliente(555555555, "Joaquim Oliveira", "H8C, ap. 333", 969699696);
		verify(dBclientes, times(1)).verificaCPF(555555555);
	}
}