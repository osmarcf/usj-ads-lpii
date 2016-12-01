package br.edu.usj.lpii;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    public Connection getConnection() {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/esostore", "root", "root");
            System.out.println("conectou!");
            return conexao;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }   
}
