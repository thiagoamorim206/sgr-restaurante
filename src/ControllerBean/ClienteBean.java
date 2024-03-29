package ControllerBean;

import ControllerDAO.ClienteDAO;
import Model.TbCliente;
import Model.TbPessoa;
import java.util.ArrayList;

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

    public String ListarClientePagar() {

        clienteDAO.listaCliente();
        return "Sucesso";
    }

    public String ListarTodosClientes() {

        clienteDAO.listaTodosClientes();
        return "Sucesso";
    }

    public String ListarTudoCliente() {

        clienteDAO.listaTudoCliente();
        return "Sucesso";
    }

    public String AtualizarPessoa(TbPessoa p, int x) {
        clienteDAO.AtualizarPessoa(p, x);
        return "Sucesso";
    }

    public String DeletarCliente(int idCliente) {
        clienteDAO.deletarPessoa(idCliente);
        clienteDAO.deletarCliente(idCliente);
        return "Sucesso";
    }

    ///////ALTERADO POR ADRIANO
    public int mesadoCliente(int id) {
        return clienteDAO.verMesa(id);
    }

    ////ALTERADO POR ADRIANO
    public ArrayList verclientesAtender() {
        return clienteDAO.clientesemAtedimento();
    }

}
