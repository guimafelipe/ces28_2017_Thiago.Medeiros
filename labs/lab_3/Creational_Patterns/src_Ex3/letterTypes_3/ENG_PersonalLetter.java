package letterTypes_3;
import fields_3.*;

public class ENG_PersonalLetter extends Letter { 
	public ENG_PersonalLetter(Person sender, Person destinatary, Date date) {
		sender_ = sender;
		destinatary_ = destinatary;
		date_   = date;
	}

	protected String header() { 
		return date_.MMDDYYYY() + "\n\n";
	} 

	protected String body() {
		return "Dear " + destinatary_.name() + "\n";
	}
	
	protected String conclusion() {
		return "\nYour buddy,\n";
	} 
	
	protected String signature() { 
		return  "\n\n                  -----------------" +
				"\n                  " + sender_.name();
	}
}