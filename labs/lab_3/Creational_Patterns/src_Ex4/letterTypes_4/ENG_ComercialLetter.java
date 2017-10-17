package letterTypes_4;
import fields_4.*;

public class ENG_ComercialLetter extends Letter { 
	protected ENG_Person sender_;
	protected ENG_Person destinatary_;
	protected Address addressSender_;
	protected Address addressDestiny_;
	protected MMDDYYYY_Date   date_; 
	
	ENG_ComercialLetter(ENG_Person sender, ENG_Person destinatary, Address addressSender, Address addressDestiny, MMDDYYYY_Date date) {
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