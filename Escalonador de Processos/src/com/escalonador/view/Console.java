/**
 * 
 */
package com.escalonador.view;

import java.util.Scanner;

/**
 * @author daniel.fraga
 * 
 */
public class Console {
	private Scanner scan;
	private int tamanhoProcesso;
	private int prioridadeProcesso;

	public Console() {
		scan = new Scanner(System.in);
		mostrarMensagem();
	}

	private void mostrarMensagem() {
		System.out.println("Bem vindo ao escalonador de processos java \n");
	}

	public void lerProcessosDoUsuario(int numeroDoProcesso) {
		System.out.println("Digite o tamanho do processo P" + numeroDoProcesso
				+ "\n");
		setTamanhoProcesso(scan.nextInt());
		System.out.println("Digite a prioridade do processo P"
				+ numeroDoProcesso + "\n");
		setPrioridadeProcesso(scan.nextInt());
	}

	public int lerQuantidadeProcessos() {
		System.out.println("Digite o numero de processos que deseja criar \n");
		return scan.nextInt();
	}

	public int getPrioridadeProcesso() {
		return prioridadeProcesso;
	}

	public void setPrioridadeProcesso(int prioridadeProcesso) {
		this.prioridadeProcesso = prioridadeProcesso;
	}

	public int getTamanhoProcesso() {
		return tamanhoProcesso;
	}

	public void setTamanhoProcesso(int tamanhoProcesso) {
		this.tamanhoProcesso = tamanhoProcesso;
	}

	public int escolherEscalonador() {
		System.out.println("Escolha o escalonador a ser usado: " + "1: FIFO \n"
				+ "2: SJF - Menor processo primeiro \n"
				+ "3: Prioridades - Prioridade maior executa primeiro \n"
				+ "4: Round-Robin / Circular\n");
		return scan.nextInt();
	}

}
