package ControllerBean;

import ControllerDAO.PedidoCardapioDAO;
import Model.TbPedidoCardapio;
import java.util.ArrayList;

public class PedidoCardapioBean {

    private TbPedidoCardapio pedidoCardapio = new TbPedidoCardapio();
    private final PedidoCardapioDAO pedidocardapioDao = new PedidoCardapioDAO();

    public PedidoCardapioBean(int IdCardapio, int IdPedido) {
        pedidoCardapio.setIdCardapio(IdCardapio);
        pedidoCardapio.setIdPedido(IdPedido);
    }

    public TbPedidoCardapio getPedidoCardapio() {
        return pedidoCardapio;
    }

    public void setPedidoCardapio(TbPedidoCardapio pedidoCardapio) {
        this.pedidoCardapio = pedidoCardapio;
    }

    public String CadastroPedidoCardapio() {

        pedidoCardapio = pedidocardapioDao.inserirPedidoCardapio(pedidoCardapio);//salva
        return "Sucesso"; // Caso de Sucesso

    }

    public int listaUltimo() {
        ArrayList<TbPedidoCardapio> lista = pedidocardapioDao.listarUltimoPedidoCardapio();

        for (TbPedidoCardapio o : lista) {
            return o.getIdPedidoCardapio();
        }
        return 0;

    }

}
