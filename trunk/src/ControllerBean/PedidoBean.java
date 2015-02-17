package ControllerBean;

import ControllerDAO.PedidoDAO;
import Model.TbPedido;
import java.util.ArrayList;
import java.util.Date;

public class PedidoBean {

    private TbPedido pedido = new TbPedido();
    private final PedidoDAO pedidoDAO = new PedidoDAO();

    public PedidoBean(int IdMesa, Date DtPedido, double VlTotalConsumo, boolean DsPago) {
        pedido.setIdMesa(IdMesa);
        pedido.setDtPedido(DtPedido);
        pedido.setVlTotalConsumo(VlTotalConsumo);
        pedido.setDsPago(DsPago);

    }

    public PedidoBean() {
    }

    public TbPedido getPedido() {
        return pedido;
    }

    public void setPedido(TbPedido pedido) {
        this.pedido = pedido;
    }

    public String CadastroPedido() {
        pedido = pedidoDAO.inserirPedido(pedido);//salva
        return "Sucesso"; // Caso de Sucesso
    }

    public int listaUltimo() {
        ArrayList<TbPedido> lista = pedidoDAO.listarUltimoPedido();

        for (TbPedido o : lista) {
            return o.getIdPedido();
        }
        return 0;

    }

    public String ListarPedidos() {
        pedidoDAO.listarPedidos();
        return "Sucesso";

    }

    public String AtualizarPago(boolean x, int idMesa) {

        this.getPedido().setDsPago(x);
        this.getPedido().setIdMesa(idMesa);

        pedidoDAO.AtualizarPago(this.getPedido());
        return "Sucesso";
    }

    public String DeletarPedido(int idPedido) {
        pedidoDAO.deletarPedido(idPedido);
        return "Sucesso";
    }

    public double totaldaMesa(int id) {
        return pedidoDAO.totalMesa(id);
    }
}
