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

    public ClienteBean() {
    }

    public void setCliente(TbCliente cliente) {
        this.cliente = cliente;
    }

    public String CadastroCliente() {

        cliente = clienteDAO.inserirCliente(cliente);//salva
        return "Sucesso"; // Caso de Sucesso

    }

    public boolean ListarClientePagar() {

        boolean teste = clienteDAO.listaCliente();
        return teste;
    }

    public boolean ListarTodosClientes() {

        boolean teste = clienteDAO.listaTodosClientes();
        return teste;
    }

    public String DeletarCliente(int idCliente) {
        clienteDAO.deletarPessoa(idCliente);
        clienteDAO.deletarCliente(idCliente);
        return "Sucesso";
    }

}
