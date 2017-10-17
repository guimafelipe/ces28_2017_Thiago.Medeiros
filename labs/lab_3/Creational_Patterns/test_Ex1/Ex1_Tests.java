import org.junit.Test;
import static org.junit.Assert.*;

import fields_1.Address;
import fields_1.Date;
import fields_1.Person;
import letterTypes_1.LetterBuilder;

// Arquivo de testes para o Ex1

public class Ex1_Tests {
	@Test
	public void Comercial() {
		Person person_1 = new Person("thiago@ita.br", "+559200000001", "Thiago");
		Address address_1 = new Address("Rua do H8B, ap. 224");
		
		Person person_2 = new Person("ita@ita.br", "+551200000001", "ITA");
		Address address_2 = new Address("Vila das Acácias, DCTA");
		
		Date date = new Date("01/01/2015");
		
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
	public void Personal() {
		Person person_1 = new Person("John@gmail.com", "+100000001", "John");		
		Person person_2 = new Person("Jack@gmail.com", "+100000001", "Jack");
		
		Date date = new Date("31/12/2017");
		
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
	public void Reader() {
		Person person_1 = new Person("leitor@kawa.jp", "+800000001", "Leitor");
		Person person_2 = new Person("editor@kawa.jp", "+800000002", "Tokyo News");
		
		Date date = new Date("01/05/2010");
		
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