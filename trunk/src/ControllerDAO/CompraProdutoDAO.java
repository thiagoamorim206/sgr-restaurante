package ControllerDAO;

import Model.TbCompraProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompraProdutoDAO {

    public TbCompraProduto inserirCompraProduto(TbCompraProduto t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "INSERT INTO tb_compra_produto VALUES (nextval('tb_compra_produto_id_compra_produto_seq'), '"
                    + t.getIdEmpregado() + "','" + t.getIdFornecedor() + "','" + t.getIdMateriaPrima() + "','"
                    + t.getDtCompra() + "','" + t.getNrQtdCompra() + "','" + t.getDsObs() + "')";

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
