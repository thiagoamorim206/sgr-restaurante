package ControllerDAO;

import Model.TbFornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FornecedorDAO {

    public TbFornecedor inserirFornecedor(TbFornecedor t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "INSERT INTO tb_fornecedor VALUES (nextval('tb_fornecedor_id_fornecedor_seq'), '"
                    + t.getNmFornecedor() + "','" + t.getNrCelular() + "','" + t.getNrTelefone() + "','"
                    + t.getNmEmail() + "','" + t.getDsObs() + "')";

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

    public ArrayList listarFornecedor() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "select id_fornecedor, nm_fornecedor from tb_fornecedor";

            PreparedStatement ps = cn.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            ArrayList<TbFornecedor> lista = new ArrayList<>();

            while (rs.next()) {
                TbFornecedor tbFornecedor = new TbFornecedor(rs.getInt(1), rs.getString(2));
                lista.add(tbFornecedor);
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

    public TbFornecedor deletarFornecedor(int id_fornecedor) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "delete from tb_fornecedor \n"
                    + "where id_fornecedor = " + id_fornecedor + "";

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

}
