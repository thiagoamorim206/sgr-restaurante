package ControllerDAO;

import Model.TbReserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    public boolean listarReservas() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            Statement st = cn.createStatement();

            String SQL = "select r.id_reserva, p.nm_nome, m.nm_nome, r.nm_reserva\n"
                    + "from tb_reserva r, tb_empregado e, tb_pessoa p, tb_mesa m \n"
                    + "where r.id_mesa = m.id_mesa\n"
                    + "	and e.id_pessoa = p.id_pessoa\n"
                    + "	and r.id_empregado = e.id_empregado";

            ResultSet rs = st.executeQuery(SQL);
           
                while (rs.next()) {
                    System.out.println("Codigo: " + rs.getInt(1) + " - Empregado: " + rs.getString(2)
                            + " - Mesa: " + rs.getString(3)
                            + " - Nome Reserva: " + rs.getString(4)
                    );
                    return true;
                }
          

            ConnectionFactory.desconecta(cn);
            cn = ConnectionFactory.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.desconecta(cn);
        }
        return false;
    }

    public TbReserva deletarReserva(int Reserva) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "delete from tb_reserva \n"
                    + "where id_reserva = " + Reserva + "";

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
