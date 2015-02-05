package ControllerDAO;

import Model.TbCardapio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CardapioDAO {
    
    public TbCardapio inserirCardapio(TbCardapio t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "INSERT INTO tb_cardapio VALUES (nextval('tb_cardapio_id_cardapio_seq'), '" + t.getIdTipoRestaurante()+ "','" + t.getIdTipoCardapio()+ "','" + t.getNmItemCardapio()+ "','" + t.getVlItem()+ "')";

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
