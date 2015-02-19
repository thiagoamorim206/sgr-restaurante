package ControllerBean;

import Controller.Mesa;
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

    public ArrayList ListarMesa() {
        ArrayList<Mesa> lista = mesaDAO.listarMesa();
        
        for (int i = 0; i < lista.size(); i++) {

            System.out.println("Codigo: " + lista.get(i).getId_mesa() + " - Mesa: " + lista.get(i).getNm_mesa()
                    + " - Lugares: " + lista.get(i).getNr_lugares());
        }

        return lista;

    }

    public String AtualizarMesa(boolean x, int idMesa) {
        this.getMesa().setFlOcupada(x);
        this.getMesa().setIdMesa(idMesa);
        mesaDAO.AtualizarMesa(this.getMesa());
        return "Sucesso";
    }

    public String ListarTodasMesa() {
        mesaDAO.listarTodasMesa();
        return "Sucesso";
    }

    public String ListarTodasMesaClientes() {
        mesaDAO.listarTodasMesa();
        return "Sucesso";
    }

    public String DeletarMesa(int idMesa) {
        mesaDAO.deletarMesa(idMesa);
        return "Sucesso";
    }

    public String AtualizarMesa(TbMesa m, int x) {
        mesaDAO.AtualizarMesa(m, x);
        return "Sucesso";
    }

}
