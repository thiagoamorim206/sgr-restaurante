package ControllerDAO;

import Model.TbTipoRestaurante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
