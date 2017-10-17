package letterTypes_1;
import fields_1.Address;
import fields_1.Date;
import fields_1.Person;

// Classe abstrata de onde todos os tipos derivam.

// Todas as classes "Letter" possuem os atributos: 
//      - sender_ (remetente);
//      - destinatary_ (destinatario);
//      - addressSender_ (endereço do remetente); 
//      - addressDestiny_ (endereço do destinatario);
//      - date_ (data de envio da carta);

// Todas as classes "Letter" possuem os metodos:
//      - header (cabeçalho);
//      - body (corpo);
//      - conclusion (conclusao);
//      - signature (assinatura);
//      - model (modelo);

// Todos os metodos podem ser sobrescritos, em prol das peculiaridades de 
// cada tipo de carta. Porem, todos os metodos sao obrigatorios nos tipos
// de carta.

abstract class Letter {
	protected Person  sender_;
	protected Person  destinatary_;
	protected Address addressSender_;
	protected Address addressDestiny_;
	protected Date    date_; 

	public String model() {
		return header() + body() + conclusion() + signature();
	}
	
	protected String header()     { return ""; }
	protected String body()       { return ""; }
	protected String conclusion() { return ""; }
	protected String signature()  { return ""; }
} 