package letterTypes_3;
import fields_3.*;

public class ENG_ReaderLetter extends Letter {
	ENG_ReaderLetter(Person sender, Person destinatary, Date date) {
		sender_ = sender;
		destinatary_ = destinatary;
		date_   = date;
	}

	protected String header() { 
		return date_.MMDDYYYY() + "\n\n";
	} 

	protected String body() {
		return "Dear Mrs. editors of " + destinatary_.name() + "\n";
	}
	
	protected String conclusion() {
		return "\nSincerely,\n";
	} 
	
	protected String signature() { 
		return  "\n\n                  -----------------" +
				"\n                  Mr. " + sender_.name()  +
			    "\n​ ​          email: " + sender_.email();  
	}
}