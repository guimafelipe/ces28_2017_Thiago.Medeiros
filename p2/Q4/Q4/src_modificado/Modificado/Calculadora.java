package Modificado;

import java.util.Iterator;

public class Calculadora {
	public static float calcula(Iterator<Despesa> despesas) {
		float totalDespesa = 0.0f;
		
		while (despesas.hasNext()) {
			Despesa desp = despesas.next();
			totalDespesa += desp.getDespesa();
		}		
		
		return totalDespesa;
	}
}