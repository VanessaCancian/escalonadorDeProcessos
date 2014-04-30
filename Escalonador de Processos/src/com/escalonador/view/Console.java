/**
 * 
 */
package com.escalonador.view;

import java.util.Scanner;

/**
 * The Class Console.
 *
 * @author daniel.fraga
 */
public class Console {
	
	/** The scan. */
	private Scanner scan;
	
	/** The tamanho processo. */
	private int tamanhoProcesso;
	
	/** The prioridade processo. */
	private int prioridadeProcesso;

	/**
	 * Instantiates a new console.
	 */
	public Console() {
		scan = new Scanner(System.in);
		mostrarMensagem();
	}

	/**
	 * Mostrar mensagem.
	 */
	private void mostrarMensagem() {
		System.out.println("Bem vindo ao escalonador de processos java \n");
	}

	/**
	 * Ler processos do usuario.
	 *
	 * @param numeroDoProcesso the numero do processo
	 */
	public void lerProcessosDoUsuario(int numeroDoProcesso) {
		System.out.println("Digite o tamanho do processo P" + numeroDoProcesso
				+ "\n");
		setTamanhoProcesso(scan.nextInt());
		System.out.println("Digite a prioridade do processo P"
				+ numeroDoProcesso + "\n");
		setPrioridadeProcesso(scan.nextInt());
	}

	/**
	 * Ler quantidade processos.
	 *
	 * @return the int
	 */
	public int lerQuantidadeProcessos() {
		System.out.println("Digite o numero de processos que deseja criar \n");
		return scan.nextInt();
	}

	/**
	 * Gets the prioridade processo.
	 *
	 * @return the prioridade processo
	 */
	public int getPrioridadeProcesso() {
		return prioridadeProcesso;
	}

	/**
	 * Sets the prioridade processo.
	 *
	 * @param prioridadeProcesso the new prioridade processo
	 */
	public void setPrioridadeProcesso(int prioridadeProcesso) {
		this.prioridadeProcesso = prioridadeProcesso;
	}

	/**
	 * Gets the tamanho processo.
	 *
	 * @return the tamanho processo
	 */
	public int getTamanhoProcesso() {
		return tamanhoProcesso;
	}

	/**
	 * Sets the tamanho processo.
	 *
	 * @param tamanhoProcesso the new tamanho processo
	 */
	public void setTamanhoProcesso(int tamanhoProcesso) {
		this.tamanhoProcesso = tamanhoProcesso;
	}

	/**
	 * Escolher escalonador.
	 *
	 * @return the int
	 */
	public int escolherEscalonador() {
		System.out.println("Escolha o escalonador a ser usado: \n" + "1: FIFO \n"
				+ "2: SJF - Menor processo primeiro \n"
				+ "3: Prioridades - Prioridade maior executa primeiro \n"
				+ "4: Round-Robin / Circular\n"
				+ "(Digite o numero)");
		return scan.nextInt();
	}

}
