/**
 * 
 */
package com.escalonador.model;

/**
 * @author daniel.fraga
 * 
 */
public class Processo {
	private int tempoExecucao;
	private int prioridadeExecucao;
	private int idProcesso;
	private long horaEntrada;
	private long horaTermino;
	private int tempoProcesso;
	private int prioridadeProcesso;
	private int cicloExecucao;
	private boolean terminou;

	public Processo(int pid, int tempoExecucao, int prioridadeExecucao) {
		this.idProcesso = pid;
		terminou = false;
		this.tempoExecucao = tempoExecucao;
		this.cicloExecucao = tempoExecucao;
		this.prioridadeExecucao = prioridadeExecucao;
		this.horaEntrada = System.currentTimeMillis();
		this.horaTermino = System.currentTimeMillis();
	}

	public void executarProcesso() {
		if (cicloExecucao > 0) {
			try {
				Thread.sleep(1000);
				cicloExecucao--;
				System.out.println("Processo :" + getPid() + "Executou uma unidade de tempo \n");
				if (cicloExecucao == 0) {
					setTerminou();
					System.out.println("Processo: " + getPid() + "Terminou. Tempo total de execucao: " + getDataTerminou());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private String getPid() {
		return "P" + idProcesso;
	}

	private void setTerminou() {
		terminou = true;
		horaTermino = System.currentTimeMillis() - horaEntrada;
	}

	private long getDataTerminou() {
		return horaTermino;
	}

	public boolean getTerminou() {
		return terminou;
	}

}
