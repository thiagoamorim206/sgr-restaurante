package ControllerDAO;

import Model.TbCardapio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CardapioDAO {

    public TbCardapio inserirCardapio(TbCardapio t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "INSERT INTO tb_cardapio VALUES (nextval('tb_cardapio_id_cardapio_seq'), '" + t.getIdTipoRestaurante() + "','" + t.getIdTipoCardapio() + "','" + t.getNmItemCardapio() + "','" + t.getVlItem() + "')";

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

    public boolean listarCardapio() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            Statement st = cn.createStatement();

            String SQL = "select ca.id_cardapio, ca.nm_item_cardapio, c.nm_tipo, r.nm_tipo, ca.vl_item\n"
                    + "from tb_tipo_cardapio c, tb_tipo_restaurante r, tb_cardapio ca \n"
                    + "where r.id_tipo_restaurante = ca.id_tipo_restaurante\n"
                    + "and ca.id_tipo_cardapio = c.id_tipo_cardapio\n"
                    + "	order by c.nm_tipo,r.nm_tipo";

            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                System.out.println("Codigo: " + rs.getInt(1) + " - Item: " + rs.getString(2)
                        + " - Valor_Item: " + rs.getDouble(5)
                        + " - Tipo_Item: " + rs.getString(3)
                        + " - Tipo_Restaurante: " + rs.getString(4)
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

    public TbCardapio deletarCardapio(int id_cardapio) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "delete from tb_cardapio \n"
                    + "where id_cardapio = " + id_cardapio + "";

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

    public void AtualizarCardapio(TbCardapio t, int x) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "UPDATE tb_cardapio\n"
                    + "   SET id_tipo_restaurante='" + t.getIdTipoRestaurante() + "', id_tipo_cardapio='" + t.getIdTipoCardapio() + "', nm_item_cardapio='" + t.getNmItemCardapio() + "', \n"
                    + "   vl_item='" + t.getVlItem() + "'\n"
                    + " WHERE id_cardapio = " + x + "";

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

    /////////////ALTERADO POR ADRIANO

    public double verValorItem(int id) {
        Connection cn = null;
        double valor = 0;
        try {

            cn = ConnectionFactory.getConnection();

            Statement st = cn.createStatement();

            String SQL = "select ca.vl_item\n"
                    + "from tb_cardapio ca\n" + "where ca.id_cardapio =" + id;

            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                valor = rs.getDouble(1);
            }

            ConnectionFactory.desconecta(cn);
            cn = ConnectionFactory.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.desconecta(cn);
            return valor;
        }

    }

}
