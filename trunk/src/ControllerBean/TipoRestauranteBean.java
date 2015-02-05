package ControllerBean;

import Model.TbTipoRestaurante;
import ControllerDAO.TipoRestauranteDAO;

public class TipoRestauranteBean {

    private TbTipoRestaurante tipoRestaurante = new TbTipoRestaurante();
    private final TipoRestauranteDAO tipoRestauranteDao = new TipoRestauranteDAO();

    public TipoRestauranteBean(String nome_tipo) {
        tipoRestaurante.setNmTipo(nome_tipo);
    }

    public TbTipoRestaurante getTipoRestaurante() {
        return tipoRestaurante;
    }

    public void setTipoRestaurante(TbTipoRestaurante tipoRestaurante) {
        this.tipoRestaurante = tipoRestaurante;
    }

    public String CadastroTipoRestaurante() {
        if (tipoRestaurante.getNmTipo()!= null) { // verifica se eh nulo
            tipoRestaurante = tipoRestauranteDao.inserirTipoRestaurante(tipoRestaurante);//salva
            return "Sucesso"; // Caso de Sucesso
        } else {
            return "Erro"; // CASO CONTRARIO MANDA UM ALERT DE ERRO
        }
    }

}
