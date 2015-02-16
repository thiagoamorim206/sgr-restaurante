package ControllerBean;

import ControllerDAO.PagamentoDAO;
import Model.TbPagamento;
import java.util.Date;

public class PagamentoBean {

    private TbPagamento pagamento = new TbPagamento();
    private final PagamentoDAO pagamentoDAO = new PagamentoDAO();

    public PagamentoBean(int IdCliente, Date DtPagamento, double VlTotalPago, boolean dspago) {
        pagamento.setIdCliente(IdCliente);
        pagamento.setDtPagamento(DtPagamento);
        pagamento.setVlTotalPago(VlTotalPago);
        pagamento.setDsPago(dspago);
    }

    public PagamentoBean() {
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

    public double ValorTotalPagar(int idcliente) {
        this.getPagamento().setIdCliente(idcliente);
        return pagamentoDAO.valorTotalPagar(this.getPagamento());
    }

    public int MostrarMesa(int idcliente) {
        this.getPagamento().setIdCliente(idcliente);
        return pagamentoDAO.mostarMesa(this.getPagamento());
    }

    public boolean ListarPagamentos() {

        boolean teste = pagamentoDAO.listarPagamentos();
        return teste;
    }

    public String DeletarPagamento(int idPagamentos) {
        pagamentoDAO.deletarPagamento(idPagamentos);
        return "Sucesso";
    }
}
