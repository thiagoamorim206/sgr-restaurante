package ControllerBean;

import ControllerDAO.MateriaPrimaDAO;
import Model.TbMateriaPrima;
import java.util.ArrayList;

public class MateriaPrimaBean {

    private TbMateriaPrima materiaPrima = new TbMateriaPrima();
    private final MateriaPrimaDAO materiaPrimaDAO = new MateriaPrimaDAO();

    public MateriaPrimaBean(String NmProduto, int NrQtdEstoque, double VlProduto, String DsObs) {
        materiaPrima.setNmProduto(NmProduto);
        materiaPrima.setNrQtdEstoque(NrQtdEstoque);
        materiaPrima.setVlProduto(VlProduto);
        materiaPrima.setDsObs(DsObs);
    }

    public TbMateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public MateriaPrimaBean() {
    }

    public void setMateriaPrima(TbMateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    public String CadastroMateriaPrima() {

        materiaPrima = materiaPrimaDAO.inserirMateriaPrima(materiaPrima);
        return "Sucesso"; // Caso de Sucesso

    }

    public String ListarProduto() {

        ArrayList<TbMateriaPrima> lista = materiaPrimaDAO.listarProdutos();

        for (TbMateriaPrima o : lista) {
            System.out.println("Codigo: " + o.getIdMateriaPrima() + " Nome: " + o.getNmProduto());
        }
        return "Sucesso";
    }

    public String AtualizarEstoque(int x, int idProduto) {
        int v = materiaPrimaDAO.listarQtdEstoque();
        this.getMateriaPrima().setNrQtdEstoque(v + x);
        this.getMateriaPrima().setIdMateriaPrima(idProduto);

        materiaPrimaDAO.AtualizarEstoque(this.getMateriaPrima());
        return "Sucesso";
    }

 

}
