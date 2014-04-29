package com.escalonador.model;

/**
 * The Class Nodo.
 * 
 * @param <T>
 *            the generic type
 */
public class Nodo<T> {

	/** The chave. */
	private T chave;

	/** The next. */
	private Nodo<T> next;
	private Nodo<T> prev;

	/**
	 * Instantiates a new nodo.
	 * 
	 * @param i
	 *            the i
	 */
	public Nodo(T i) {
		chave = i;
		next = null;
	}

	/**
	 * Gets the chave.
	 * 
	 * @return the chave
	 */
	public T getChave() {
		return chave;
	}

	/**
	 * Sets the chave.
	 * 
	 * @param chave
	 *            the new chave
	 */
	public void setChave(T chave) {
		this.chave = chave;
	}

	/**
	 * Gets the next.
	 * 
	 * @return the next
	 */
	public Nodo<T> getNext() {
		return next;
	}

	/**
	 * Sets the next.
	 * 
	 * @param next
	 *            the new next
	 */
	public void setNext(Nodo<T> next) {
		this.next = next;
	}

	public Nodo<T> getPrevious() {
		return prev;
	}

	public void setPrevious(Nodo<T> prev) {
		this.prev = prev;
	}
}