package letterTypes_4;
import fields_4.*;

public class ENG_PersonalLetter extends Letter { 
	protected ENG_Person sender_;
	protected ENG_Person destinatary_;
	protected Address addressSender_;
	protected Address addressDestiny_;
	protected MMDDYYYY_Date   date_; 

	ENG_PersonalLetter(ENG_Person sender, ENG_Person destinatary, MMDDYYYY_Date date) {
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