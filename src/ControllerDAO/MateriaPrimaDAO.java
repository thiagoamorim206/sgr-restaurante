package ControllerDAO;

import Model.TbMateriaPrima;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MateriaPrimaDAO {

    public TbMateriaPrima inserirMateriaPrima(TbMateriaPrima t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "INSERT INTO tb_materia_prima VALUES (nextval('tb_materia_prima_id_materia_prima_seq'), '"
                    + t.getNmProduto() + "','" + t.getNrQtdEstoque() + "','" + t.getVlProduto() + "','" + t.getDsObs() + "')";

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

    public boolean listarProdutos() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "select id_materia_prima, nm_produto from tb_materia_prima";

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

    public boolean listarTodosProdutos() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "select * from tb_materia_prima";

            PreparedStatement ps = cn.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Codigo: " + rs.getInt(1) + " - Nome: " + rs.getString(2)
                        + " - Qtd. Estoque: " + rs.getInt(3)
                        + " - Preço: " + rs.getDouble(4)
                        + " - Obs: " + rs.getString(5)
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

    public void AtualizarEstoque(TbMateriaPrima t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "update tb_materia_prima set nr_qtd_estoque = " + t.getNrQtdEstoque() + " where id_materia_prima=" + t.getIdMateriaPrima() + "";

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

    public int listarQtdEstoque() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "select mp.nr_qtd_estoque \n"
                    + "from tb_materia_prima mp, tb_compra_produto cp\n"
                    + "where mp.id_materia_prima = cp.id_materia_prima\n"
                    + "and id_compra_produto  = (SELECT MAX(id_compra_produto) FROM tb_compra_produto)";

            PreparedStatement ps = cn.prepareStatement(SQL);
            int x = 0;
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                x = rs.getInt(1);
            }
            ConnectionFactory.desconecta(cn);
            cn = ConnectionFactory.getConnection();

            return x;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.desconecta(cn);
        }
        return -1;
    }

    public TbMateriaPrima deletarProduto(int id_produto) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "delete from tb_materia_prima \n"
                    + "where id_materia_prima = " + id_produto + "";

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

    public void AtualizarProduto(TbMateriaPrima t, int x) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "UPDATE tb_materia_prima\n"
                    + "   SET nm_produto='" + t.getNmProduto() + "', nr_qtd_estoque='" + t.getNrQtdEstoque() + "', vl_produto='" + t.getVlProduto() + "', \n"
                    + "       ds_obs='" + t.getDsObs() + "'\n"
                    + " WHERE id_materia_prima = " + x + "";

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

    public void itensEstoqueBaixo(int q) {
        Connection cn = null;

        try {
            cn = ConnectionFactory.getConnection();

            String SQL = "select mp.nm_produto,mp.nr_qtd_estoque \n"
                    + "from tb_materia_prima mp\n"
                    + "where mp.nr_qtd_estoque <" + q;

            PreparedStatement ps = cn.prepareStatement(SQL);
            int x = 0;
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nome = rs.getString(1);
                int quantidade = rs.getInt(2);
                System.out.printf("Nome: %s - Quantidade: %d\n", nome, quantidade);
            }
            ConnectionFactory.desconecta(cn);
            cn = ConnectionFactory.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.desconecta(cn);
        }
    }

    ///ALTERADO POR ADRIANO
    public void abater(int id, int quant) {
        Connection cn = null;
        try {
            cn = ConnectionFactory.getConnection();

            Statement st = cn.createStatement();
            String SQL = "UPDATE tb_materia_prima SET nr_qtd_estoque="+ quant+ "WHERE id_materia_prima =" +id;

            st.execute(SQL);

            ConnectionFactory.desconecta(cn);
            cn = ConnectionFactory.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.desconecta(cn);
        }
    }
    
    //ALTERADO POR ADRIANO
    public int verquantidade(int id) {
        Connection cn = null;
        int quantidade = 0;
        try {
            cn = ConnectionFactory.getConnection();

            String SQL = "select mp.nr_qtd_estoque \n"
                    + "from tb_materia_prima mp\n"
                    + "where mp.id_materia_prima=" + id;

            PreparedStatement ps = cn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                quantidade = rs.getInt(1);
            }
            ConnectionFactory.desconecta(cn);
            cn = ConnectionFactory.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.desconecta(cn);
            return quantidade;
        }

    }

}
