package ControllerBean;

import ControllerDAO.PagamentoDAO;
import Model.TbPagamento;
import java.util.Date;

public class PagamentoBean {

    private TbPagamento pagamento = new TbPagamento();
    private final PagamentoDAO pagamentoDAO = new PagamentoDAO();

    public PagamentoBean(int IdCliente, int IdPedido, Date DtPagamento, double VlTotalPago) {
        pagamento.setIdCliente(IdCliente);
        pagamento.setIdPedido(IdPedido);
        pagamento.setDtPagamento(DtPagamento);
        pagamento.setVlTotalPago(VlTotalPago);
    }

    public TbPagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(TbPagamento pagamento) {
        this.pagamento = pagamento;
    }

    public String CadastroPagamento() {

        pagamento = pagamentoDAO.inserirPagamento(pagamento);//salva
        return "Sucesso"; // Caso de Sucesso

    }

}
