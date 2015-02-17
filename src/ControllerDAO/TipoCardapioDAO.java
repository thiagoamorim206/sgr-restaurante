package ControllerDAO;

import Model.TbTipoCardapio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public boolean listarTipoCardapio() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "select *from tb_tipo_cardapio";

            PreparedStatement ps = cn.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Codigo: " + rs.getInt(1) + " - Tipo Cardapio: " + rs.getString(2));

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

    public TbTipoCardapio deletarTipoCardapio(int id_tipo_cardapio) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "delete from tb_tipo_cardapio \n"
                    + "where id_tipo_cardapio = " + id_tipo_cardapio + "";

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

    public void AtualizarTipoCardapio(TbTipoCardapio t, int x) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "UPDATE tb_tipo_cardapio\n"
                    + "   SET  nm_tipo='" + t.getNmTipo() + "'\n"
                    + " WHERE id_tipo_cardapio = " + x + "";

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

}
