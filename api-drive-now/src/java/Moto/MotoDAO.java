/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moto;

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
public class MotoDAO {
    
    public List<MotoBean> listaMoto() {

        try {

            Connection conexao = Conexao.getConexao();
            List<MotoBean> listaMotos = new ArrayList<>();
            PreparedStatement ps = conexao.prepareStatement("select * from moto order by 1 desc");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                MotoBean m = new MotoBean();

                m.setId(rs.getString("id"));
                m.setImg(rs.getString("img"));
                m.setNome(rs.getString("nome"));
                m.setMarca(rs.getString("marca"));
                m.setAno(rs.getString("ano"));
                m.setValor(rs.getString("valor"));

                listaMotos.add(m);
            }
            ps.execute();
            ps.close();
            Conexao.fecharConexao();

            return listaMotos;
        } catch (SQLException ex) {
            System.out.println("Erro ao listaMoto DAO " + ex.getMessage());
            return null;
        }
    }
    
}
