package ControllerBean;

import ControllerDAO.CompraProdutoDAO;
import Model.TbCompraProduto;
import java.util.Date;

public class CompraProdutoBean {

    private TbCompraProduto compraProduto = new TbCompraProduto();
    private final CompraProdutoDAO compraProdutoDAO = new CompraProdutoDAO();

    public CompraProdutoBean(int IdEmpregado, int IdFornecedor, int IdMateriaPrima, Date DtCompra, int NrQtdCompra, String DsObs) {
        compraProduto.setIdEmpregado(IdEmpregado);
        compraProduto.setIdFornecedor(IdFornecedor);
        compraProduto.setIdMateriaPrima(IdMateriaPrima);
        compraProduto.setDtCompra(DtCompra);
        compraProduto.setNrQtdCompra(NrQtdCompra);
        compraProduto.setDsObs(DsObs);
    }

    public TbCompraProduto getCompraProduto() {
        return compraProduto;
    }

    public CompraProdutoBean() {
    }

    public void setCompraProduto(TbCompraProduto compraProduto) {
        this.compraProduto = compraProduto;
    }

    public String CadastroCompraProduto() {

        compraProduto = compraProdutoDAO.inserirCompraProduto(compraProduto);//salva
        return "Sucesso"; // Caso de Sucesso

    }

    public String ListarCompraProduto() {

        compraProdutoDAO.listarCompraProdutos();
        return "Sucesso";
    }
    
      public String DeletarProduto(int idProduto) {
        compraProdutoDAO.deletarCompraProduto(idProduto);
        return "Sucesso";
    }

}
