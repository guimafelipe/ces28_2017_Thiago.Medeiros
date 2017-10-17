package letterTypes_3;
import fields_3.*;

public class ENG_ComercialLetter extends Letter { 
	ENG_ComercialLetter(Person sender, Person destinatary, Address addressSender, Address addressDestiny, Date date) {
		sender_ = sender;
		destinatary_    = destinatary;
		addressSender_  = addressSender;
		addressDestiny_ = addressDestiny;
		date_   = date;
	}

	protected String header() { 
		return date_.MMDDYYYY() + "\n\n" +
			   "Mr. " + sender_.name()  + "\n"   +
			   addressSender_.toPrint()   + "\n" +
			   "Mr. " + destinatary_.name() + "\n" + 
			   addressDestiny_.toPrint()  + "\n\n"; 
	} 

	protected String body() {
		return "Dear Mr. " + destinatary_.name() + "\n";
	}
	
	protected String conclusion() {
		return "\nSincerely,\n";
	} 
	
	protected String signature() { 
		return  "\n\n                  -----------------" +
				"\n                  Mr. " + sender_.name()  +
				"\n                  " + sender_.USphone() +
			    "\n​ ​          email: " + sender_.email();  
	}
}