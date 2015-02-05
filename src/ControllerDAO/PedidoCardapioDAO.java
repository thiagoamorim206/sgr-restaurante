package ControllerDAO;

import Model.TbPedidoCardapio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
