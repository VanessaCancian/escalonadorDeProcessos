/**
 * 
 */
package com.escalonador.controller;

import com.escalonador.model.*;
import com.escalonador.view.Console;

/**
 * @author daniel.fraga
 * 
 */
public class Controller {
	Console console;
	EscalonadorFIFO escalonadorFifo;
	private ListaEncadeada<Processo> filaDeProcessos;

	public Controller() {
		filaDeProcessos = new ListaEncadeada<Processo>();
		console = new Console();
		Processo proc1 = new Processo(1, 10, 4);
		Processo proc2 = new Processo(2, 4, 4);
		Nodo<Processo> proc1 = new Nodo<Processo>(proc1);
		//filaDeProcessos.getFila().append(novo);
		//filaDeProcessos.getFila().add(proc2);
		escalonadorFifo = new EscalonadorFIFO(filaDeProcessos);
		
	}

	public void run() {
		escalonadorFifo.executarFila();
	}

}
