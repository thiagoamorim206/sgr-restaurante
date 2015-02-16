package ControllerDAO;

import Model.TbPagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PagamentoDAO {

    public TbPagamento inserirPagamento(TbPagamento t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "INSERT INTO tb_pagamento VALUES (nextval('tb_pagamento_id_pagamento_seq'), '" + t.getIdCliente()
                    + "','" + t.getDtPagamento() + "','"
                    + t.getVlTotalPago() + "','"
                    + t.isDsPago() + "')";

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

    public double valorTotalPagar(TbPagamento t) {
        Connection cn = null;
        double pagar = 0;
        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "select c.id_cliente, p.nm_nome Pessoa, m.nm_nome mesa, sum(pe.vl_total_consumo)\n"
                    + "from tb_cliente c, tb_pessoa p, tb_mesa m, tb_pedido pe\n"
                    + "where c.id_pessoa = p.id_pessoa    \n"
                    + "     and c.id_mesa = m.id_mesa\n"
                    + "     and m.id_mesa = pe.id_mesa\n"
                    + "     and c.id_cliente = " + t.getIdCliente() + "\n"
                    + "     group by c.id_cliente, p.nm_nome, mesa\n"
                    + "     order by mesa";

            PreparedStatement ps = cn.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pagar = (rs.getDouble(4));
            }

            ConnectionFactory.desconecta(cn);
            cn = ConnectionFactory.getConnection();
            return pagar;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.desconecta(cn);
        }
        return -1;
    }

    public int mostarMesa(TbPagamento t) {
        Connection cn = null;
        int pagar = 0;
        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "select m.id_mesa\n"
                    + "from tb_cliente c, tb_pessoa p, tb_mesa m, tb_pedido pe\n"
                    + "where c.id_pessoa = p.id_pessoa    \n"
                    + "     and c.id_mesa = m.id_mesa\n"
                    + "     and m.id_mesa = pe.id_mesa\n"
                    + "     and c.id_cliente = " + t.getIdCliente() + "\n"
                    + "     group by m.id_mesa";

            PreparedStatement ps = cn.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pagar = (rs.getInt(1));
            }

            ConnectionFactory.desconecta(cn);
            cn = ConnectionFactory.getConnection();
            return pagar;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.desconecta(cn);
        }
        return -1;
    }

    public TbPagamento listarPagamentos() {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            Statement st = cn.createStatement();

            String SQL = "select pa.id_pagamento, p.nm_nome, pa.dt_pagamento, pa.vl_total_pago\n"
                    + "from tb_pagamento pa, tb_cliente c, tb_pessoa p\n"
                    + "where pa.id_cliente = c.id_cliente\n"
                    + "	and c.id_pessoa = p.id_pessoa";

            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                System.out.println("Codigo: " + rs.getInt(1) + " - Cliente: " + rs.getString(2)
                        + " - Data: " + rs.getDate(3)
                        + " - Total Pago: " + rs.getDouble(4)
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

    public TbPagamento deletarPagamento(int id_pagamento) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "delete from tb_pagamento \n"
                    + "where id_pagamento = " + id_pagamento + "";

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
