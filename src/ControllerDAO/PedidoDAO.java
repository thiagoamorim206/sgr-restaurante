package ControllerDAO;

import Model.TbPedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PedidoDAO {

    public TbPedido inserirPedido(TbPedido t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "INSERT INTO tb_pedido VALUES (nextval('tb_pedido_id_pedido_seq'), '" + t.getIdMesa() + "','" + t.getDtPedido() + "','" + t.getVlTotalConsumo() + "','" + t.getDsPago() + "')";

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

    public TbPedido listarPedidos() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            Statement st = cn.createStatement();

            String SQL = "select p.id_pedido, m.nm_nome, p.dt_pedido, p.vl_total_consumo, p.ds_pago\n"
                    + "from tb_mesa m, tb_pedido p\n"
                    + "where m.id_mesa = p.id_mesa\n"
                    + "order by p.dt_pedido";

            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                System.out.println("Codigo: " + rs.getInt(1) + " - Mesa: " + rs.getString(2)
                        + " - Data: " + rs.getDate(3)
                        + " - Valor_Total: " + rs.getDouble(4)
                        + " - Pago: " + rs.getBoolean(5)
                );
            }

            ConnectionFactory.desconecta(cn);
            cn = ConnectionFactory.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.desconecta(cn);
        }
        return null;
    }

}
