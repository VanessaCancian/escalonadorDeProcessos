package com.escalonador.controller;

import com.escalonador.model.ListaEncadeada;
import com.escalonador.model.Processo;


public class EscalonadorRoundRobin extends EscalonadorGeral {
	public EscalonadorRoundRobin(ListaEncadeada<Processo> filaDeProcessos2) {
		super(filaDeProcessos2);
	}
	
	public void rodarProcesso(Processo proc){
		while (!proc.getTerminou()) {
			if (cicloExecutado < 0) {
				processoExecutando.executarProcesso();
				cicloExecutado++;
			} else {
				break;
			}
		}
		
	}
	

}
