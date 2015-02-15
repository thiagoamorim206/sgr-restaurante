package ControllerDAO;

import Model.TbPessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PessoaDAO {

    public TbPessoa inserirPessoa(TbPessoa t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "INSERT INTO tb_pessoa VALUES (nextval('tb_pessoa_id_pessoa_seq'), '" + t.getNmNome() + "','" + t.getNrTelefone() + "','" + t.getNrCelular() + "','" + t.getNmSexo() + "','" + t.getNmEmail() + "')";

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

    public ArrayList listarUltimaLinha() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = " select id_pessoa from tb_pessoa where id_pessoa = (SELECT MAX(id_Pessoa) FROM tb_pessoa)";

            PreparedStatement ps = cn.prepareStatement(SQL);
     
            ResultSet rs = ps.executeQuery();
             ArrayList<TbPessoa> lista = new ArrayList<>();
            while (rs.next()) {
               TbPessoa pessoa = new TbPessoa(rs.getInt("id_pessoa"));
               lista.add(pessoa);
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
