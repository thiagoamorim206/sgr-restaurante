package ControllerBean;

import ControllerDAO.PedidoDAO;
import Model.TbPedido;
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

}
