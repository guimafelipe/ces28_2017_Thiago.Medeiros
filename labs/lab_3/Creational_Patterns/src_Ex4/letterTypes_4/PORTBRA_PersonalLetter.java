package letterTypes_4;
import fields_3.Address;
import fields_4.*;

public class PORTBRA_PersonalLetter extends Letter { 
	protected PORTBRA_Person sender_;
	protected PORTBRA_Person destinatary_;
	protected Address addressSender_;
	protected Address addressDestiny_;
	protected DDMMYYYY_Date   date_; 

	PORTBRA_PersonalLetter(PORTBRA_Person sender, PORTBRA_Person destinatary, DDMMYYYY_Date date) {
		sender_ = sender;
		destinatary_ = destinatary;
		date_   = date;
	}

	protected String header() { 
		return date_.toPrint() + "\n\n";
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