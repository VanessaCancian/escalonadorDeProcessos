package com.escalonador.controller;

import com.escalonador.model.ListaEncadeada;
import com.escalonador.model.Processo;


/**
 * A Classe EscalonadorRoundRobin.
 * Ela herda suas propriedades da classe EscalonadorGeral
 */
public class EscalonadorRoundRobin extends EscalonadorGeral {
	
	/**
	 * Instantiates a new escalonador round robin.
	 *
	 * @param filaDeProcessos2 the fila de processos2
	 */
	public EscalonadorRoundRobin(ListaEncadeada<Processo> filaDeProcessos2) {
		super(filaDeProcessos2);
	}
	
	/* (non-Javadoc)
	 * @see com.escalonador.controller.EscalonadorGeral#rodarProcesso(com.escalonador.model.Processo)
	 */
	//Este método foi implementado para sobrescrever o metodo pai, e diminuir o ciclo maximo de processamento para 1
	public void rodarProcesso(Processo proc){
		while (!proc.getTerminou()) {
			if (cicloExecutado < 1) {
				processoExecutando.executarProcesso();
				cicloExecutado++;
			} else {
				break;
			}
		}
		
	}
	

}
