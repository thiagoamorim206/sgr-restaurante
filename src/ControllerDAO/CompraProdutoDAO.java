package ControllerDAO;

import Model.TbCompraProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompraProdutoDAO {

    public TbCompraProduto inserirCompraProduto(TbCompraProduto t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "INSERT INTO tb_compra_produto VALUES (nextval('tb_compra_produto_id_compra_produto_seq'), '"
                    + t.getIdEmpregado() + "','" + t.getIdFornecedor() + "','" + t.getIdMateriaPrima() + "','"
                    + t.getDtCompra() + "','" + t.getNrQtdCompra() + "','" + t.getDsObs() + "')";

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

    public TbCompraProduto listarCompraProdutos() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "select  cp.id_compra_produto, p.nm_nome, mp.nm_produto, f.nm_fornecedor, cp.nr_qtd_compra\n"
                    + "from tb_materia_prima mp, tb_compra_produto cp, tb_fornecedor f, tb_empregado e, tb_pessoa p\n"
                    + "where mp.id_materia_prima = cp.id_materia_prima\n"
                    + "  and cp.id_fornecedor = f.id_fornecedor\n"
                    + "  and cp.id_empregado = e.id_empregado\n"
                    + "  and e.id_pessoa = p.id_pessoa \n"
                    + "group by cp.id_compra_produto, p.nm_nome, mp.nm_produto, f.nm_fornecedor ";

            PreparedStatement ps = cn.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Codigo: " + rs.getInt(1) + " - Empregado: " + rs.getString(2)
                        + " - Produto: " + rs.getString(3)
                        + " - Fornecedor: " + rs.getString(4)
                        + " - Num. Estoque: " + rs.getInt(5)
                );
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

    public TbCompraProduto deletarCompraProduto(int id_compra_produto) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "delete from tb_compra_produto \n"
                    + "where id_compra_produto = " + id_compra_produto + "";

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
