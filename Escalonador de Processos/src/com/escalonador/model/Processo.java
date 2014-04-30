/**
 *
 */
package com.escalonador.model;

/**
 * @author daniel.fraga
 * 
 */
public class Processo implements Comparable<Processo> {
	private int totalExecucao;
	private Integer prioridadeExecucao;
	private int idProcesso;
	private long horaEntrada;
	private long horaTermino;
	private int tempoProcesso;
	private Integer tamanhoProcesso;
	private int modo;

	public Integer getTamanhoProcesso() {
		return tamanhoProcesso;
	}

	public void setTamanhoProcesso(Integer tamanhoProcesso) {
		this.tamanhoProcesso = tamanhoProcesso;
	}

	private boolean terminou;

	public Processo(int pid, Integer tempoExecucao, Integer prioridadeExecucao, int modo) {
		this.setModo(modo);
		this.idProcesso = pid;
		terminou = false;
		setTotalExecucao(0);
		this.tamanhoProcesso = tempoExecucao;
		this.setPrioridadeExecucao(prioridadeExecucao);
		this.horaEntrada = System.currentTimeMillis();
		this.horaTermino = System.currentTimeMillis();
	}

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

	private String getPid() {
		return "P" + idProcesso;
	}

	private void setTerminou() {
		terminou = true;
		horaTermino = System.currentTimeMillis() - horaEntrada;
	}

	public int compareToPrioridade(Integer prioridade) {
		return getPrioridadeExecucao().compareTo(prioridade);

	}

	private long getDataTerminou() {
		return horaTermino;
	}

	public boolean getTerminou() {
		return terminou;
	}

	public int getTotalExecucao() {
		return totalExecucao;
	}

	public void setTotalExecucao(int totalExecucao) {
		this.totalExecucao = totalExecucao;
	}

	public Integer getPrioridadeExecucao() {
		return prioridadeExecucao;
	}

	public void setPrioridadeExecucao(Integer prioridadeExecucao) {
		this.prioridadeExecucao = prioridadeExecucao;
	}

	public int getTempoProcesso() {
		return tempoProcesso;
	}

	public void setTempoProcesso(int tempoProcesso) {
		this.tempoProcesso = tempoProcesso;
	}

	@Override
	public int compareTo(Processo processoComparado) {
		if(getModo() == 0){
			return getTamanhoProcesso().compareTo(processoComparado.getTamanhoProcesso());	
		} else {
			if(getPrioridadeExecucao().compareTo(processoComparado.getPrioridadeExecucao()) == 0){
				return 0;
			} else if (getPrioridadeExecucao().compareTo(processoComparado.getPrioridadeExecucao()) == -1){
				return 1;
			} else {
				return -1;
			}
		}
		
	}

	public int getModo() {
		return modo;
	}

	public void resetHora(){
		this.horaEntrada = System.currentTimeMillis();
	}
	public void setModo(int modo) {
		this.modo = modo;
	}
	

}