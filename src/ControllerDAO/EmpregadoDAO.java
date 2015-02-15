package ControllerDAO;

import Model.TbEmpregado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpregadoDAO {

    public TbEmpregado inserirEmpregado(TbEmpregado t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "INSERT INTO tb_empregado VALUES (nextval('tb_empregado_id_empregado_seq'), '" + t.getIdPessoa() + "','" + t.getDsFuncaoRestaurante() + "')";

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

    public TbEmpregado listarEmpregado() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "select e.id_empregado, p.nm_nome\n"
                    + "from tb_empregado e, tb_pessoa p\n"
                    + "where e.id_pessoa = p.id_pessoa";

            PreparedStatement ps = cn.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Codigo: " + rs.getInt(1) + " - Nome: " + rs.getString(2));
            }

            ConnectionFactory.desconecta(cn);
            cn = ConnectionFactory.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.desconecta(cn);
        }
        return null;
    }
    
     public TbEmpregado listarEmpregadoFuncao() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "select e.id_empregado, p.nm_nome, e.ds_funcao_restaurante\n"
                    + "from tb_empregado e, tb_pessoa p\n"
                    + "where e.id_pessoa = p.id_pessoa";

            PreparedStatement ps = cn.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Codigo: " + rs.getInt(1) + " - Nome: " + rs.getString(2)+ " - Função: " + rs.getString(3));
            }

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
