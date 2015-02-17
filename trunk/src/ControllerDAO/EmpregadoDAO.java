package ControllerDAO;

import Model.TbEmpregado;
import Model.TbPessoa;
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

    public boolean listarEmpregado() {
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
        return false;
    }

    public boolean listarEmpregadoFuncao() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "select e.id_empregado, p.nm_nome, e.ds_funcao_restaurante\n"
                    + "from tb_empregado e, tb_pessoa p\n"
                    + "where e.id_pessoa = p.id_pessoa";

            PreparedStatement ps = cn.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Codigo: " + rs.getInt(1) + " - Nome: " + rs.getString(2) + " - Função: " + rs.getString(3));

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

    public boolean listarTudoEmpregado() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "select e.id_empregado, p.nm_nome, e.ds_funcao_restaurante, p.nr_celular\n"
                    + "from tb_empregado e, tb_pessoa p\n"
                    + "where e.id_pessoa = p.id_pessoa";

            PreparedStatement ps = cn.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Codigo: " + rs.getInt(1) + " - Nome: "
                        + rs.getString(2) + " - Função: " + rs.getString(3)
                        + " - Celular: " + rs.getString(4));

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

    public TbEmpregado deletarEmpregado(int id_empregado) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "DELETE FROM  tb_pessoa p\n"
                    + "     USING tb_empregado c\n"
                    + "     where c.id_pessoa = p.id_pessoa\n"
                    + "	and c.id_empregado =" + id_empregado + "";

            PreparedStatement ps = cn.prepareStatement(SQL);
            ps.execute();

            String SQL1 = "delete from tb_empregado \n"
                    + "where id_empregado = " + id_empregado + "";

            PreparedStatement ps1 = cn.prepareStatement(SQL1);
            ps1.execute();

            ConnectionFactory.desconecta(cn);
            cn = ConnectionFactory.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.desconecta(cn);
        }
        return null;
    }

    public void AtualizarPessoa(TbPessoa t, TbEmpregado em, int x) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "UPDATE tb_pessoa p\n"
                    + " SET  nm_nome=  '" + t.getNmNome() + "' , nr_telefone = '" + t.getNrTelefone() + "' , nr_celular='" + t.getNrCelular() + "', nm_sexo='" + t.getNmSexo() + "', nm_email= '" + t.getNmEmail() + "'\n"
                    + " from tb_empregado c  \n"
                    + " WHERE c.id_pessoa = p.id_pessoa\n"
                    + " and c.id_empregado = " + x + "";

            PreparedStatement ps = cn.prepareStatement(SQL);

            ps.execute();

            String SQL1 = "UPDATE tb_empregado e\n"
                    + "  SET  ds_funcao_restaurante= '" + em.getDsFuncaoRestaurante() + "'\n"
                    + "             from tb_empregado c\n"
                    + "                WHERE c.id_pessoa = e.id_pessoa\n"
                    + "                  and c.id_empregado = " + x + "";

            PreparedStatement ps1 = cn.prepareStatement(SQL1);

            ps1.execute();

            ConnectionFactory.desconecta(cn);
            cn = ConnectionFactory.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.desconecta(cn);
        }

    }

    ///ALTERADO POR ADRIANO 
    public ArrayList idsCozinheiros() {
        Connection cn = null;
        ArrayList<Integer> array = new ArrayList<Integer>();
        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "select e.id_empregado\n"
                    + "from tb_empregado e, tb_pessoa p\n"
                    + "where e.id_pessoa = p.id_pessoa and e.ds_funcao_restaurante like 'Cozinheiro'";

            PreparedStatement ps = cn.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Integer x = new Integer(rs.getInt(1));
                array.add(x);
            }

            ConnectionFactory.desconecta(cn);
            cn = ConnectionFactory.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.desconecta(cn);
            return array;
        }
    }

}
