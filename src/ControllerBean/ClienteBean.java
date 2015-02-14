package ControllerBean;

import ControllerDAO.ClienteDAO;
import Model.TbCliente;

public class ClienteBean {

    private TbCliente cliente = new TbCliente();
    private final ClienteDAO clienteDAO = new ClienteDAO();

    public ClienteBean(int IdMesa, int IdPessoa) {
        cliente.setIdMesa(IdMesa);
        cliente.setIdPessoa(IdPessoa);
    }

    public TbCliente getCliente() {
        return cliente;
    }

    public void setCliente(TbCliente cliente) {
        this.cliente = cliente;
    }

    public String CadastroPagamento() {

        cliente = clienteDAO.inserirCliente(cliente);//salva
        return "Sucesso"; // Caso de Sucesso

    }
}
