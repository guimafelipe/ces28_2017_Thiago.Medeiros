package fields_2;

public abstract class Person {
	protected String email_;
	protected Phone phone_;
	protected String name_;
	
	static public Person create(String email, Phone phone, String name, String language) {
		if(language.equals("ENG"))
			return new ENG_Person(email, phone, name);
		else if(language.equals("PT-BR"))
			return new PORTBRA_Person(email, phone, name);
		
		return null;
	}

	public String phone() { return ""; }
	public String email() { return email_; }
	public String name()  { return name_;  }
}