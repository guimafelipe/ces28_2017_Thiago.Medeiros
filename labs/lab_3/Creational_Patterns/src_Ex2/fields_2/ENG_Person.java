package fields_2;

public class ENG_Person extends Person {
	public ENG_Person(String email, Phone phone, String name) {
		email_ = email;
		phone_ = phone;
		name_ = "Mr. " + name;
	}
	
	public String phone() { return "+" + phone_.country() + " (" + phone_.area() + ") " + phone_.number(); }	
}
