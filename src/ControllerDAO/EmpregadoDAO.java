package ControllerDAO;

import Model.TbEmpregado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpregadoDAO {
    
    public TbEmpregado inserirEmpregado(TbEmpregado t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "INSERT INTO tb_empregado VALUES (nextval('tb_empregado_id_empregado_seq'), '" + t.getIdPessoa()+ "','" + t.getDsFuncaoRestaurante()+ "')";

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
