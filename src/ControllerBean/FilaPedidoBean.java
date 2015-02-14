package ControllerBean;

import ControllerDAO.FilaPedidoDAO;
import Model.TbFilaPedido;

public class FilaPedidoBean {

    private TbFilaPedido filaPedido = new TbFilaPedido();
    private final FilaPedidoDAO filaPedidoDAO = new FilaPedidoDAO();

    public FilaPedidoBean(int IdPedidoCardapio, int IdEmpregado, String DsStatus) {
        filaPedido.setIdPedidoCardapio(IdPedidoCardapio);
        filaPedido.setIdEmpregado(IdEmpregado);
        filaPedido.setDsStatus(DsStatus);

    }

    public TbFilaPedido getFilaPedido() {
        return filaPedido;
    }

    public void setFilaPedido(TbFilaPedido filaPedido) {
        this.filaPedido = filaPedido;
    }

    public String CadastroFilaPedido() {

        filaPedido = filaPedidoDAO.inserirFilaPedido(filaPedido);//salva
        return "Sucesso"; // Caso de Sucesso

    }

}
