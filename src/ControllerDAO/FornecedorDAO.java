package ControllerDAO;

import Model.TbFornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public boolean listarFornecedor() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "select id_fornecedor, nm_fornecedor from tb_fornecedor";

            PreparedStatement ps = cn.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Codigo: " + rs.getInt(1) + " - Nome: " + rs.getString(2));
                return true;
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
