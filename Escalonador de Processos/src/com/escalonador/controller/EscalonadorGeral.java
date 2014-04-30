package com.escalonador.controller;

import com.escalonador.model.ListaEncadeada;
import com.escalonador.model.Nodo;
import com.escalonador.model.Processo;

public class EscalonadorGeral {
	private ListaEncadeada<Processo> filaProcessos;
	private Processo processoExecutando;

	public EscalonadorGeral(ListaEncadeada<Processo> filaDeProcessos2) {
		this.filaProcessos = filaDeProcessos2;
	}

	public void executarFila() {
		Nodo<Processo> NodoProcessoExecutando = filaProcessos.getHead();
		
		while (!(NodoProcessoExecutando == filaProcessos.getTail())) {
			processoExecutando = NodoProcessoExecutando.getData();
			processoExecutando.executarProcesso();
			while (!processoExecutando.getTerminou()) {
				processoExecutando.executarProcesso();
			}
			filaProcessos.remove(NodoProcessoExecutando);
			System.out.println("Das");
		}
	}

}
