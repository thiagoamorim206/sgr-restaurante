package ControllerDAO;

import Model.TbTipoRestaurante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TipoRestauranteDAO {

    public TbTipoRestaurante inserirTipoRestaurante(TbTipoRestaurante t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "INSERT INTO tb_tipo_restaurante VALUES (nextval('tb_tipo_restaurante_id_tipo_restaurante_seq'), '" + t.getNmTipo() + "')";

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

    public ArrayList listarTipoRestaurante() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "select *from tb_tipo_restaurante";

            PreparedStatement ps = cn.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            ArrayList<TbTipoRestaurante> lista = new ArrayList<>();

            while (rs.next()) {
                TbTipoRestaurante tbTipoRestaurante = new TbTipoRestaurante(rs.getInt("id_tipo_restaurante"), rs.getString("nm_tipo"));
                lista.add(tbTipoRestaurante);
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

    public TbTipoRestaurante deletarTipoRestaurante(int id_tipo_restaurante) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "delete from tb_tipo_restaurante \n"
                    + "where id_tipo_restaurante = " + id_tipo_restaurante + "";

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
