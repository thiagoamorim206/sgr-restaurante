package ControllerDAO;

import Model.TbPessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaDAO {
    
    public TbPessoa inserirPessoa(TbPessoa t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "INSERT INTO tb_pessoa VALUES (nextval('tb_pessoa_id_pessoa_seq'), '" + t.getNmNome()+ "','" + t.getNrTelefone()+ "','" + t.getNrCelular()+ "','" + t.getNmSexo()+ "','" + t.getNmEmail()+ "')";

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
