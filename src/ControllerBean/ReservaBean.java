package ControllerBean;

import ControllerDAO.ReservaDAO;
import Model.TbReserva;
import java.util.Date;

public class ReservaBean {

    private TbReserva reserva = new TbReserva();
    private final ReservaDAO reservaDAO = new ReservaDAO();

    public ReservaBean(int IdEmpregado, int IdMesa, String NmReserva, Date DtReserva, String NmEstadoReserva, int NrLugarReserva) {
        reserva.setIdEmpregado(IdEmpregado);
        reserva.setIdMesa(IdMesa);
        reserva.setNmReserva(NmReserva);
        reserva.setDtReserva(DtReserva);
        reserva.setNmEstadoReserva(NmEstadoReserva);
        reserva.setNrLugarReserva(NrLugarReserva);
    }

    public ReservaBean() {
    }

    public TbReserva getReserva() {
        return reserva;
    }

    public void setReserva(TbReserva reserva) {
        this.reserva = reserva;
    }

    public String CadastroReserva() {

        reserva = reservaDAO.inserirReserva(reserva);//salva
        return "Sucesso"; // Caso de Sucesso

    }

    public String ListarReservas() {

        reservaDAO.listarReservas();//salva
        return "Sucesso";

    }

    public String DeletarReserva(int idReserva) {
        reservaDAO.deletarReserva(idReserva);
        return "Sucesso";
    }

}
