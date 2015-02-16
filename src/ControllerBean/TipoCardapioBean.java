package ControllerBean;

import ControllerDAO.TipoCardapioDAO;
import Model.TbTipoCardapio;
import java.util.ArrayList;

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

        tipoCardapio = tipoCardapioDao.inserirTipoCardapio(tipoCardapio);//salva
        return "Sucesso"; // Caso de Sucesso

    }

    public String ListarTipoCardapio() {

        ArrayList<TbTipoCardapio> lista = tipoCardapioDao.listarTipoCardapio();

        for (TbTipoCardapio o : lista) {
            System.out.println("Codigo: " + o.getIdTipoCardapio() + " Nome: " + o.getNmTipo());
        }
        return "Sucesso";
    }

    public String DeletarTipoCardapio(int IdTipoCardapio) {
        tipoCardapioDao.deletarTipoCardapio(IdTipoCardapio);
        return "Sucesso";
    }
}
