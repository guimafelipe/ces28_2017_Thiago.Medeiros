package Modificado;

import java.util.Iterator;

public class RelatorioDespesas {
	Impressora impressora_;

	public RelatorioDespesas(Impressora impressora) {
		impressora_ = impressora;
	}
	
	public void ImprimirRelatorio(Iterator<Despesa> despesas) {
		float totalDespesa = Calculadora.calcula(despesas);

		String conteudo = "Relatório de Despesas";
		conteudo += ("\n Total das despesas:" + totalDespesa);
		
		impressora_.Imprimir(conteudo);
	}
}