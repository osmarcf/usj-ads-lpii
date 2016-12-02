package br.edu.usj.lpii;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PessoasDAO {

	public List<Pessoa> getLista() {
		Connection conexao = new DBUtils().getConnection();
		String sql = "select * from pessoas";
		List<Pessoa> lista = new ArrayList<Pessoa>();
		
		PreparedStatement query;
		try {
			query = conexao.prepareStatement(sql);            
            ResultSet rs = query.executeQuery();
            
            while (rs.next()) {
            	int id = rs.getInt("id");
            	String nome = rs.getString("nome");
            	String email = rs.getString("email");
            	Pessoa pessoa = new Pessoa(id, nome, email);
            	lista.add(pessoa);
            }
            
            rs.close();
            query.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

		return lista;
	}
	
	public void adiciona (Pessoa pessoa) {
		Connection conexao = new DBUtils().getConnection();
		String sql = "insert into pessoas (nome, email) values (?, ?)";
		
		PreparedStatement query;
		try {
			query = conexao.prepareStatement(sql);
            query.setString(1, pessoa.getNome());
            query.setString(2, pessoa.getEmail());
            
            query.execute();
            query.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public void remove(int id) {
		Connection conexao = new DBUtils().getConnection();
		String sql = "delete from pessoas where id = ?";
		
		PreparedStatement query;
		try {
			query = conexao.prepareStatement(sql);
            query.setInt(1, id);
            
            query.execute();
            query.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }		
	}

	public Pessoa getPessoa(int id) {
		Connection conexao = new DBUtils().getConnection();
		String sql = "select * from pessoas where id = ?";
		List<Pessoa> lista = new ArrayList<Pessoa>();
		
		PreparedStatement query;
		try {
			query = conexao.prepareStatement(sql);
			query.setInt(1, id);
            ResultSet rs = query.executeQuery();
            
            while (rs.next()) {
            	String nome = rs.getString("nome");
            	String email = rs.getString("email");
            	Pessoa pessoa = new Pessoa(id, nome, email);
            	lista.add(pessoa);
            }
            
            rs.close();
            query.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

		return lista.get(0);
	}

	public void atualiza(int id, Pessoa novaPessoa) {
		Connection conexao = new DBUtils().getConnection();
		String sql = "update pessoas set nome = ?, email = ? where id = ?";
		
		PreparedStatement query;
		try {
			query = conexao.prepareStatement(sql);
            query.setString(1, novaPessoa.getNome());
            query.setString(2, novaPessoa.getEmail());
            query.setInt(3, id);
            
            query.execute();
            query.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public List<Pessoa> pesquisa(Pessoa pessoa) {
		Connection conexao = new DBUtils().getConnection();
		String sql = "select * from pessoas where ";
		List<Pessoa> lista = new ArrayList<Pessoa>();
		
		PreparedStatement query;
		try {
			query = conexao.prepareStatement(sql);
			
			if (!pessoa.getNome().equals("") && !pessoa.getEmail().equals("")) {
				sql += "nome like ? or email like ?";
				query = conexao.prepareStatement(sql);
				query.setString(1, "%" + pessoa.getNome() + "%");
				query.setString(2, "%" + pessoa.getEmail() + "%");
			}
			else {
				if (!pessoa.getNome().equals("")) {
					sql += "nome like ? ";
					query = conexao.prepareStatement(sql);
					query.setString(1, "%" + pessoa.getNome() + "%");
				}
				
				if (!pessoa.getEmail().equals("")) {
					sql += "email like ? ";
					query = conexao.prepareStatement(sql);
					query.setString(1, "%" + pessoa.getEmail() + "%");
				}
			}
			
			ResultSet rs = query.executeQuery();
            
            while (rs.next()) {
            	int id = rs.getInt("id");
            	String nome = rs.getString("nome");
            	String email = rs.getString("email");
            	Pessoa pessoaEncontrada = new Pessoa(id, nome, email);
            	lista.add(pessoaEncontrada);
            }
            
            rs.close();
            query.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

		return lista;
	}
	
}
