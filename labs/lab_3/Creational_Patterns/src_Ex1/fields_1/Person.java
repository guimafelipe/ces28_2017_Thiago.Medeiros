package fields_1;
public class Person {
	private String email_;
	private String phone_;
	private String name_;
	
	public Person(String email, String phone, String name) {
		email_ = email;
		phone_ = phone;
		name_ = name;
	}
	
	public String email() { return email_; }
	public String phone() { return phone_; }	
	public String name()  { return name_;  }
}
