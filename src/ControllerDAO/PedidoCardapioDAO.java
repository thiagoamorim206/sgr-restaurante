package ControllerDAO;

import Model.TbPedidoCardapio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PedidoCardapioDAO {

    public TbPedidoCardapio inserirPedidoCardapio(TbPedidoCardapio t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "INSERT INTO tb_pedido_cardapio VALUES (nextval('tb_pedido_cardapio_id_pedido_cardapio_seq'), '" + t.getIdCardapio() + "','" + t.getIdPedido()+ "')";

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
    
     public ArrayList listarUltimoPedidoCardapio() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "select id_pedido_cardapio from tb_pedido_cardapio where id_pedido_cardapio = (SELECT MAX(id_pedido_cardapio) FROM tb_pedido_cardapio)";

            PreparedStatement ps = cn.prepareStatement(SQL);
     
            ResultSet rs = ps.executeQuery();
            ArrayList<TbPedidoCardapio> lista = new ArrayList<>();
            while (rs.next()) {
               TbPedidoCardapio tbPedidoCardapio = new TbPedidoCardapio(rs.getInt("id_pedido_cardapio"));
               lista.add(tbPedidoCardapio);
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
