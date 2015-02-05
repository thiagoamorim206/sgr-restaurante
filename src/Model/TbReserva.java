/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thiago
 */
@MappedSuperclass
@Table(name = "tb_reserva")
@XmlRootElement
public class TbReserva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reserva")
    private Integer idReserva;
    @Basic(optional = false)
    @Column(name = "nm_reserva")
    private String nmReserva;
    @Basic(optional = false)
    @Column(name = "dt_reserva")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtReserva;
    @Basic(optional = false)
    @Column(name = "nm_estado_reserva")
    private String nmEstadoReserva;
    @Basic(optional = false)
    @Column(name = "nr_lugar_reserva")
    private int nrLugarReserva;
    @JoinColumn(name = "id_empregado", referencedColumnName = "id_empregado")
    @ManyToOne(optional = false)
    private TbEmpregado idEmpregado;
    @JoinColumn(name = "id_mesa", referencedColumnName = "id_mesa")
    @ManyToOne(optional = false)
    private TbMesa idMesa;

    public TbReserva() {
    }

    public TbReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public TbReserva(Integer idReserva, String nmReserva, Date dtReserva, String nmEstadoReserva, int nrLugarReserva) {
        this.idReserva = idReserva;
        this.nmReserva = nmReserva;
        this.dtReserva = dtReserva;
        this.nmEstadoReserva = nmEstadoReserva;
        this.nrLugarReserva = nrLugarReserva;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public String getNmReserva() {
        return nmReserva;
    }

    public void setNmReserva(String nmReserva) {
        this.nmReserva = nmReserva;
    }

    public Date getDtReserva() {
        return dtReserva;
    }

    public void setDtReserva(Date dtReserva) {
        this.dtReserva = dtReserva;
    }

    public String getNmEstadoReserva() {
        return nmEstadoReserva;
    }

    public void setNmEstadoReserva(String nmEstadoReserva) {
        this.nmEstadoReserva = nmEstadoReserva;
    }

    public int getNrLugarReserva() {
        return nrLugarReserva;
    }

    public void setNrLugarReserva(int nrLugarReserva) {
        this.nrLugarReserva = nrLugarReserva;
    }

    public TbEmpregado getIdEmpregado() {
        return idEmpregado;
    }

    public void setIdEmpregado(TbEmpregado idEmpregado) {
        this.idEmpregado = idEmpregado;
    }

    public TbMesa getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(TbMesa idMesa) {
        this.idMesa = idMesa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReserva != null ? idReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbReserva)) {
            return false;
        }
        TbReserva other = (TbReserva) object;
        if ((this.idReserva == null && other.idReserva != null) || (this.idReserva != null && !this.idReserva.equals(other.idReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TbReserva[ idReserva=" + idReserva + " ]";
    }
    
}
