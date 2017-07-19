package br.com.userede.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.userede.util.ConectionDB;
import br.com.userede.util.User;

public class CrudDB {
	
	private static User user = null;
	
	public static  User buscarUsuarioPorNome(String login) {

        String sql = "SELECT * FROM users where login ='"+login+"'";

        try {

            Connection conexao = ConectionDB.conectar();
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet resultados = stm.executeQuery();
            while (resultados.next()) {
            	user = new User();
                user.setLogin(resultados.getString("login"));
                user.setPassWord(resultados.getString("password"));
                return user;
            }

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

        return null;
    }
	
	public static void cadastrar(User user) {
        PreparedStatement stm = null;

        try {
            Connection conexao = ConectionDB.conectar();
            String sqlUser = "INSERT INTO users(login,password)"
                    + "values(?,?)";
            stm = conexao.prepareStatement(sqlUser);
            stm.setString(1, user.getLogin());
            stm.setString(2, user.getPassWord());
            stm.execute();
            stm.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


	

}
