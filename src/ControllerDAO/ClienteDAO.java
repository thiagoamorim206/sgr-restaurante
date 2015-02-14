package ControllerDAO;

import Model.TbCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {
    
    public TbCliente inserirCliente(TbCliente t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "INSERT INTO tb_cliente VALUES (nextval('tb_cliente_id_cliente_seq'), '" + t.getIdMesa()+ "','" + t.getIdPessoa() + "')";

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
