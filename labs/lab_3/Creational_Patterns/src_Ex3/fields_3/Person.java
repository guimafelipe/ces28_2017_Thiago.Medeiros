package fields_3;

public class Person {
	protected String email_;
	protected Phone phone_;
	protected String name_;

	public Person(String email, Phone phone, String name) {
		email_ = email;
		phone_ = phone;
		name_  =  name;
	}

	public String USphone() { return "+" + phone_.country() + " (" + phone_.area() + ") " + phone_.number(); }
	public String BRphone() { return "(" + phone_.area() + ") " + phone_.number().substring(0, 4) + "-" + phone_.number().substring(4); }
	
	public String email() { return email_; }
	public String name()  { return name_;  }
}
