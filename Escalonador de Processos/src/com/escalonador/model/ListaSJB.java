package com.escalonador.model;

/**
 * A Classe ListaSJB. Esta classe implementa uma lista ordenada, que de acordo
 * com o parametro de processo ordena a lista por tamanho ou prioridade do
 * processo. Essa implementação permite que o nosso escalonador seja "burro",
 * pois a "inteligencia" de execução de processos está na fila.
 * 
 * @param <T>
 *            the generic type
 */
public class ListaSJB<T extends Comparable<T>> extends ListaEncadeada<T> {

	/** The modo operacao. */
	private int modoOperacao = 0;

	/**
	 * Procura nodo.
	 * 
	 * @param needle
	 *            the needle
	 * @return the nodo
	 */
	public Nodo<T> procuraNodo(Nodo<T> needle) {
		Nodo<T> atual = getHead();
		Nodo<T> anterior = null;
		T chaveNeedle = needle.getData();

		while (atual != null) {
			T chaveAtual = atual.getData();
			int cmp = chaveNeedle.compareTo(chaveAtual);
			if (cmp == 0)
				return atual;
			if (cmp < 0)
				return anterior;
			anterior = atual;
			atual = atual.getNext();
		}
		return anterior;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.escalonador.model.ListaEncadeada#append(com.escalonador.model.Nodo)
	 */
	@Override
	public void append(Nodo<T> novo) {
		insert(novo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.escalonador.model.ListaEncadeada#insert(com.escalonador.model.Nodo,
	 * com.escalonador.model.Nodo)
	 */
	@Override
	public void insert(Nodo<T> novo, Nodo<T> anterior) {
		insert(novo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.escalonador.model.ListaEncadeada#insert(com.escalonador.model.Nodo)
	 */
	@Override
	public void insert(Nodo<T> novo) {
		Nodo<T> anterior = procuraNodo(novo);

		if (anterior == null) {
			novo.setNext(head);
			if (head != null)
				head.setPrevious(novo);
			head = novo;
			if (tail == null)
				tail = novo;
		} else {
			Nodo<T> prox = anterior.getNext();
			novo.setNext(prox);
			novo.setPrevious(anterior);
			anterior.setNext(novo);
			if (tail == anterior)
				tail = novo;
			else
				prox.setPrevious(novo);
		}
	}

	/**
	 * Gets the modo operacao.
	 * 
	 * @return the modo operacao
	 */
	public int getModoOperacao() {
		return modoOperacao;
	}

	/**
	 * Sets the modo operacao.
	 * 
	 * @param modoOperacao
	 *            the new modo operacao
	 */
	public void setModoOperacao(int modoOperacao) {
		this.modoOperacao = modoOperacao;
	}
}