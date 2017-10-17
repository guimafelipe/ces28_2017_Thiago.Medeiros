package fields_4;

public class PORTBRA_Person extends Person {
	public PORTBRA_Person(String email, Phone phone, String name) {
		email_ = email;
		phone_ = phone;
		name_ = "Sr. " + name;
	}
	
	public String phone() { return "(" + phone_.area() + ") " + phone_.number().substring(0, 4) + "-" + phone_.number().substring(4); }
}
