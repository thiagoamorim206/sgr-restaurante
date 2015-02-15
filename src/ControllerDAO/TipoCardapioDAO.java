package ControllerDAO;

import Model.TbTipoCardapio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TipoCardapioDAO {

    public TbTipoCardapio inserirTipoCardapio(TbTipoCardapio t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "INSERT INTO tb_tipo_cardapio VALUES (nextval('tb_tipo_cardapio_id_tipo_cardapio_seq'), '" + t.getNmTipo() + "')";

            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.execute();

            ConnectionFactory.desconecta(cn);
            cn = ConnectionFactory.getConnection();

            return t;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.desconecta(cn);
        }
        return null;
    }
    
    
    public ArrayList listarTipoCardapio() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "select *from tb_tipo_cardapio";

            PreparedStatement ps = cn.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            ArrayList<TbTipoCardapio> lista = new ArrayList<>();
            
            while (rs.next()) {
                TbTipoCardapio tbTipoCardapio = new TbTipoCardapio(rs.getInt("id_tipo_cardapio"), rs.getString("nm_tipo"));                  
                lista.add(tbTipoCardapio);
            }
           

            ConnectionFactory.desconecta(cn);
            cn = ConnectionFactory.getConnection();
            return lista;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.desconecta(cn);
        }
        return null;
    }

}
