package ControllerDAO;

import Model.TbMateriaPrima;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public ArrayList listarProdutos() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "select id_materia_prima, nm_produto from tb_materia_prima";

            PreparedStatement ps = cn.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            ArrayList<TbMateriaPrima> lista = new ArrayList<>();

            while (rs.next()) {
                TbMateriaPrima tbMateriaPrima = new TbMateriaPrima(rs.getInt(1), rs.getString(2));
                lista.add(tbMateriaPrima);
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

}
