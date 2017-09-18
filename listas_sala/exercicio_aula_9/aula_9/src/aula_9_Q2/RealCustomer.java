package aula_9_Q2;

public class RealCustomer {
	private String name;
	
	public RealCustomer(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public boolean isNil() {
		return false;
	}
}
