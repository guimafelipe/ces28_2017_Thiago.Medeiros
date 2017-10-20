import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Modificado.Despesa;
import Modificado.Impressora;
import Modificado.RelatorioDespesas;
import Modificado.SistemaOperacional;

public class Q4_b {
	private ArrayList<Despesa> despesas;
	private SistemaOperacional so;
	
	@Before
	public void beforeTest() {		
		despesas = new ArrayList<Despesa>();
		
		despesas.add(new Despesa(10.0f));
		despesas.add(new Despesa(20.0f));
		despesas.add(new Despesa(30.0f));
		despesas.add(new Despesa(40.0f));
		despesas.add(new Despesa(50.0f));
	}

	@Test
	public void test() {
		SistemaOperacional so = mock(SistemaOperacional.class);
		Mockito.when(so.getDriverImpressao()).thenReturn(new Impressora());

		RelatorioDespesas relatorio = new RelatorioDespesas(so.getDriverImpressao());		
		Iterator <Despesa> it = despesas.iterator();
		
		relatorio.ImprimirRelatorio(it);
	}
}
