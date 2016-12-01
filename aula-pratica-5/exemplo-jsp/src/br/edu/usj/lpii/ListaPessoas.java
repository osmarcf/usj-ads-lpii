package br.edu.usj.lpii;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ListaPessoas {
	static List<Pessoa> pessoas;
	
	public void popula() {
		pessoas = new ArrayList<Pessoa>();
		
		Pessoa p1 = new Pessoa();
		p1.setNome("Osmar");
		p1.setEmail("osmarcf.usj@gmail.com");
		pessoas.add(p1);
		
		Pessoa p2 = new Pessoa();
		p2.setNome("Tiririca");
		p2.setEmail("pior@queta.com");
		pessoas.add(p2);
		
		Pessoa p3 = new Pessoa();
		p3.setNome("Nemo");
		p3.setEmail("wallabyway@sydney.com");
		pessoas.add(p3);
	}
	
	public List<Pessoa> getListaPessoas() {
		return pessoas;
	}
	
	public void adiciona (String nome, String email) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setEmail(email);
		pessoas.add(pessoa);
	}

	public void remove(String email) {
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getEmail().equals(email)) {
				pessoas.remove(pessoa);
				return;
			}
		}		
	}
}
