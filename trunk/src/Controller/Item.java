package Controller;

import Model.TbPedido;
import java.util.Date;

public class Item extends TbPedido {

    private TbPedido pedido;
    private double valor;

    public Item(TbPedido pedido, double valor) {
        this.pedido = pedido;
        this.valor = valor;
    }

    public Integer getIdPedido() {
        return pedido.getIdPedido();
    }

    public Date getDtPedido() {
        return pedido.getDtPedido();
    }

    public boolean getDsPago() {
        return pedido.getDsPago();
    }

    public int getIdMesa() {
        return pedido.getIdMesa();
    }

    public double coust() {
        return this.valor + pedido.coust();
    }

}
