package com.escalonador.model;

/**
 * The Class ListaEncadeada.
 * 
 * @param <T>
 *            the generic type
 */
public class ListaEncadeada<T> {

	/** The head. */
	protected Nodo<T> head;

	/** The tail. */
	protected Nodo<T> tail;

	/**
	 * Instantiates a new lista encadeada.
	 */
	public ListaEncadeada() {
		head = null;
		tail = null;
	}

	public void remove(Nodo<T> nodo) {
		Nodo<T> ant = nodo.getPrevious();
		Nodo<T> next = nodo.getNext();
		if (ant != null)
			ant.setNext(next);
		else
			head = next;
		if (next != null)
			next.setPrevious(ant);
		else
			tail = ant;
	}

	/**
	 * Insert.
	 * 
	 * @param novo
	 *            the novo
	 */
	public void insert(Nodo<T> novo) {
		novo.setNext(head);
		if (head != null)
			head.setPrevious(novo);
		head = novo;
		if (tail == null)
			tail = novo;
	}

	/**
	 * Insert.
	 * 
	 * @param novo
	 *            the novo
	 * @param anterior
	 *            the anterior
	 */
	public void insert(Nodo<T> novo, Nodo<T> anterior) {
		if (anterior == null) {
			novo.setNext(head);
			head = novo;
			if (tail == null)
				tail = head;
		} else {
			novo.setNext(anterior.getNext());
			novo.setPrevious(anterior);
			anterior.setNext(novo);
			if (anterior == tail)
				tail = novo;
		}
	}

	/**
	 * Append.
	 * 
	 * @param novo
	 *            the novo
	 */
	public void append(Nodo<T> novo) {
		if (tail != null) {
			tail.setNext(novo);
			novo.setPrevious(tail);
		} else {
			head = novo;
		}
		tail = novo;
	}

	/**
	 * Gets the tail.
	 * 
	 * @return the tail
	 */
	public Nodo<T> getTail() {
		return tail;
	}

	/**
	 * Gets the head.
	 * 
	 * @return the head
	 */
	public Nodo<T> getHead() {
		return head;
	}

}