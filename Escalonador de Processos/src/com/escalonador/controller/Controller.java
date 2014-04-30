/**
 * 
 */
package com.escalonador.controller;

import com.escalonador.model.*;
import com.escalonador.view.Console;

/**
 * Classe Controller Responsável por instanciar os escalonadores e as listas de
 * processos Também recebe os parametros de usuário que vem do Console
 */
public class Controller {

	/** O console. */
	private Console console;

	/** A quantidade processos. */
	private int quantidadeProcessos = 0;

	/** A prioridade de processos. */
	private int prioridadeProcesso = 0;

	/** O tamanho processo. */
	private int tamanhoProcesso = 0;

	/**
	 * Contrutor controller. Instancia o console e pede para o usuário qual
	 * escalonador ele quer
	 */
	public Controller() {
		console = new Console();
		escolherEscalonador(console.escolherEscalonador());
	}

	/**
	 * Escolher escalonador. Recebe a entrada do console e executa de acordo
	 * 
	 * @param escolha2
	 *            a escolha do usuário
	 */
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

	/**
	 * Usar escalonador round robin. Cria uma lista encadeada em que o maximo de
	 * ciclos que podem ser executados por processo é 1. É quase igual ao FIFO
	 */
	private void usarEscalonadorRoundRobin() {
		// Cria nova lista
		ListaEncadeada<Processo> listaDeProcessos = new ListaEncadeada<Processo>();
		// Lê os processos
		quantidadeProcessos = console.lerQuantidadeProcessos();
		for (int i = 0; i < quantidadeProcessos; i++) {
			console.lerProcessosDoUsuario(i);
			prioridadeProcesso = console.getPrioridadeProcesso();
			tamanhoProcesso = console.getTamanhoProcesso();
			listaDeProcessos.append(new Nodo<Processo>(new Processo(i,
					tamanhoProcesso, prioridadeProcesso, 0)));
		}
		Nodo<Processo> nodoAtual = listaDeProcessos.getHead();
		// faz um Reset do tempo em que cada processo entrou na fila
		while (nodoAtual != listaDeProcessos.getTail()) {
			nodoAtual.getData().resetHora();
			nodoAtual = nodoAtual.getNext();
		}
		// Instancia e roda o escalonador
		EscalonadorRoundRobin escalonadorRoundRobin = new EscalonadorRoundRobin(
				listaDeProcessos);
		escalonadorRoundRobin.executarFila();

	}

	/**
	 * Usar escalonador prioridades. O escalonador por prioridades foi
	 * implementado de forma em que ele mesmo é "burro", ou seja, ele não sabe
	 * qual a prioridade dos processos. Quem ordena os processo por prioridade é
	 * a lista ordenada, chamada ListaSJB.
	 * 
	 */

	private void usarEscalonadorPrioridades() {
		ListaSJB<Processo> listaDeProcessos = new ListaSJB<Processo>();
		criarProcessos(0, listaDeProcessos);
		EscalonadorGeral escalonadorSJF = new EscalonadorGeral(listaDeProcessos);
		resetarHora(listaDeProcessos);
		escalonadorSJF.executarFila();
	}

	/**
	 * Usar escalonador sjf. O escalonador SJF foi implementado de forma em que
	 * ele mesmo é "burro", ou seja, ele não sabe qual é o tamanho dos
	 * processoss. Quem ordena os processo por tamanho é a lista ordenada,
	 * chamada ListaSJB.
	 */
	private void usarEscalonadorSJF() {
		ListaSJB<Processo> listaDeProcessos = new ListaSJB<Processo>();
		criarProcessos(1, listaDeProcessos);
		EscalonadorGeral escalonadorSJF = new EscalonadorGeral(listaDeProcessos);
		resetarHora(listaDeProcessos);
		escalonadorSJF.executarFila();
	}

	/**
	 * Criar processos.
	 * 
	 * @param i
	 *            O i que é o identificador de qual processo queremos criar (1 = p1, 2 = p2)
	 * @param listaDeProcessos
	 *            A lista de processos
	 */
	private void criarProcessos(int i, ListaSJB<Processo> listaDeProcessos) {
		quantidadeProcessos = console.lerQuantidadeProcessos();
		for (int y = 0; y < quantidadeProcessos; y++) {
			console.lerProcessosDoUsuario(y);
			prioridadeProcesso = console.getPrioridadeProcesso();
			tamanhoProcesso = console.getTamanhoProcesso();
			listaDeProcessos.append(new Nodo<Processo>(new Processo(y,
					tamanhoProcesso, prioridadeProcesso, i)));
		}
	}

	/**
	 * Usar escalonador fifo.
	 * O escalonador FIFO age em uma lista encadeada simples, sem ordenação.
	 * Ele vai agir na lista de acordo com a ordem de entrada dos processos
	 * mas respeitando a questão de quando passa de 2 ciclos de processamento
	 * ele pula para o proximo.
	 */
	private void usarEscalonadorFifo() {
		ListaEncadeada<Processo> listaDeProcessos = new ListaEncadeada<Processo>();
		quantidadeProcessos = console.lerQuantidadeProcessos();
		for (int i = 0; i < quantidadeProcessos; i++) {
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

	/**
	 * Resetar hora.
	 * Reseta a hora em que os processos entraram na fila
	 * @param lista
	 *            a lista
	 */
	public void resetarHora(ListaSJB<Processo> lista) {
		Nodo<Processo> nodoAtual = lista.getHead();

		while (nodoAtual != lista.getTail()) {
			nodoAtual.getData().resetHora();
			nodoAtual = nodoAtual.getNext();
		}
	}

	/**
	 * Run.
	 */
	public void run() {
		//era usado mas foi desativado.
	}

}
