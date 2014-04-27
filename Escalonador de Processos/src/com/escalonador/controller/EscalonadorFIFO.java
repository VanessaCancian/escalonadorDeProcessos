package com.escalonador.controller;

import java.util.LinkedList;

import com.escalonador.model.Processo;

public class EscalonadorFIFO {
	private FilaDeProcessos filaDeProcessos;
	private LinkedList<Processo> filaProcessos;
	private Processo processoExecutando;

	public EscalonadorFIFO(FilaDeProcessos filaDeProcessos2) {
		this.filaDeProcessos = filaDeProcessos2;
		this.filaProcessos = filaDeProcessos.getFila();

	}

	public void executarFila() {
		while(filaProcessos.size() > 0){
			processoExecutando = filaProcessos.getFirst();
			while (!processoExecutando.getTerminou()) {
				processoExecutando.executarProcesso();
			}
			filaProcessos.removeFirst();
		}
	}

}
