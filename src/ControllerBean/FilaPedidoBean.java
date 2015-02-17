package ControllerBean;

import ControllerDAO.FilaPedidoDAO;
import Model.TbFilaPedido;
import java.util.ArrayList;

public class FilaPedidoBean {

    private TbFilaPedido filaPedido = new TbFilaPedido();
    private final FilaPedidoDAO filaPedidoDAO = new FilaPedidoDAO();

    public FilaPedidoBean(int IdPedidoCardapio, int IdEmpregado, String DsStatus) {
        filaPedido.setIdPedidoCardapio(IdPedidoCardapio);
        filaPedido.setIdEmpregado(IdEmpregado);
        filaPedido.setDsStatus(DsStatus);

    }

    public FilaPedidoBean() {
    }

    public TbFilaPedido getFilaPedido() {
        return filaPedido;
    }

    public void setFilaPedido(TbFilaPedido filaPedido) {
        this.filaPedido = filaPedido;
    }

    public String CadastroFilaPedido() {

        filaPedidoDAO.inserirFilaPedido(filaPedido);//salva
        return "Sucesso"; // Caso de Sucesso

    }

    public String ListarFIlaPedidos() {

        filaPedidoDAO.listarFilaPedido();
        return "Sucesso";
    }

    ///////ALTERADO PELO ADRIANO
    public ArrayList PedidosaAtender() {
        return filaPedidoDAO.PedidosAtender();
    }

    ///////ALTERADO PELO ADRIANO
    public void atualizaStatus(int id) {
        filaPedidoDAO.atualizarStatus(id);
    }

}
