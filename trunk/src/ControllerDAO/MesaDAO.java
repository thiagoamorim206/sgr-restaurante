package ControllerDAO;

import Model.TbMesa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MesaDAO {
    
    public TbMesa inserirMesa(TbMesa t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "INSERT INTO tb_mesa VALUES (nextval('tb_mesa_id_mesa_seq'), '" + t.getNrLugares()+ "','" + t.getFlOcupada()+ "','" + t.getDsObs()+ "')";

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
