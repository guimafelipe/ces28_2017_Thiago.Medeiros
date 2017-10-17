package letterTypes_2;
import fields_2.*;

public class PersonalLetter extends Letter { 
	PersonalLetter(Person sender, Person destinatary, Date date) {
		sender_ = sender;
		destinatary_ = destinatary;
		date_   = date;
	}

	protected String header() { 
		return date_.toPrint() + "\n\n";
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