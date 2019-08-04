/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;

/**
 *
 * @author alex
 */
public class UsuarioDAO {
    
    public List<UsuarioBean> listaUsuario() {

        try {

            Connection conexao = Conexao.getConexao();
            List<UsuarioBean> listaUsuarios = new ArrayList<>();
            PreparedStatement ps = conexao.prepareStatement("select login, senha from usuario");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                UsuarioBean u = new UsuarioBean();
                
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));

                listaUsuarios.add(u);
            }
            ps.execute();
            ps.close();
            Conexao.fecharConexao();
                        
            return listaUsuarios;
        } catch (SQLException ex) {
            System.out.println("Erro ao listaUsuario DAO " + ex.getMessage());
            return null;
        }
    }
        
    public List<UsuarioBean> validacaoUsuario(String login, String senha) {

        try {

            Connection conexao = Conexao.getConexao();
            List<UsuarioBean> listaUsuarios = new ArrayList<>();
            PreparedStatement ps = conexao.prepareStatement("select login, senha from usuario where login = '" + login + "' and senha = '" + senha + "'");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                UsuarioBean u = new UsuarioBean();
                
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));

                listaUsuarios.add(u);
            }
            ps.execute();
            ps.close();
            Conexao.fecharConexao();

            System.out.println("LoginDAO: " + login);
            System.out.println("SenhaDAO: " + senha);
            
            
            return listaUsuarios;
        } catch (SQLException ex) {
            System.out.println("Erro ao listaUsuario DAO " + ex.getMessage());
            return null;
        }
    }
}
