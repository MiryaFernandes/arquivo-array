package br.senai.sp.jandira.array;

import java.util.ArrayList;

public class DadosContato {
	
	Contato contato = new Contato();
	ArrayList<Contato> contatos = new ArrayList<Contato>();
	
	
	public void cadastrarContato(Contato c) {
		contatos.add(c);
	}
	
	public ArrayList<Contato> listarContatos() {
		return contatos;
	}
	
	public int contarContatos() {
		return contatos.size();
	}

}
