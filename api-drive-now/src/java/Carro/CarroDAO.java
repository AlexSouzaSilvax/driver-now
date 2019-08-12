/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carro;

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
public class CarroDAO {

    public List<CarroBean> listaCarro(String clausula) {

        try {

            Connection conexao = Conexao.getConexao();
            List<CarroBean> listaCarros = new ArrayList<>();
            PreparedStatement ps = conexao.prepareStatement("select * from carro order by 1 desc");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                CarroBean c = new CarroBean();

                c.setId(rs.getString("id"));
                c.setImg(rs.getString("img"));
                c.setNome(rs.getString("nome"));
                c.setMarca(rs.getString("marca"));
                c.setAno(rs.getString("ano"));
                c.setValor(rs.getString("valor"));

                listaCarros.add(c);
            }
            ps.execute();
            ps.close();
            Conexao.fecharConexao();

            return listaCarros;
        } catch (SQLException ex) {
            System.out.println("Erro ao listaCarro DAO " + ex.getMessage());
            return null;
        }
    }

    public CarroBean alterar(CarroBean c) {
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps;
            ps = conexao.prepareStatement("update carro set nome = ?, marca = ?, ano = ?, valor = ? where id = ?");

            ps.setString(1, c.getNome());
            ps.setString(2, c.getMarca());
            ps.setString(3, c.getAno());
            ps.setString(4, c.getValor());

            ps.setString(5, c.getId());

            ps.execute();
            Conexao.fecharConexao();

            System.out.println("Alterado com sucesso.");

        } catch (SQLException ex) {
            System.out.println("Erro ao alterar DAO " + ex.getMessage());
        }
        return c;
    }

    public String deletar(String id) {

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps;
            ps = conexao.prepareStatement("delete from carro where id = ?");

            ps.setString(1, id);

            ps.execute();
            Conexao.fecharConexao();
            System.out.println("CarroDAO deletado com sucesso. ID: " + id);
        } catch (SQLException ex) {            
            System.out.println("Erro ao deletar CarroDAO " + ex.getMessage());
        }
        return id;
    }
}
