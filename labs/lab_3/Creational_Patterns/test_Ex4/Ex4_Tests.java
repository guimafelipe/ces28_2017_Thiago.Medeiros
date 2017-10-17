import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fields_4.*;
import letterTypes_4.*;

// Arquivos de testes para o Ex4

public class Ex4_Tests {
	@Test
	public void Comercial_ENG() {
		Phone phone_1 = new Phone("55", "92", "00000001");
		ENG_Person person_1 = new ENG_Person("thiago@ita.br", phone_1, "Thiago");
		Address address_1 = new Address("Rua do H8B, ap. 224");
		
		Phone phone_2 = new Phone("55", "12", "00000001");
		ENG_Person person_2 = new ENG_Person("prof@ita.br", phone_2, "Professor");
		Address address_2 = new Address("Vila das Acácias, DCTA");
		
		MMDDYYYY_Date date = new MMDDYYYY_Date("01", "01", "2015");
		
		LetterBuilder builder = new LetterBuilder();
		
		String answer = date.toPrint() + "\n\n" + 
						person_1.name() + "\n" + 
						address_1.toPrint() + "\n" +
						person_2.name() + "\n" + 
						address_2.toPrint() + "\n\n" + 
						"Dear " + person_2.name() + "\n" +
						"\nSincerely,\n" +
						"\n\n                  -----------------" +
						"\n                  " + person_1.name()  +
						"\n                  " + person_1.phone() +
					    "\n​ ​          email: " + person_1.email();
		
		String Comercial = builder.ENG_ComercialModel(person_1, person_2, address_1, address_2, date);
				
		assertEquals(Comercial, answer);
	}
	
	@Test
	public void Comercial_PORTBRA() {
		Phone phone_1 = new Phone("55", "92", "12345678");
		PORTBRA_Person person_1 = new PORTBRA_Person("thiago@ita.br", phone_1, "Thiago");
		Address address_1 = new Address("Rua do H8B, ap. 224");
		
		Phone phone_2 = new Phone("55", "12", "00000001");
		PORTBRA_Person person_2 = new PORTBRA_Person("prof@ita.br", phone_2, "Professor");
		Address address_2 = new Address("Vila das Acácias, DCTA");
		
		DDMMYYYY_Date date = new DDMMYYYY_Date("01", "01", "2015");
		
		LetterBuilder builder = new LetterBuilder();
		
		String answer = date.toPrint() + "\n\n" + 
						person_1.name() + "\n" + 
						address_1.toPrint() + "\n" +
						person_2.name() + "\n" + 
						address_2.toPrint() + "\n\n" + 
						"Prezado " + person_2.name() + "\n" +
						"\nAtenciosamente,\n" +
						"\n\n                  -----------------" +
						"\n                  " + person_1.name()  +
						"\n                  " + person_1.phone() +
					    "\n​ ​          email: " + person_1.email();
		
		String Comercial = builder.PORTBRA_ComercialModel(person_1, person_2, address_1, address_2, date);
		
		assertEquals(Comercial, answer);
	}
	
	@Test
	public void Personal_ENG() {
		Phone phone_1 = new Phone("1", "", "00000001");
		ENG_Person person_1 = new ENG_Person("John@gmail.com", phone_1, "John");		
		
		Phone phone_2 = new Phone("1", "", "00000002");
		ENG_Person person_2 = new ENG_Person("Jack@gmail.com", phone_2, "Jack");
		
		MMDDYYYY_Date date = new MMDDYYYY_Date("31", "12", "2017");
		
		LetterBuilder builder = new LetterBuilder();
		
		String answer = date.toPrint() + "\n\n" + 
						"Dear " + person_2.name() + "\n" +
						"\nYour buddy,\n" +
						"\n\n                  -----------------" +
						"\n                  " + person_1.name();
		
		String Personal = builder.ENG_PersonalModel(person_1, person_2, date);
		
		assertEquals(Personal, answer);
	}

	@Test
	public void Personal_PORTBRA() {
		Phone phone_1 = new Phone("1", "", "00000001");
		PORTBRA_Person person_1 = new PORTBRA_Person("John@gmail.com", phone_1, "John");		
		
		Phone phone_2 = new Phone("1", "", "00000002");
		PORTBRA_Person person_2 = new PORTBRA_Person("Jack@gmail.com", phone_2, "Jack");
		
		DDMMYYYY_Date date = new DDMMYYYY_Date("31", "12", "2017");
		
		LetterBuilder builder = new LetterBuilder();
		
		String answer = date.toPrint() + "\n\n" + 
						"Querido " + person_2.name() + "\n" +
						"\nSeu camarada,\n" +
						"\n\n                  -----------------" +
						"\n                  " + person_1.name();
		
		String Personal = builder.PORTBRA_PersonalModel(person_1, person_2, date);
		
		assertEquals(Personal, answer);
	}

	@Test
	public void Reader_ENG() {
		Phone phone_1 = new Phone("8", "", "00000001");
		ENG_Person person_1 = new ENG_Person("leitor@kawa.jp", phone_1, "Reader");
		
		Phone phone_2 = new Phone("8", "", "00000002");
		ENG_Person person_2 = new ENG_Person("editor@kawa.jp", phone_2, "Tokyo News");
		
		MMDDYYYY_Date date = new MMDDYYYY_Date("01", "05", "2010");
		
		LetterBuilder builder = new LetterBuilder();
		
		String answer = date.toPrint() + "\n\n" + 
						"Dear editors of " + person_2.name() + "\n" +
						"\nSincerely,\n" +
						"\n\n                  -----------------" +
						"\n                  " + person_1.name()  +
					    "\n​ ​          email: " + person_1.email();
		
		String Reader = builder.ENG_ReaderModel(person_1, person_2, date);
		
		assertEquals(Reader, answer);
	}

	@Test
	public void Reader_PORTBRA() {
		Phone phone_1 = new Phone("8", "", "00000001");
		PORTBRA_Person person_1 = new PORTBRA_Person("leitor@kawa.jp", phone_1, "Leitor");
		
		Phone phone_2 = new Phone("8", "", "00000002");
		PORTBRA_Person person_2 = new PORTBRA_Person("editor@kawa.jp", phone_2, "Tokyo News");
		
		DDMMYYYY_Date date = new DDMMYYYY_Date("01", "05", "2010");
		
		LetterBuilder builder = new LetterBuilder();
		
		String answer = date.toPrint() + "\n\n" + 
						"Prezados editores do " + person_2.name() + "\n" +
						"\nAtenciosamente,\n" +
						"\n\n                  -----------------" +
						"\n                  " + person_1.name()  +
					    "\n​ ​          email: " + person_1.email();
		
		String Reader = builder.PORTBRA_ReaderModel(person_1, person_2, date);
		
		assertEquals(Reader, answer);
	}
}