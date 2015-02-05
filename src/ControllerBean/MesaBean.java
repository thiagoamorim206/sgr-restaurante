package ControllerBean;

import ControllerDAO.MesaDAO;
import Model.TbMesa;

public class MesaBean {

    private TbMesa mesa = new TbMesa();
    private final MesaDAO mesaDAO = new MesaDAO();

    public MesaBean(int nrLugares, boolean Ocupada, String Obs) {
        mesa.setNrLugares(nrLugares);
        mesa.setFlOcupada(Ocupada);
        mesa.setDsObs(Obs);

    }

    public TbMesa getMesa() {
        return mesa;
    }

    public void setMesa(TbMesa mesa) {
        this.mesa = mesa;
    }

    public String CadastroMesa() {

        mesa = mesaDAO.inserirMesa(mesa);//salva
        return "Sucesso"; // Caso de Sucesso

    }
}
