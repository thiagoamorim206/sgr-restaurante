package ControllerDAO;

import Model.TbMateriaPrima;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MateriaPrimaDAO {

    public TbMateriaPrima inserirMateriaPrima(TbMateriaPrima t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "INSERT INTO tb_materia_prima VALUES (nextval('tb_materia_prima_id_materia_prima_seq'), '"
                    + t.getNmProduto() + "','" + t.getNrQtdEstoque() + "','" + t.getVlProduto() + "','" + t.getDsObs() + "')";

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
