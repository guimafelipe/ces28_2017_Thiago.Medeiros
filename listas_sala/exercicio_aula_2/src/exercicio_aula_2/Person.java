package exercicio_aula_2;

public class Person {
	Person() { id = nextId++; }
	protected int getId() { return id; }
	   			
	private int id;
	private static int nextId = 0;
}