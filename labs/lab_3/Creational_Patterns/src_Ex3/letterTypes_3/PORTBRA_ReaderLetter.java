package letterTypes_3;
import fields_3.*;

public class PORTBRA_ReaderLetter extends Letter {
	public PORTBRA_ReaderLetter(Person sender, Person destinatary, Date date) {
		sender_ = sender;
		destinatary_ = destinatary;
		date_   = date;
	}

	protected String header() { 
		return date_.DDMMYYYY() + "\n\n";
	} 

	protected String body() {
		return "Prezados Srs. editores do " + destinatary_.name() + "\n";
	}
	
	protected String conclusion() {
		return "\nAtenciosamente,\n";
	} 
	
	protected String signature() { 
		return  "\n\n                  -----------------" +
				"\n                  Sr. " + sender_.name()  +
			    "\n​ ​          email: " + sender_.email();  
	}
}