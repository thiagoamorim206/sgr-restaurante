package ControllerDAO;

import Model.TbFornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FornecedorDAO {

    public TbFornecedor inserirFornecedor(TbFornecedor t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "INSERT INTO tb_fornecedor VALUES (nextval('tb_fornecedor_id_fornecedor_seq'), '"
                    + t.getNmFornecedor() + "','" + t.getNrCelular() + "','" + t.getNrTelefone() + "','"
                    + t.getNmEmail() + "','" + t.getDsObs() + "')";

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
