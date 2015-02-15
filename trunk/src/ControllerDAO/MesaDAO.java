package ControllerDAO;

import Model.TbCliente;
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

    public ArrayList listarMesa() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "select *from tb_mesa where fl_ocupada = 'false'";

            PreparedStatement ps = cn.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            ArrayList<TbMesa> lista = new ArrayList<>();

            while (rs.next()) {
                TbMesa mesa = new TbMesa(rs.getInt(1), rs.getInt(2), rs.getString(4), rs.getString(5));
                lista.add(mesa);
            }

            ConnectionFactory.desconecta(cn);
            cn = ConnectionFactory.getConnection();
            return lista;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.desconecta(cn);
        }
        return null;
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

   

}
