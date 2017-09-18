package labmock;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.mail.MessagingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class SIAPJTest {
	@InjectMocks private SIAPJ siapj;
	
	@Mock private IServicoEmail emailMock;
	@Mock private ServicoDB dbMock;
	@Mock private IValidatorProcesso validatorMock;
	@Mock private IProcesso proc1;
	@Mock private IProcesso proc2;
	@Mock private Connection mockConnection;
	@Mock private Statement mockStatement;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		siapj = new SIAPJ(emailMock, dbMock, validatorMock);
	}
	
	@Test
	public void testeInicializacaoSIAPJ() {
		Assert.assertNotNull(siapj);
	}
	
	@Test
	public void testarCriaReclamacao() throws SQLException, MessagingException {
		Mockito.when(proc1.getEmail()).thenReturn("kabart@gmail.com");
		Mockito.when(validatorMock.validaProcesso(proc1)).thenReturn(true);
		Mockito.when(validatorMock.validaProcesso(proc2)).thenReturn(true);
		Mockito.when(dbMock.persisteProcesso(proc1)).thenReturn(1);
		Mockito.when(emailMock.sendEmail(proc1.getEmail(), "Processo aceito")).thenReturn(true);
		siapj.criaReclamacao(proc1);
	
		Mockito.when(proc2.getEmail()).thenReturn("lucio@gmail.com");
		Mockito.when(validatorMock.validaProcesso(proc2)).thenReturn(false);
		Mockito.when(emailMock.sendEmail(proc2.getEmail(), "Existem erros em seu processo")).thenReturn(true);		
		siapj.criaReclamacao(proc2);
			
		Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
		Mockito.when(mockConnection.createStatement().executeUpdate(Mockito.any())).thenReturn(1);
			
		//Mockito.verify(validatorMock, Mockito.times(2)).validaProcesso(Mockito.any());
		//Mockito.verify(dbMock, Mockito.times(1)).persisteProcesso(Mockito.any());
		//Mockito.verify(emailMock, Mockito.times(2)).sendEmail(Mockito.any(), Mockito.any());
		Mockito.verify(mockConnection, Mockito.times(1)).createStatement();			
	}
}
