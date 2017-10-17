package letterTypes_2;
import fields_2.*;

public class ComercialLetter extends Letter { 
	ComercialLetter(Person sender, Person destinatary, Address addressSender, Address addressDestiny, Date date) {
		sender_ = sender;
		destinatary_    = destinatary;
		addressSender_  = addressSender;
		addressDestiny_ = addressDestiny;
		date_   = date;
	}

	protected String header() { 
		return date_.toPrint() + "\n\n" +
			   sender_.name()  + "\n"   +
			   addressSender_.toPrint()   + "\n" +
			   destinatary_.name() + "\n" + 
			   addressDestiny_.toPrint()  + "\n\n"; 
	} 

	protected String body() {
		return "Dear " + destinatary_.name() + "\n";
	}
	
	protected String conclusion() {
		return "\nSincerely,\n";
	} 
	
	protected String signature() { 
		return  "\n\n                  -----------------" +
				"\n                  " + sender_.name()  +
				"\n                  " + sender_.phone() +
			    "\n​ ​          email: " + sender_.email();  
	}
}