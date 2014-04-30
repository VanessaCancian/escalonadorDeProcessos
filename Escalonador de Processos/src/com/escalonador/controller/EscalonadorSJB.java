package com.escalonador.controller;

import com.escalonador.model.ListaEncadeada;
import com.escalonador.model.Processo;

public class EscalonadorSJB {
	private ListaEncadeada<Processo> listaDeProcessos;
	
	public EscalonadorSJB(ListaEncadeada<Processo> lista){
		this.listaDeProcessos = lista;
		
	}
	
	
	

}
