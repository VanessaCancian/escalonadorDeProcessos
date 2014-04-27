/**
 * 
 */
package com.escalonador.controller;

import com.escalonador.model.Processo;
import com.escalonador.view.Console;

/**
 * @author daniel.fraga
 * 
 */
public class Controller {
	Console console;
	FilaDeProcessos filaDeProcessos;
	EscalonadorFIFO escalonadorFifo;

	public Controller() {
		console = new Console();
		filaDeProcessos = new FilaDeProcessos();
		Processo proc1 = new Processo(1, 10, 4);
		Processo proc2 = new Processo(2, 4, 4);
		filaDeProcessos.getFila().add(proc1);
		filaDeProcessos.getFila().add(proc2);
		escalonadorFifo = new EscalonadorFIFO(filaDeProcessos);
		
	}

	public void run() {
		escalonadorFifo.executarFila();
	}

}
