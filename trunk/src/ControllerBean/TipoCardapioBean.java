package ControllerBean;

import ControllerDAO.TipoCardapioDAO;
import Model.TbTipoCardapio;

public class TipoCardapioBean {

    private TbTipoCardapio tipoCardapio = new TbTipoCardapio();
    private final TipoCardapioDAO tipoCardapioDao = new TipoCardapioDAO();

    public TipoCardapioBean(String nome_tipo) {
        tipoCardapio.setNmTipo(nome_tipo);
    }

    public TbTipoCardapio getTipoCardapio() {
        return tipoCardapio;
    }

    public void setTipoCardapio(TbTipoCardapio tipoCardapio) {
        this.tipoCardapio = tipoCardapio;
    }

    public String CadastroTipoCardapio() {
        if (tipoCardapio.getNmTipo() != null) { // verifica se eh nulo
            tipoCardapio = tipoCardapioDao.inserirTipoCardapio(tipoCardapio);//salva
            return "Sucesso"; // Caso de Sucesso
        } else {
            return "Erro"; // CASO CONTRARIO MANDA UM ALERT DE ERRO
        }
    }
}
