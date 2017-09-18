import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import ptc.ControladorPTC;
import ptc.Datacenter;
import ptc.PainelCondutor;
import ptc.Sensor;

public class Testes {
	@Mock private Sensor sensor;
	@Mock private Datacenter dataCenter;
	@Mock private PainelCondutor painelCond;
	@InjectMocks private ControladorPTC controle;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void letra_a__inicializacao_do_objeto_ControladorPTC() {
		controle = new ControladorPTC(sensor, dataCenter, painelCond);
		
		//verifica se o objeto foi instanciado
		Assert.assertNotNull(controle);
	}
	
	@Test
	public void letra_b__isCruzamento_retorna_falso() {
		Mockito.when(sensor.isCruzamento()).thenReturn(false);
		Mockito.when(sensor.getVelocidade()).thenReturn(100.0);
		Mockito.when(painelCond.imprimirAviso("100.0", 1)).thenReturn(true);
		
		controle.run();
		
		//para a condicao dada, sao invocados os metodos imprimirAviso (de painelCond)
		//e gerarRelatorio (de dataCenter) com os seguintes parametros. os metodos sao
		//invocados exatamente uma vez cada, comprovando o comportamento esperado do objeto
		//"controle".
		Mockito.verify(painelCond, Mockito.times(1)).imprimirAviso("100.0", 1);
		Mockito.verify(dataCenter, Mockito.times(1)).gerarRelatorio("100.0");
	}
	
	@Test
	public void letra_c__isCruzamento_retorna_verdadeiro_enviaMsgPrioritariaPainel_retorna_verdadeiro() {
		Mockito.when(sensor.isCruzamento()).thenReturn(true);
		Mockito.when(sensor.getVelocidade()).thenReturn(200.0);
		Mockito.when(painelCond.imprimirAviso("Velocidade alta", 1)).thenReturn(true);
		
		controle.run();
		
		//para as condicoes dadas, eh invocado o metodo imprimirAviso (de painelCond) 
		//com os seguintes parametros. em seguida, o metodo enviaMsgPrioritaria retorna verdadeiro,
		//como pedido
		Mockito.verify(painelCond, Mockito.times(1)).imprimirAviso("Velocidade alta", 1);
	}
	
	@Test
	public void letra_d__isCruzamento_retorna_verdadeiro_enviaMsgPrioritariaPainel_retorna_falso() {
		Mockito.when(sensor.isCruzamento()).thenReturn(true);
		Mockito.when(sensor.getVelocidade()).thenReturn(10.0);
		Mockito.when(painelCond.imprimirAviso("Velocidade alta", 1)).thenReturn(false);
		
		controle.run();
		
		//para a situacao dada, eh invocado o metodo imprimirAviso (de painelCond) por duas
		//vezes (uma ao entrar no metodo enviaMsgPrioritariaPainel e outra apos a contagem
		//de 10 segundos, em seguida o metodo enviaMsgPrioritariaPainel retorna falso, como pedido
		Mockito.verify(painelCond, Mockito.times(2)).imprimirAviso("Velocidade Baixa", 1);
	}
}