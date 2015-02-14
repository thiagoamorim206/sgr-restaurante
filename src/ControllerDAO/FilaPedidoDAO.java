package ControllerDAO;

import Model.TbFilaPedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FilaPedidoDAO {

    public TbFilaPedido inserirFilaPedido(TbFilaPedido t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "INSERT INTO tb_fila_pedido VALUES (nextval('tb_fila_pedido_id_fila_pedido_seq'), '" + t.getIdPedidoCardapio() + "','" + t.getIdEmpregado() + "','" + t.getDsStatus() + "')";

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
