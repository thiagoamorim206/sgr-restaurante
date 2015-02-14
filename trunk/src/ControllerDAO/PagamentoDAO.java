package ControllerDAO;

import Model.TbPagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PagamentoDAO {

    public TbPagamento inserirPagamento(TbPagamento t) {
        Connection cn = null;

        try {

            cn = ConnectionFactory.getConnection();

            String SQL = "INSERT INTO tb_pagamento VALUES (nextval('tb_pagamento_id_pagamento_seq'), '" + t.getIdCliente() + "','" + t.getIdPedido() + "','" + t.getDtPagamento() + "','" + t.getVlTotalPago() + "')";

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

}
