package ControllerDAO;

import Model.TbTipoCardapio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TipoCardapioDAO {

    public TbTipoCardapio inserirTipoRestaurante(TbTipoCardapio t) {
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

}
