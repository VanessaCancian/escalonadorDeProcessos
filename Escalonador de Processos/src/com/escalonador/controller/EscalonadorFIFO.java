package com.escalonador.controller;

import com.escalonador.model.ListaEncadeada;
import com.escalonador.model.Nodo;
import com.escalonador.model.Processo;

public class EscalonadorFIFO {
	private ListaEncadeada<Processo> filaDeProcessos;
	private ListaEncadeada<Processo> filaProcessos;
	private Processo processoExecutando;

	public EscalonadorFIFO(ListaEncadeada<Processo> filaDeProcessos2) {
		this.filaProcessos = filaDeProcessos2;
	}

	public void executarFila() {
		while (filaProcessos.getHead() != null) {
			Nodo NodoProcessoExecutando = filaProcessos.getHead();
			processoExecutando = (Processo) NodoProcessoExecutando.getChave();
			processoExecutando.executarProcesso();

			while (!processoExecutando.getTerminou()) {
				processoExecutando.executarProcesso();

			}
			filaProcessos.remove(NodoProcessoExecutando);
			;
		}
	}

}
