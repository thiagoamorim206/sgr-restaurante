package ControllerBean;

import ControllerDAO.FornecedorDAO;
import Model.TbFornecedor;
import java.util.ArrayList;

public class FornecedorBean {

    private TbFornecedor fornecedor = new TbFornecedor();
    private final FornecedorDAO fornecedorDAO = new FornecedorDAO();

    public FornecedorBean(String NmFornecedor, String NrCelular, String NrTelefone, String NmEmail, String DsObs) {
        fornecedor.setNmFornecedor(NmFornecedor);
        fornecedor.setNrCelular(NrCelular);
        fornecedor.setNrTelefone(NrTelefone);
        fornecedor.setNmEmail(NmEmail);
        fornecedor.setDsObs(DsObs);
    }

    public FornecedorBean() {
    }

    public TbFornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(TbFornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String CadastroFornecedor() {

        fornecedor = fornecedorDAO.inserirFornecedor(fornecedor);//salva
        return "Sucesso"; // Caso de Sucesso

    }

    public String ListarFornecedor() {

        ArrayList<TbFornecedor> lista = fornecedorDAO.listarFornecedor();

        for (TbFornecedor o : lista) {
            System.out.println("Codigo: " + o.getIdFornecedor() + " Nome: " + o.getNmFornecedor());
        }
        return "Sucesso";
    }

    public String DeletarFornecedor(int IdFornecedor) {
        fornecedorDAO.deletarFornecedor(IdFornecedor);
        return "Sucesso";
    }

}
