package letterTypes_4;

import fields_4.*;

public class LetterBuilder {	
	// Carta Comercial - Ingles
	public String ENG_ComercialModel(ENG_Person sender, ENG_Person destinatary, Address addressSender, Address addressDestiny, MMDDYYYY_Date date) {
		return (new ENG_ComercialLetter(sender, destinatary, addressSender, addressDestiny, date)).model();
	}
	
	// Carta Comercial - Portugues
	public String PORTBRA_ComercialModel(PORTBRA_Person sender, PORTBRA_Person destinatary, Address addressSender, Address addressDestiny, DDMMYYYY_Date date) {
		return (new PORTBRA_ComercialLetter(sender, destinatary, addressSender, addressDestiny, date)).model();
	}
	
	// Carta Pessoal - Ingles
	public String ENG_PersonalModel(ENG_Person sender, ENG_Person destinatary, MMDDYYYY_Date date) {
		return (new ENG_PersonalLetter(sender, destinatary, date)).model();
	}
	
	// Carta Pessoal - Portugues
	public String PORTBRA_PersonalModel(PORTBRA_Person sender, PORTBRA_Person destinatary, DDMMYYYY_Date date) {
		return (new PORTBRA_PersonalLetter(sender, destinatary, date)).model();
	}

	// Carta do Leitor - Ingles
	public String ENG_ReaderModel(ENG_Person sender, ENG_Person destinatary, MMDDYYYY_Date date) {
		return (new ENG_ReaderLetter(sender, destinatary, date)).model();
	}
	
	// Carta do Leitor - Portugues
	public String PORTBRA_ReaderModel(PORTBRA_Person sender, PORTBRA_Person destinatary, DDMMYYYY_Date date) {
		return (new PORTBRA_ReaderLetter(sender, destinatary, date)).model();
	}
}