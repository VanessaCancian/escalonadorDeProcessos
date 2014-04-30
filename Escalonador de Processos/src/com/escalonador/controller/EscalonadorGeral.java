package com.escalonador.controller;

import com.escalonador.model.ListaEncadeada;
import com.escalonador.model.Nodo;
import com.escalonador.model.Processo;

public class EscalonadorGeral {
	private ListaEncadeada<Processo> filaProcessos;
	protected Processo processoExecutando;
	protected int cicloExecutado = 0;
	public EscalonadorGeral(ListaEncadeada<Processo> filaDeProcessos2) {
		this.filaProcessos = filaDeProcessos2;
	}

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
	public void executarFila() {
		Nodo<Processo> nodoAtual = filaProcessos.getHead();
		while ((filaProcessos.getTail() != null)) {
			processoExecutando = nodoAtual.getData();
			processoExecutando.executarProcesso();
			
			rodarProcesso(processoExecutando);

			Nodo<Processo> nodoNext = nodoAtual.getNext();
			if (nodoAtual.getData().getTerminou()) {
				filaProcessos.remove(nodoAtual);
				cicloExecutado = 0;
				if (nodoNext != null) {
					nodoAtual = nodoNext;
				} else {
					nodoAtual = filaProcessos.getHead();
				}
			} else if (nodoAtual == filaProcessos.getTail() && nodoAtual == filaProcessos.getHead()) {
				cicloExecutado = 0;
			} else {
				if(nodoNext != null){
					nodoAtual = nodoNext;	
				} else {
					nodoAtual = filaProcessos.getHead();
				}
				cicloExecutado = 0;
			}

		}

		System.out.println("Finalizado");
	}
}
