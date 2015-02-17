package ControllerDAO;

import Model.TbMesa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MesaDAO {

    public TbMesa inserirMesa(TbMesa t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "INSERT INTO tb_mesa VALUES (nextval('tb_mesa_id_mesa_seq'), '" + t.getNrLugares() + "','" + t.getFlOcupada() + "','" + t.getDsObs() + "','" + t.getNmMesa() + "')";

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

    public boolean listarMesa() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "select m.id_mesa, m.nm_nome mesa, p.nm_nome cliente, m.nr_lugares, m.fl_ocupada, m.ds_obs\n"
                    + "from tb_mesa m, tb_cliente c, tb_pessoa p\n"
                    + "where fl_ocupada = 'false'\n"
                    + "and c.id_pessoa = p.id_pessoa\n"
                    + "and c.id_mesa = m.id_mesa";

            PreparedStatement ps = cn.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Codigo: " + rs.getInt(1) + " - Mesa: " + rs.getString(2)
                        + " - Cliente: " + rs.getString(3)
                        + " - Lugares: " + rs.getInt(4)
                        + " - Ocupada: " + rs.getBoolean(5)
                        + " - Obs: " + rs.getString(6)
                );

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

    public void AtualizarMesa(TbMesa t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "update tb_mesa set fl_ocupada = " + t.getFlOcupada() + " where id_mesa=" + t.getIdMesa() + "";

            PreparedStatement ps = cn.prepareStatement(SQL);

            ps.execute();

            ConnectionFactory.desconecta(cn);
            cn = ConnectionFactory.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.desconecta(cn);
        }

    }

    public boolean listarTodasMesa() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "select *from tb_mesa";

            PreparedStatement ps = cn.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Codigo: " + rs.getInt(1) + " - Mesa: " + rs.getString(5)
                        + " - Lugares: " + rs.getInt(2)
                        + " - Ocupada: " + rs.getBoolean(3)
                        + " - Obs: " + rs.getString(4)
                );

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

    public TbMesa deletarMesa(int id_mesa) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "delete from tb_mesa \n"
                    + "where id_mesa = " + id_mesa + "";

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

    public boolean listarTodasMesaCliente() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "select m.id_mesa, m.nm_nome mesa, p.nm_nome cliente, m.nr_lugares, m.fl_ocupada, m.ds_obs\n"
                    + "from tb_mesa m, tb_cliente c, tb_pessoa p\n"
                    + " where c.id_pessoa = p.id_pessoa\n"
                    + "       and c.id_mesa = m.id_mesa";

            PreparedStatement ps = cn.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Codigo: " + rs.getInt(1) + " - Mesa: " + rs.getString(2)
                        + " - Cliente: " + rs.getString(3)
                        + " - Lugares: " + rs.getInt(4)
                        + " - Ocupada: " + rs.getBoolean(5)
                        + " - Obs: " + rs.getString(6)
                );

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

    public void AtualizarMesa(TbMesa t, int x) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "UPDATE tb_mesa\n"
                    + "   SET  nr_lugares='" + t.getNrLugares() + "', fl_ocupada='" + t.getFlOcupada() + "', ds_obs='" + t.getDsObs() + "', nm_nome='" + t.getNmMesa() + "'\n"
                    + " WHERE id_mesa =" + x + "";

            PreparedStatement ps = cn.prepareStatement(SQL);

            ps.execute();

            ConnectionFactory.desconecta(cn);
            cn = ConnectionFactory.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.desconecta(cn);
        }

    }

}
