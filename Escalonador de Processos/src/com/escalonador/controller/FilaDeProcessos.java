package com.escalonador.controller;

import java.util.LinkedList;

import com.escalonador.model.Processo;

public class FilaDeProcessos {
	private LinkedList<Processo> filaDeProcessos;
	
	public FilaDeProcessos(){
		filaDeProcessos = new LinkedList<>();
	}
	
	public  LinkedList<Processo> getFila(){
		return filaDeProcessos;
	}
	

}
