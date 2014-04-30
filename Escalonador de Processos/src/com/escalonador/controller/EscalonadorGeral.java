package com.escalonador.controller;

import com.escalonador.model.ListaEncadeada;
import com.escalonador.model.Nodo;
import com.escalonador.model.Processo;

/**
 * The Class EscalonadorGeral.
 * Respons�vel por todos os escalonadores exceto o RoundRobin
 */
public class EscalonadorGeral {
	
	/** A fila processos. */
	private ListaEncadeada<Processo> filaProcessos;
	
	/** O processo executando. */
	protected Processo processoExecutando;
	
	/** O ciclo executado. */
	protected int cicloExecutado = 0;
	
	/**
	 * Constructor do escalonador geral.
	 *
	 * @param filaDeProcessos2 recebe a fila de processos
	 */
	public EscalonadorGeral(ListaEncadeada<Processo> filaDeProcessos2) {
		this.filaProcessos = filaDeProcessos2;
	}

	/**
	 * Rodar processo.
	 * Executa um processo por 2 ciclos
	 *
	 * @param proc the proc
	 */
	public void rodarProcesso(Processo proc){
		while (!proc.getTerminou()) {
			if (cicloExecutado < 2) {
				processoExecutando.executarProcesso();
				cicloExecutado++;
			} else {
				break;
			}
		}
	}
	
	/**
	 * Executar fila.
	 * L� os processos da fila e os executa
	 */
	public void executarFila() {
		//Pega o processo que est� no topo da fila
		Nodo<Processo> nodoAtual = filaProcessos.getHead();
		//Enquanto a fila n�o acabar
		while ((filaProcessos.getTail() != null)) {
			//Pega o processo
			processoExecutando = nodoAtual.getData();
			//roda o mesmo
			rodarProcesso(processoExecutando);
			//Pega o proximo processo da fila, j� que o ciclo de execu��o terminou
			Nodo<Processo> nodoNext = nodoAtual.getNext();
			//Se o processo atual terminou
			if (nodoAtual.getData().getTerminou()) {
				//remove o processo atual
				filaProcessos.remove(nodoAtual);
				//Zera o ciclo de execu��o para n�o afetar o proximo processo da fila
				cicloExecutado = 0;
				//Se o processo depois do atual N�O for nulo, troca o processo atual pelo proximo da fila
				if (nodoNext != null) {
					nodoAtual = nodoNext;
					//Se n�o, estamos no final da fila. voltamos ao inicio.
				} else {
					nodoAtual = filaProcessos.getHead();
				}
				//Se o nodo atual for o fim da lista, e o nodo atual tamb�m for o inicio da lista, estamos no ultimo membro
			} else if (nodoAtual == filaProcessos.getTail() && nodoAtual == filaProcessos.getHead()) {
				//zeramos o ciclo de execu��o para que ele rode at� terminar
				cicloExecutado = 0;
			} else {
				//Se n�o terminou, n�o est� no final, e n�o � o ultimo membro, ent�o pegamos o proximo processo
				if(nodoNext != null){
					nodoAtual = nodoNext;
					//checagem adicional, procavelmente poderia ser retirada
				} else {
					nodoAtual = filaProcessos.getHead();
				}
				//zera o ciclo de processamento
				cicloExecutado = 0;
			}

		}

		System.out.println("Finalizado");
	}
}
