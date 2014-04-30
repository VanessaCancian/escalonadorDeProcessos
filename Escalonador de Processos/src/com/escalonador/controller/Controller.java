/**
 * 
 */
package com.escalonador.controller;

import com.escalonador.model.*;
import com.escalonador.view.Console;

public class Controller {
	private Console console;
	private int quantidadeProcessos = 0;
	private int prioridadeProcesso = 0;
	private int tamanhoProcesso = 0;
	private EscalonadorGeral escalonador;

	public Controller() {
		console = new Console();
		escolherEscalonador(console.escolherEscalonador());
	}

	private void escolherEscalonador(int escolha2) {
		switch (escolha2) {
		case 1:
			usarEscalonadorFifo();
			break;
		case 2:
			usarEscalonadorSJF();
			break;
		case 3:
			usarEscalonadorPrioridades();
		case 4:
			usarEscalonadorRoundRobin();
			break;
		default:
			break;
		}

	}

	private void usarEscalonadorRoundRobin() {

	}

	private void usarEscalonadorPrioridades() {
		ListaSJB<Processo> listaDeProcessos = new ListaSJB<Processo>();
		criarProcessos(0, listaDeProcessos);
		EscalonadorGeral escalonadorSJF = new EscalonadorGeral(listaDeProcessos);
		resetarHora(listaDeProcessos);
		escalonadorSJF.executarFila();
	}

	private void usarEscalonadorSJF() {
		ListaSJB<Processo> listaDeProcessos = new ListaSJB<Processo>();
		criarProcessos(1, listaDeProcessos);
		EscalonadorGeral escalonadorSJF = new EscalonadorGeral(listaDeProcessos);
		resetarHora(listaDeProcessos);
		escalonadorSJF.executarFila();
	}

	private void criarProcessos(int i, ListaSJB<Processo> listaDeProcessos) {
		quantidadeProcessos = console.lerQuantidadeProcessos();
		for (int y = 0; y < quantidadeProcessos; y++) {
			console.lerProcessosDoUsuario(y);
			prioridadeProcesso = console.getPrioridadeProcesso();
			tamanhoProcesso = console.getTamanhoProcesso();
			System.out.println(y);
			listaDeProcessos.append(new Nodo<Processo>(new Processo(y,
					tamanhoProcesso, prioridadeProcesso, i)));
		}
	}

	private void usarEscalonadorFifo() {
		ListaEncadeada<Processo> listaDeProcessos = new ListaEncadeada<Processo>();
		quantidadeProcessos = console.lerQuantidadeProcessos();
		for (int i = 0; i < quantidadeProcessos; i++) {
			System.out.println(i);
			console.lerProcessosDoUsuario(i);
			prioridadeProcesso = console.getPrioridadeProcesso();
			tamanhoProcesso = console.getTamanhoProcesso();
			listaDeProcessos.append(new Nodo<Processo>(new Processo(i,
					tamanhoProcesso, prioridadeProcesso, 0)));
		}
		Nodo<Processo> nodoAtual = listaDeProcessos.getHead();

		while (nodoAtual != listaDeProcessos.getTail()) {
			nodoAtual.getData().resetHora();
			nodoAtual = nodoAtual.getNext();
		}
		EscalonadorGeral escalonadorFifo = new EscalonadorGeral(
				listaDeProcessos);
		escalonadorFifo.executarFila();

	}

	public void resetarHora(ListaSJB<Processo> lista) {
		Nodo<Processo> nodoAtual = lista.getHead();

		while (nodoAtual != lista.getTail()) {
			nodoAtual.getData().resetHora();
			nodoAtual = nodoAtual.getNext();
		}
	}

	public void run() {
		escalonador.executarFila();
	}

}
