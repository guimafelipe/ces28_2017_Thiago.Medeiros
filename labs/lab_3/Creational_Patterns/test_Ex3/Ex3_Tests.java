import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fields_3.*;
import letterTypes_3.*;

// Arquivos de testes para o Ex3

public class Ex3_Tests {
	@Test
	public void Comercial_ENG() {
		Phone phone_1 = new Phone("55", "92", "00000001");
		Person person_1 = new Person("thiago@ita.br", phone_1, "Thiago");
		Address address_1 = new Address("Rua do H8B, ap. 224");
		
		Phone phone_2 = new Phone("55", "12", "00000001");
		Person person_2 = new Person("prof@ita.br", phone_2, "Professor");
		Address address_2 = new Address("Vila das Acácias, DCTA");
		
		Date date = new Date("01", "01", "2015");
		
		LetterBuilder builder = new LetterBuilder("ENG");
		
		String answer = date.MMDDYYYY() + "\n\n" + 
						"Mr. " + person_1.name() + "\n" + 
						address_1.toPrint() + "\n" +
						"Mr. " + person_2.name() + "\n" + 
						address_2.toPrint() + "\n\n" + 
						"Dear Mr. " + person_2.name() + "\n" +
						"\nSincerely,\n" +
						"\n\n                  -----------------" +
						"\n                  Mr. " + person_1.name()  +
						"\n                  " + person_1.USphone() +
					    "\n​ ​          email: " + person_1.email();
		
		String Comercial = builder.ComercialModel(person_1, person_2, address_1, address_2, date);
		
		assertEquals(Comercial, answer);
	}
	
	@Test
	public void Comercial_PORTBRA() {
		Phone phone_1 = new Phone("55", "92", "12345678");
		Person person_1 = new Person("thiago@ita.br", phone_1, "Thiago");
		Address address_1 = new Address("Rua do H8B, ap. 224");
		
		Phone phone_2 = new Phone("55", "12", "00000001");
		Person person_2 = new Person("prof@ita.br", phone_2, "Professor");
		Address address_2 = new Address("Vila das Acácias, DCTA");
		
		Date date = new Date("01", "01", "2015");
		
		LetterBuilder builder = new LetterBuilder("PT-BR");
		
		String answer = date.DDMMYYYY() + "\n\n" + 
						"Sr. " + person_1.name() + "\n" + 
						address_1.toPrint() + "\n" +
						"Sr. " + person_2.name() + "\n" + 
						address_2.toPrint() + "\n\n" + 
						"Prezado Sr. " + person_2.name() + "\n" +
						"\nAtenciosamente,\n" +
						"\n\n                  -----------------" +
						"\n                  Sr. " + person_1.name()  +
						"\n                  " + person_1.BRphone() +
					    "\n​ ​          email: " + person_1.email();
		
		String Comercial = builder.ComercialModel(person_1, person_2, address_1, address_2, date);
		
		assertEquals(Comercial, answer);
	}
	
	@Test
	public void Personal_ENG() {
		Phone phone_1 = new Phone("1", "", "00000001");
		Person person_1 = new Person("John@gmail.com", phone_1, "John");		
		
		Phone phone_2 = new Phone("1", "", "00000002");
		Person person_2 = new Person("Jack@gmail.com", phone_2, "Jack");
		
		Date date = new Date("31", "12", "2017");
		
		LetterBuilder builder = new LetterBuilder("ENG");
		
		String answer = date.MMDDYYYY() + "\n\n" + 
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
		Person person_1 = new Person("John@gmail.com", phone_1, "John");		
		
		Phone phone_2 = new Phone("1", "", "00000002");
		Person person_2 = new Person("Jack@gmail.com", phone_2, "Jack");
		
		Date date = new Date("31", "12", "2017");
		
		LetterBuilder builder = new LetterBuilder("PT-BR");
		
		String answer = date.DDMMYYYY() + "\n\n" + 
						"Querido " + person_2.name() + "\n" +
						"\nSeu camarada,\n" +
						"\n\n                  -----------------" +
						"\n                  " + person_1.name();
		
		String Personal = builder.PersonalModel(person_1, person_2, date);

		assertEquals(Personal, answer);
	}

	@Test
	public void Reader_ENG() {
		Phone phone_1 = new Phone("8", "", "00000001");
		Person person_1 = new Person("leitor@kawa.jp", phone_1, "Reader");
		
		Phone phone_2 = new Phone("8", "", "00000002");
		Person person_2 = new Person("editor@kawa.jp", phone_2, "Tokyo News");
		
		Date date = new Date("01", "05", "2010");
		
		LetterBuilder builder = new LetterBuilder("ENG");
		
		String answer = date.MMDDYYYY() + "\n\n" + 
						"Dear Mrs. editors of " + person_2.name() + "\n" +
						"\nSincerely,\n" +
						"\n\n                  -----------------" +
						"\n                  Mr. " + person_1.name()  +
					    "\n​ ​          email: " + person_1.email();
		
		String Reader = builder.ReaderModel(person_1, person_2, date);
				
		assertEquals(Reader, answer);
	}

	@Test
	public void Reader_PORTBRA() {
		Phone phone_1 = new Phone("8", "", "00000001");
		Person person_1 = new Person("leitor@kawa.jp", phone_1, "Leitor");
		
		Phone phone_2 = new Phone("8", "", "00000002");
		Person person_2 = new Person("editor@kawa.jp", phone_2, "Tokyo News");
		
		Date date = new Date("01", "05", "2010");
		
		LetterBuilder builder = new LetterBuilder("PT-BR");
		
		String answer = date.DDMMYYYY() + "\n\n" + 
						"Prezados Srs. editores do " + person_2.name() + "\n" +
						"\nAtenciosamente,\n" +
						"\n\n                  -----------------" +
						"\n                  Sr. " + person_1.name()  +
					    "\n​ ​          email: " + person_1.email();
		
		String Reader = builder.ReaderModel(person_1, person_2, date);
				
		assertEquals(Reader, answer);
	}
}