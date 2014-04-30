/**
 *
 */
package com.escalonador.model;

import java.util.concurrent.TimeUnit;

/**
 * A Classe Processo. Cria os processos que são usados pelos escalonadores
 * Implementa comparable para que a lista ordenada consiga entender a diferença
 * entre um processo e outro
 * 
 * @author daniel.fraga
 */
public class Processo implements Comparable<Processo> {

	/** O tempo total execucao. */
	private int totalExecucao;

	/** A prioridade execucao. */
	private Integer prioridadeExecucao;

	/** O id processo. */
	private int idProcesso;

	/** A hora entrada. */
	private long horaEntrada;

	/** A hora termino. */
	private long horaTermino;

	/** A tempo processo. */
	private int tempoProcesso;

	/** A tamanho processo. */
	private Integer tamanhoProcesso;

	/** O modo. */
	private int modo;

	/**
	 * Retorna o tamanho do processo.
	 * 
	 * @return the tamanho processo
	 */
	public Integer getTamanhoProcesso() {
		return tamanhoProcesso;
	}

	/**
	 * Seta o tamanho processo.
	 * 
	 * @param tamanhoProcesso
	 *            o novo tamanho processo
	 */
	public void setTamanhoProcesso(Integer tamanhoProcesso) {
		this.tamanhoProcesso = tamanhoProcesso;
	}

	/** O terminou. */
	private boolean terminou;

	/**
	 * Construtor do processo.
	 * 
	 * @param pid
	 *            o pid, que vira o nome do processo
	 * @param tempoExecucao
	 *            o tempo execucao
	 * @param prioridadeExecucao
	 *            a prioridade execucao
	 * @param modo
	 *            o modo, usado para definição de fila SJF ou Prioridades
	 */
	public Processo(int pid, Integer tempoExecucao, Integer prioridadeExecucao,
			int modo) {
		this.setModo(modo);
		this.idProcesso = pid;
		terminou = false;
		setTotalExecucao(0);
		this.tamanhoProcesso = tempoExecucao;
		this.setPrioridadeExecucao(prioridadeExecucao);
		this.horaEntrada = System.currentTimeMillis();
		this.horaTermino = System.currentTimeMillis();
	}

	/**
	 * Executar processo. Decrementa o tamanho do processo E aumenta o valor de
	 * execucao Também mostra algumas mensagens na tela
	 */
	public void executarProcesso() {
		if (tamanhoProcesso > 0) {
			try {
				Thread.sleep(1000);
				tamanhoProcesso--;
				setTotalExecucao(getTotalExecucao() + 1);
				System.out.println("Processo: " + getPid()
						+ " Executou uma unidade de tempo \n");
				if (tamanhoProcesso == 0) {
					setTerminou();
					System.out.println("Processo: " + getPid()
							+ " Terminou. Tempo total de execucao: "
							+ getTotalExecucao() + "\n"
							+ "Tempo desde que o processo entrou na fila: "
							+ getDataTerminou() + "\n");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Pega o pid.
	 * 
	 * @return o pid
	 */
	private String getPid() {
		return "P" + idProcesso;
	}

	/**
	 * Seta o terminou.
	 */
	private void setTerminou() {
		terminou = true;
		horaTermino = System.currentTimeMillis() - horaEntrada;
	}

	/**
	 * Compare to prioridade.
	 * 
	 * @param prioridade
	 *            the prioridade
	 * @return the int
	 */
	public int compareToPrioridade(Integer prioridade) {
		return getPrioridadeExecucao().compareTo(prioridade);

	}

	/**
	 * Gets the data terminou.
	 * 
	 * @return the data terminou
	 */
	private long getDataTerminou() {
		return TimeUnit.MILLISECONDS.toSeconds(horaTermino);
	}

	/**
	 * Gets the terminou.
	 * 
	 * @return the terminou
	 */
	public boolean getTerminou() {
		return terminou;
	}

	/**
	 * Gets the total execucao.
	 * 
	 * @return the total execucao
	 */
	public int getTotalExecucao() {
		return totalExecucao;

	}

	/**
	 * Sets the total execucao.
	 * 
	 * @param totalExecucao
	 *            the new total execucao
	 */
	public void setTotalExecucao(int totalExecucao) {
		this.totalExecucao = totalExecucao;
	}

	/**
	 * Gets the prioridade execucao.
	 * 
	 * @return the prioridade execucao
	 */
	public Integer getPrioridadeExecucao() {
		return prioridadeExecucao;
	}

	/**
	 * Sets the prioridade execucao.
	 * 
	 * @param prioridadeExecucao
	 *            the new prioridade execucao
	 */
	public void setPrioridadeExecucao(Integer prioridadeExecucao) {
		this.prioridadeExecucao = prioridadeExecucao;
	}

	/**
	 * Gets the tempo processo.
	 * 
	 * @return the tempo processo
	 */
	public int getTempoProcesso() {
		return tempoProcesso;
	}

	/**
	 * Sets the tempo processo.
	 * 
	 * @param tempoProcesso
	 *            the new tempo processo
	 */
	public void setTempoProcesso(int tempoProcesso) {
		this.tempoProcesso = tempoProcesso;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Processo processoComparado) {
		if (getModo() == 0) {
			return getTamanhoProcesso().compareTo(
					processoComparado.getTamanhoProcesso());
		} else {
			if (getPrioridadeExecucao().compareTo(
					processoComparado.getPrioridadeExecucao()) == 0) {
				return 0;
			} else if (getPrioridadeExecucao().compareTo(
					processoComparado.getPrioridadeExecucao()) == -1) {
				return 1;
			} else {
				return -1;
			}
		}

	}

	/**
	 * Gets the modo.
	 * 
	 * @return the modo
	 */
	public int getModo() {
		return modo;
	}

	/**
	 * Reseta a hora em que o processo entrou na fila.
	 */
	public void resetHora() {
		this.horaEntrada = System.currentTimeMillis();
	}

	/**
	 * Seta o modo. O "modo" define se o processo vai retornar o compareTo de
	 * tamanho ou o compareTo de prioridade
	 * 
	 * @param modo
	 *            o novo modo
	 */
	public void setModo(int modo) {
		this.modo = modo;
	}

}