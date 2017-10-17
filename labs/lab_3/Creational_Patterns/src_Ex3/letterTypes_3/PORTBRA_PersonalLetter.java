package letterTypes_3;
import fields_3.*;

public class PORTBRA_PersonalLetter extends Letter { 
	PORTBRA_PersonalLetter(Person sender, Person destinatary, Date date) {
		sender_ = sender;
		destinatary_ = destinatary;
		date_   = date;
	}

	protected String header() { 
		return date_.DDMMYYYY() + "\n\n";
	} 

	protected String body() {
		return "Querido " + destinatary_.name() + "\n";
	}
	
	protected String conclusion() {
		return "\nSeu camarada,\n";
	} 
	
	protected String signature() { 
		return  "\n\n                  -----------------" +
				"\n                  " + sender_.name();
	}
}