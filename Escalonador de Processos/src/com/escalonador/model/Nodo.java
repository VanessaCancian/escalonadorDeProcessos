package com.escalonador.model;

/**
 * The Class Nodo.
 * 
 * @param <T>
 *            the generic type
 */
public class Nodo<T> {

	/** The chave. */
	private T data;

	/** The next. */
	private Nodo<T> next;
	
	/** The prev. */
	private Nodo<T> prev;

	/**
	 * Instantiates a new nodo.
	 * 
	 * @param i
	 *            the i
	 */
	public Nodo(T i) {
		data = i;
		next = null;
	}

	/**
	 * Gets the chave.
	 * 
	 * @return the chave
	 */
	public T getData() {
		return data;
	}

	/**
	 * Sets the chave.
	 * 
	 * @param chave
	 *            the new chave
	 */
	public void setData(T chave) {
		this.data = chave;
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

	/**
	 * Gets the previous.
	 *
	 * @return the previous
	 */
	public Nodo<T> getPrevious() {
		return prev;
	}

	/**
	 * Sets the previous.
	 *
	 * @param prev the new previous
	 */
	public void setPrevious(Nodo<T> prev) {
		this.prev = prev;
	}
}