package letterTypes_3;

import fields_3.*;

public class LetterBuilder {
	private String language_;
	
	public LetterBuilder(String language) { language_ = language; }
	
	// Carta Comercial
	public String ComercialModel(Person sender, Person destinatary, Address addressSender, Address addressDestiny, Date date) {
		if(language_.equals("PT-BR")) {
			return (new PORTBRA_ComercialLetter(sender, destinatary, addressSender, addressDestiny, date)).model();
		}
		else if(language_.equals("ENG")) {
			return (new ENG_ComercialLetter(sender, destinatary, addressSender, addressDestiny, date)).model();
		}
		
		return "";
	}
	
	// Carta Pessoal
	public String PersonalModel(Person sender, Person destinatary, Date date) {
		if(language_.equals("PT-BR")) {
			return (new PORTBRA_PersonalLetter(sender, destinatary, date)).model();
		}
		else if(language_.equals("ENG")) {
			return (new ENG_PersonalLetter(sender, destinatary, date)).model();
		}
		
		return "";
	}
	
	// Carta do Leitor
	public String ReaderModel(Person sender, Person destinatary, Date date) {
		if(language_.equals("PT-BR")) {
			return (new PORTBRA_ReaderLetter(sender, destinatary, date)).model();
		}
		else if(language_.equals("ENG")) {
			return (new ENG_ReaderLetter(sender, destinatary, date)).model();
		}

		return "";
	}
}