package letterTypes_1;
import fields_1.*;

// Para a demo, foram criados 3 tipos de carta:
//     - Carta Comercial;
//     - Carta Pessoal;
//     - Carta do Leitor;

// Dentro de cada metodo é possivel realizar alguma manipulaçao adicional, se necessario

public class LetterBuilder {
	// Carta Comercial
	public String ComercialModel(Person sender, Person destinatary, Address addressSender, Address addressDestiny, Date date) {
		ComercialLetter newLetter = new ComercialLetter(sender, destinatary, addressSender, addressDestiny, date);
		return newLetter.model();
	}
	
	// Carta Pessoal
	public String PersonalModel(Person sender, Person destinatary, Date date) {
		PersonalLetter newLetter = new PersonalLetter(sender, destinatary, date);
		return newLetter.model();
	}
	
	// Carta do Leitor
	public String ReaderModel(Person sender, Person destinatary, Date date) {
		ReaderLetter newLetter = new ReaderLetter(sender, destinatary, date);
		return newLetter.model();
	}
}

// Para adicionar um novo tipo de carta, basta adicionar a nova classe ao pacote "letterTypes"
// e criar um metodo correspondente em "LetterBuilder" para a instanciaçao. Para instanciar, 
// basta criar um objeto do tipo "LetterBuilder" e invocar o metodo correspondente para instan-
// ciaçao.
//
// Por exemplo:
//     LetterBuilder builder = new LetterBuilder(); // cria o builder 
//     String modeloDesejado = builder.tipoDesejadoModel(...) // instancia o modelo desejado