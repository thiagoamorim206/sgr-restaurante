package ControllerBean;

import Model.TbTipoRestaurante;
import ControllerDAO.TipoRestauranteDAO;
import java.util.ArrayList;

public class TipoRestauranteBean {

    private TbTipoRestaurante tipoRestaurante = new TbTipoRestaurante();
    private final TipoRestauranteDAO tipoRestauranteDao = new TipoRestauranteDAO();

    public TipoRestauranteBean(String nome_tipo) {
        tipoRestaurante.setNmTipo(nome_tipo);
    }

    public TipoRestauranteBean() {
    }

    public TbTipoRestaurante getTipoRestaurante() {
        return tipoRestaurante;
    }

    public void setTipoRestaurante(TbTipoRestaurante tipoRestaurante) {
        this.tipoRestaurante = tipoRestaurante;
    }

    public String CadastroTipoRestaurante() {

        tipoRestaurante = tipoRestauranteDao.inserirTipoRestaurante(tipoRestaurante);//salva
        return "Sucesso"; // Caso de Sucesso

    }

    public String ListarTipoRestaurante() {

        tipoRestauranteDao.listarTipoRestaurante();
        return "Sucesso";
    }

    public String DeletarTipoRestaurante(int IdTipoRestaurante) {
        tipoRestauranteDao.deletarTipoRestaurante(IdTipoRestaurante);
        return "Sucesso";
    }

    public String AtualizarTipoRestaurante(TbTipoRestaurante tr, int x) {
        tipoRestauranteDao.AtualizarTipoRestaurante(tr, x);
        return "Sucesso";
    }

}
