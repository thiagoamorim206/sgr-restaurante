package Controller;

/**
 *
 * @author Adriano
 */
public class Produto {

    private int id_pedido, id_cliente;
    private String status;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Produto() {
    }

    public Produto(int id_pedido, String status, int id_cliente) {
        this.id_pedido = id_pedido;
        this.status = status;
        this.id_cliente = id_cliente;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
