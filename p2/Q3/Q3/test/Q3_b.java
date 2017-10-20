import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import TireMonitorModificado.Alarm;
import TireMonitorModificado.Sensor;

public class Q3_b {
	private Sensor sensor;
	private Alarm alarme;
	
	@Before
	public void beforeTests() {
		sensor = mock(Sensor.class);
		alarme = new Alarm(17, 21, sensor);
	}

	@Test //check alarm, after instantiation, alarm is off
	public void nullTest() {
		assertFalse(alarme.isAlarmOn());
	}

	@Test //check when sensor read is below limits, alarm turns on
	public void belowLimits() {
		Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(16.0);

		alarme.check();
		assertTrue(alarme.isAlarmOn());
	}
	
	@Test //check when sensor read is above limits, alarm turns on
	public void aboveLimits() {
		Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(22.0);

		alarme.check();
		assertTrue(alarme.isAlarmOn());
	}	
	
	@Test //check when sensor read is between limits, alarm don't turns on
	public void betweenLimits() {
		Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(19.0);

		alarme.check();
		assertFalse(alarme.isAlarmOn());
	}
	
	@Test //check when alarm is turned off after it has been turned on
	public void turnOff() {
		Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(16.0);
		
		alarme.check();
		assertTrue(alarme.isAlarmOn());
		
		alarme.turnOff();
		assertFalse(alarme.isAlarmOn());
	}
	
	@Test //check when alarm is turned on after it has been turned off
	public void turnOnAfterTurnOff() {
		Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(22.0);
		
		alarme.check();
		assertTrue(alarme.isAlarmOn());
		
		alarme.turnOff();
		assertFalse(alarme.isAlarmOn());

		alarme.check();
		assertTrue(alarme.isAlarmOn());
}	
}