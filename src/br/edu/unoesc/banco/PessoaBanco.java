package br.edu.unoesc.banco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.unoesc.model.Pessoa;

public class PessoaBanco {
	private static final List<Pessoa> PESSOAS = 
			new ArrayList<>();
	
	public static void add(Pessoa p){
		PESSOAS.add(p);
	}
	
	public static void remover(Pessoa p){
		PESSOAS.remove(p);
	}
	
	public static List<Pessoa> getPessoas(){
		return Collections.unmodifiableList(PESSOAS);
	}
}
