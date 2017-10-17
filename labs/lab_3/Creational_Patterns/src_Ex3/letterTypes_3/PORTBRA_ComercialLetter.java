package letterTypes_3;
import fields_3.*;

public class PORTBRA_ComercialLetter extends Letter { 
	public PORTBRA_ComercialLetter(Person sender, Person destinatary, Address addressSender, Address addressDestiny, Date date) {
		sender_ = sender;
		destinatary_    = destinatary;
		addressSender_  = addressSender;
		addressDestiny_ = addressDestiny;
		date_   = date;
	}

	protected String header() { 
		return date_.DDMMYYYY() + "\n\n" +
			   "Sr. " + sender_.name()  + "\n"   +
			   addressSender_.toPrint()   + "\n" +
			   "Sr. " + destinatary_.name() + "\n" + 
			   addressDestiny_.toPrint()  + "\n\n"; 
	} 

	protected String body() {
		return "Prezado Sr. " + destinatary_.name() + "\n";
	}
	
	protected String conclusion() {
		return "\nAtenciosamente,\n";
	} 
	
	protected String signature() { 
		return  "\n\n                  -----------------" +
				"\n                  Sr. " + sender_.name()  +
				"\n                  " + sender_.BRphone() +
			    "\n​ ​          email: " + sender_.email();  
	}
}