package ControllerDAO;

import Model.TbCliente;
import Model.TbPessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    public TbCliente inserirCliente(TbCliente t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "INSERT INTO tb_cliente VALUES (nextval('tb_cliente_id_cliente_seq'), '" + t.getIdMesa() + "','" + t.getIdPessoa() + "')";

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

    public boolean listaCliente() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = " select c.id_cliente, p.nm_nome mesa, pe.ds_pago pago\n"
                    + " from tb_cliente c, tb_pessoa p, tb_mesa m, tb_pedido pe\n"
                    + " where c.id_pessoa = p.id_pessoa    \n"
                    + "     and c.id_mesa = m.id_mesa\n"
                    + "     and m.id_mesa = pe.id_mesa\n"
                    + "     and pe.ds_pago = false\n"
                    + "     group by c.id_cliente, p.nm_nome, mesa, pago\n"
                    + "     order by id_cliente";

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

    public boolean listaTodosClientes() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "select c.id_cliente, p.nm_nome\n"
                    + "from tb_cliente c, tb_pessoa p\n"
                    + "where c.id_pessoa = p.id_pessoa\n"
                    + "group by c.id_cliente,p.nm_nome\n"
                    + "order by c.id_cliente,p.nm_nome\n"
                    + "";

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

    public boolean listaTudoCliente() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = " select c.id_cliente, p.nm_nome, p.nr_telefone, p.nr_celular, p.nm_sexo, p.nm_email\n"
                    + " from tb_cliente c, tb_pessoa p\n"
                    + "where c.id_pessoa = p.id_pessoa\n"
                    + "order by c.id_cliente,p.nm_nome";

            PreparedStatement ps = cn.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Codigo: " + rs.getInt(1)
                        + " Nome: " + rs.getString(2)
                        + " Telefone: " + rs.getString(3)
                        + " Celular: " + rs.getString(4)
                        + " Sexo: " + rs.getString(5)
                        + " Email: " + rs.getString(6)
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

    public TbCliente deletarCliente(int id_cliente) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "delete from tb_cliente \n"
                    + "where id_cliente = " + id_cliente + "";

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

    public TbCliente deletarPessoa(int id_cliente) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = " DELETE FROM  tb_pessoa p\n"
                    + "     USING tb_cliente c\n"
                    + "     where c.id_pessoa = p.id_pessoa\n"
                    + "	    and c.id_cliente = " + id_cliente + "";

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

    public void AtualizarPessoa(TbPessoa t, int x) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "UPDATE tb_pessoa p\n"
                    + " SET  nm_nome=  '" + t.getNmNome() + "' , nr_telefone = '" + t.getNrTelefone() + "' , nr_celular='" + t.getNrCelular() + "', nm_sexo='" + t.getNmSexo() + "', nm_email= '" + t.getNmEmail() + "'\n"
                    + " from tb_cliente c  \n"
                    + " WHERE c.id_pessoa = p.id_pessoa\n"
                    + " and c.id_cliente = " + x + "";

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
