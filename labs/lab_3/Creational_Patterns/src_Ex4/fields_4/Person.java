package fields_4;

public abstract class Person {
	protected String email_;
	protected Phone phone_;
	protected String name_;
	
	public String phone() { return ""; }
	public String email() { return email_; }
	public String name()  { return name_;  }
}