package ControllerBean;

import ControllerDAO.TipoCardapioDAO;
import Model.TbTipoCardapio;

public class TipoCardapioBean {

    private TbTipoCardapio tipoCardapio = new TbTipoCardapio();
    private final TipoCardapioDAO tipoCardapioDao = new TipoCardapioDAO();

    public TipoCardapioBean(String nome_tipo) {
        tipoCardapio.setNmTipo(nome_tipo);
    }

    public TipoCardapioBean() {
    }

    public TbTipoCardapio getTipoCardapio() {
        return tipoCardapio;
    }

    public void setTipoCardapio(TbTipoCardapio tipoCardapio) {
        this.tipoCardapio = tipoCardapio;
    }

    public String CadastroTipoCardapio() {

        tipoCardapioDao.inserirTipoCardapio(tipoCardapio);//salva
        return "Sucesso"; // Caso de Sucesso

    }

    public String ListarTipoCardapio() {

        tipoCardapioDao.listarTipoCardapio();
        return "Sucesso";
    }

    public String DeletarTipoCardapio(int IdTipoCardapio) {
        tipoCardapioDao.deletarTipoCardapio(IdTipoCardapio);
        return "Sucesso";
    }
    
     public String AtualizarTipoCardapio(TbTipoCardapio tc, int x) {
        tipoCardapioDao.AtualizarTipoCardapio(tc, x);
        return "Sucesso";
    }

}
