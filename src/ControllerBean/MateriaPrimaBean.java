package ControllerBean;

import ControllerDAO.MateriaPrimaDAO;
import Model.TbMateriaPrima;

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

    public void setMateriaPrima(TbMateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    public String CadastroMateriaPrima() {

        materiaPrima = materiaPrimaDAO.inserirMateriaPrima(materiaPrima);
        return "Sucesso"; // Caso de Sucesso

    }
}
