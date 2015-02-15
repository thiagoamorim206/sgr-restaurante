package ControllerDAO;

import Model.TbReserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservaDAO {

    public TbReserva inserirReserva(TbReserva t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "INSERT INTO tb_reserva VALUES (nextval('tb_reserva_id_reserva_seq'), "
                    + "'" + t.getIdEmpregado() + "','" + t.getIdMesa() + "','" + t.getNmReserva() + "','"
                    + t.getDtReserva() + "','" + t.getNmEstadoReserva() + "','" + t.getNrLugarReserva() + "')";

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
