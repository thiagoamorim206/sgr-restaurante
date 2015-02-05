package ControllerDAO;

import Model.TbPedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidoDAO {
    
    public TbPedido inserirPedido(TbPedido t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "INSERT INTO tb_pedido VALUES (nextval('tb_pedido_id_pedido_seq'), '" + t.getIdMesa()+ "','" + t.getDtPedido()+ "','" + t.getVlTotalConsumo()+ "','" + t.getDsPago()+ "')";

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
