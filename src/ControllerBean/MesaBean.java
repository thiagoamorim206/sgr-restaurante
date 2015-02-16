package ControllerBean;

import ControllerDAO.MesaDAO;
import Model.TbCliente;
import Model.TbMesa;
import java.util.ArrayList;

public class MesaBean {

    private TbMesa mesa = new TbMesa();
    private TbCliente cliente = new TbCliente();
    private final MesaDAO mesaDAO = new MesaDAO();

    public MesaBean(int nrLugares, boolean Ocupada, String Obs, String nmMesa) {
        mesa.setNrLugares(nrLugares);
        mesa.setFlOcupada(Ocupada);
        mesa.setDsObs(Obs);
        mesa.setNmMesa(nmMesa);

    }

    public MesaBean() {
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

    public String ListarMesa() {

        ArrayList<TbMesa> lista = mesaDAO.listarMesa();
        if (lista.size() != 0) {
            for (TbMesa o : lista) {
                System.out.println("Codigo: " + o.getIdMesa() + " Nome: " + o.getNmMesa()
                        + " QTDLugares: " + o.getNrLugares() + " Obs: " + o.getDsObs());
            }
            return "Sucesso";
        } else {
            return "Todas as mesas estão Ocupadas";

        }
    }

    public String AtualizarMesa(boolean x, int idMesa) {
        this.getMesa().setFlOcupada(x);
        this.getMesa().setIdMesa(idMesa);
        mesaDAO.AtualizarMesa(this.getMesa());
        return "Sucesso";
    }

    public String ListarTodasMesa() {

        ArrayList<TbMesa> lista = mesaDAO.listarMesa();

        for (TbMesa o : lista) {
            System.out.println("Codigo: " + o.getIdMesa() + " Nome: " + o.getNmMesa()
                    + " QTDLugares: " + o.getNrLugares() + " Obs: " + o.getDsObs());
        }
        return "Sucesso";

    }

    public String DeletarMesa(int idMesa) {
        mesaDAO.deletarMesa(idMesa);
        return "Sucesso";
    }

}
