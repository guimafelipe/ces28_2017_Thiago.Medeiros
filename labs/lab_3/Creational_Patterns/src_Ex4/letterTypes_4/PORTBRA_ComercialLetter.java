package letterTypes_4;
import fields_4.*;

public class PORTBRA_ComercialLetter extends Letter { 
	protected PORTBRA_Person sender_;
	protected PORTBRA_Person destinatary_;
	protected Address addressSender_;
	protected Address addressDestiny_;
	protected DDMMYYYY_Date   date_; 

	PORTBRA_ComercialLetter(PORTBRA_Person sender, PORTBRA_Person destinatary, Address addressSender, Address addressDestiny, DDMMYYYY_Date date) {
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
		return "Prezado " + destinatary_.name() + "\n";
	}
	
	protected String conclusion() {
		return "\nAtenciosamente,\n";
	} 
	
	protected String signature() { 
		return  "\n\n                  -----------------" +
				"\n                  " + sender_.name()  +
				"\n                  " + sender_.phone() +
			    "\n​ ​          email: " + sender_.email();  
	}
}