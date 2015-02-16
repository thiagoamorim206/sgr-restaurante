package ControllerDAO;

import Model.TbPedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

    public boolean listarPedidos() {
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
                return true;
            }

            ConnectionFactory.desconecta(cn);
            cn = ConnectionFactory.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.desconecta(cn);
        }
        return false;
    }

    public ArrayList listarUltimoPedido() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "select id_pedido from tb_pedido where id_pedido = (SELECT MAX(id_pedido) FROM tb_pedido)";

            PreparedStatement ps = cn.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();
            ArrayList<TbPedido> lista = new ArrayList<>();
            while (rs.next()) {
                TbPedido pedido = new TbPedido(rs.getInt("id_pedido"));
                lista.add(pedido);
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

    public void AtualizarPago(TbPedido t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "update tb_pedido set ds_pago = " + t.getDsPago() + " where id_mesa=" + t.getIdMesa() + "";

            PreparedStatement ps = cn.prepareStatement(SQL);

            ps.execute();

            ConnectionFactory.desconecta(cn);
            cn = ConnectionFactory.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.desconecta(cn);
        }

    }

    public TbPedido deletarPedido(int id_Pedido) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "delete from tb_pedido \n"
                    + "where id_pedido = " + id_Pedido + "";

            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.execute();

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
