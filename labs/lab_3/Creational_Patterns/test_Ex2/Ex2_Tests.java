import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fields_2.*;
import letterTypes_2.*;

// Arquivos de testes para o Ex2

public class Ex2_Tests {
	@Test
	public void Comercial_ENG() {
		Phone phone_1 = new Phone("55", "92", "00000001");
		Person person_1 = Person.create("thiago@ita.br", phone_1, "Thiago", "ENG");
		Address address_1 = new Address("Rua do H8B, ap. 224");
		
		Phone phone_2 = new Phone("55", "12", "00000001");
		Person person_2 = Person.create("ita@ita.br", phone_2, "ITA", "ENG");
		Address address_2 = new Address("Vila das Acácias, DCTA");
		
		Date date = Date.create("01", "01", "2015", "ENG");
		
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
		
		String Comercial = builder.ComercialModel(person_1, person_2, address_1, address_2, date);

		assertEquals(Comercial, answer);
	}
	
	@Test
	public void Comercial_PORTBRA() {
		Phone phone_1 = new Phone("55", "92", "12345678");
		Person person_1 = Person.create("thiago@ita.br", phone_1, "Thiago", "PT-BR");
		Address address_1 = new Address("Rua do H8B, ap. 224");
		
		Phone phone_2 = new Phone("55", "12", "00000001");
		Person person_2 = Person.create("ita@ita.br", phone_2, "ITA", "PT-BR");
		Address address_2 = new Address("Vila das Acácias, DCTA");
		
		Date date = Date.create("01", "01", "2015", "PT-BR");
		
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
		
		String Comercial = builder.ComercialModel(person_1, person_2, address_1, address_2, date);
		
		assertEquals(Comercial, answer);
	}
	
	@Test
	public void Personal_ENG() {
		Phone phone_1 = new Phone("1", "", "00000001");
		Person person_1 = Person.create("John@gmail.com", phone_1, "John", "ENG");		
		
		Phone phone_2 = new Phone("1", "", "00000002");
		Person person_2 = Person.create("Jack@gmail.com", phone_2, "Jack", "ENG");
		
		Date date = Date.create("31", "12", "2017", "ENG");
		
		LetterBuilder builder = new LetterBuilder();
		
		String answer = date.toPrint() + "\n\n" + 
						"Dear " + person_2.name() + "\n" +
						"\nYour buddy,\n" +
						"\n\n                  -----------------" +
						"\n                  " + person_1.name();
		
		String Personal = builder.PersonalModel(person_1, person_2, date);
		
		assertEquals(Personal, answer);
	}

	@Test
	public void Personal_PORTBRA() {
		Phone phone_1 = new Phone("1", "", "00000001");
		Person person_1 = Person.create("John@gmail.com", phone_1, "John", "PT-BR");		
		
		Phone phone_2 = new Phone("1", "", "00000002");
		Person person_2 = Person.create("Jack@gmail.com", phone_2, "Jack", "PT-BR");
		
		Date date = Date.create("31", "12", "2017", "PT-BR");
		
		LetterBuilder builder = new LetterBuilder();
		
		String answer = date.toPrint() + "\n\n" + 
						"Dear " + person_2.name() + "\n" +
						"\nYour buddy,\n" +
						"\n\n                  -----------------" +
						"\n                  " + person_1.name();
		
		String Personal = builder.PersonalModel(person_1, person_2, date);
		
		assertEquals(Personal, answer);
	}

	@Test
	public void Reader_ENG() {
		Phone phone_1 = new Phone("8", "", "00000001");
		Person person_1 = Person.create("leitor@kawa.jp", phone_1, "Leitor", "ENG");
		
		Phone phone_2 = new Phone("8", "", "00000002");
		Person person_2 = Person.create("editor@kawa.jp", phone_2, "Tokyo News", "ENG");
		
		Date date = Date.create("01", "05", "2010", "ENG");
		
		LetterBuilder builder = new LetterBuilder();
		
		String answer = date.toPrint() + "\n\n" + 
						"Dear editors of " + person_2.name() + "\n" +
						"\nSincerely,\n" +
						"\n\n                  -----------------" +
						"\n                  " + person_1.name()  +
					    "\n​ ​          email: " + person_1.email();
		
		String Reader = builder.ReaderModel(person_1, person_2, date);

		assertEquals(Reader, answer);
	}

	@Test
	public void Reader_PORTBRA() {
		Phone phone_1 = new Phone("8", "", "00000001");
		Person person_1 = Person.create("leitor@kawa.jp", phone_1, "Leitor", "PT-BR");
		
		Phone phone_2 = new Phone("8", "", "00000002");
		Person person_2 = Person.create("editor@kawa.jp", phone_2, "Tokyo News", "PT-BR");
		
		Date date = Date.create("01", "05", "2010", "PT-BR");
		
		LetterBuilder builder = new LetterBuilder();
		
		String answer = date.toPrint() + "\n\n" + 
						"Dear editors of " + person_2.name() + "\n" +
						"\nSincerely,\n" +
						"\n\n                  -----------------" +
						"\n                  " + person_1.name()  +
					    "\n​ ​          email: " + person_1.email();
		
		String Reader = builder.ReaderModel(person_1, person_2, date);
				
		assertEquals(Reader, answer);
	}
}