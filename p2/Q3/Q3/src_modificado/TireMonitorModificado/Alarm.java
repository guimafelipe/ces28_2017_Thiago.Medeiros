package TireMonitorModificado;

public class Alarm {
    private final double LowPressureThreshold;
    private final double HighPressureThreshold;
    private boolean alarmOn;
    private Sensor sensor;
    
    public Alarm(double LowTreshold, double HighThreshold, Sensor newSensor) {
    	LowPressureThreshold = LowTreshold;
    	HighPressureThreshold = HighThreshold;

    	sensor = newSensor;
        alarmOn = false;
    }
    
    public void check() {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < LowPressureThreshold ||
            HighPressureThreshold < psiPressureValue) {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn() {
        return alarmOn; 
    }
    
    public void turnOff() {
    	alarmOn = false;
    }
}