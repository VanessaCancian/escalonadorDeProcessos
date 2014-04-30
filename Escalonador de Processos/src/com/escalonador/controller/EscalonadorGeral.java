package com.escalonador.controller;

import com.escalonador.model.ListaEncadeada;
import com.escalonador.model.Nodo;
import com.escalonador.model.Processo;

/**
 * The Class EscalonadorGeral.
 * Responsável por todos os escalonadores exceto o RoundRobin
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
	 * Lê os processos da fila e os executa
	 */
	public void executarFila() {
		//Pega o processo que está no topo da fila
		Nodo<Processo> nodoAtual = filaProcessos.getHead();
		//Enquanto a fila não acabar
		while ((filaProcessos.getTail() != null)) {
			//Pega o processo
			processoExecutando = nodoAtual.getData();
			//roda o mesmo
			rodarProcesso(processoExecutando);
			//Pega o proximo processo da fila, já que o ciclo de execução terminou
			Nodo<Processo> nodoNext = nodoAtual.getNext();
			//Se o processo atual terminou
			if (nodoAtual.getData().getTerminou()) {
				//remove o processo atual
				filaProcessos.remove(nodoAtual);
				//Zera o ciclo de execução para não afetar o proximo processo da fila
				cicloExecutado = 0;
				//Se o processo depois do atual NÃO for nulo, troca o processo atual pelo proximo da fila
				if (nodoNext != null) {
					nodoAtual = nodoNext;
					//Se não, estamos no final da fila. voltamos ao inicio.
				} else {
					nodoAtual = filaProcessos.getHead();
				}
				//Se o nodo atual for o fim da lista, e o nodo atual também for o inicio da lista, estamos no ultimo membro
			} else if (nodoAtual == filaProcessos.getTail() && nodoAtual == filaProcessos.getHead()) {
				//zeramos o ciclo de execução para que ele rode até terminar
				cicloExecutado = 0;
			} else {
				//Se não terminou, não está no final, e não é o ultimo membro, então pegamos o proximo processo
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
