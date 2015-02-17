package ControllerDAO;

import Model.TbFilaPedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public boolean listarFilaPedido() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "select fp.id_fila_pedido, pe.nm_nome Mesa, m.nm_nome cliente, ca.nm_item_cardapio Item, fp.ds_status Status, pessoa.nm_nome\n"
                    + "  from tb_fila_pedido fp, tb_pedido_cardapio pc, tb_empregado em, tb_pedido p, tb_mesa m, tb_cliente c, tb_pessoa pe, tb_cardapio ca, tb_pessoa pessoa\n"
                    + "                    where pe.id_pessoa = c.id_pessoa\n"
                    + "                    and c.id_mesa = m.id_mesa\n"
                    + "                    and m.id_mesa = p.id_mesa\n"
                    + "                    and p.id_pedido = pc.id_pedido\n"
                    + "                    and pc.id_cardapio = ca.id_cardapio\n"
                    + "                    and pc.id_pedido_cardapio = fp.id_pedido_cardapio\n"
                    + "                    and fp.id_empregado = em.id_empregado\n"
                    + "                    and em.id_pessoa = pessoa.id_pessoa";

            PreparedStatement ps = cn.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Codigo: " + rs.getInt(1) + " - Cliente: " + rs.getString(2)
                        + " - Mea: " + rs.getString(3)
                        + " - Item: " + rs.getString(4)
                        + " - Status: " + rs.getString(5)
                        + " - Empregado: " + rs.getString(6)
                );

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

}
