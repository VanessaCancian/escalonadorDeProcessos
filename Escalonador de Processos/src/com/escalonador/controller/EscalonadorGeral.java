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
		Nodo<Processo> nodoAtual = filaProcessos.getHead();
		
		while ((filaProcessos.getTail() != null)) {
			processoExecutando = nodoAtual.getData();
			processoExecutando.executarProcesso();
			while (!processoExecutando.getTerminou()) {
				processoExecutando.executarProcesso();
			}
			Nodo<Processo> nodoNext = nodoAtual.getNext();
			filaProcessos.remove(nodoAtual);
			nodoAtual = nodoNext;
			
		}
		System.out.println(" Finalizado");
	}
}
