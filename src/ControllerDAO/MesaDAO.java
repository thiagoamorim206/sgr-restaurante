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

            String SQL = "INSERT INTO tb_mesa VALUES (nextval('tb_mesa_id_mesa_seq'), '" + t.getNrLugares()+ "','" + t.getFlOcupada()+ "','" + t.getDsObs()+ "','" + t.getNmMesa()+ "')";

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

            String SQL = "select *from tb_mesa";

            PreparedStatement ps = cn.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            ArrayList<TbMesa> lista = new ArrayList<>();
            
            while (rs.next()) {
                TbMesa mesa = new TbMesa(rs.getInt(1), rs.getInt(2), rs.getBoolean(3), rs.getString(4), rs.getString(5));                  
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

}
