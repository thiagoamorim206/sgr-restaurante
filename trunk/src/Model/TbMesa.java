/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thiago
 */
@MappedSuperclass
@Table(name = "tb_mesa")
@XmlRootElement
public class TbMesa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mesa")
    private Integer idMesa;
    @Basic(optional = false)
    @Column(name = "nr_lugares")
    private int nrLugares;
    @Basic(optional = false)
    @Column(name = "fl_ocupada")
    private boolean flOcupada;
    @Basic(optional = false)
    @Column(name = "ds_obs")
    private String dsObs;
    @Basic(optional = false)
    @Column(name = "nm_mesa")
    private String nmMesa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMesa")
    private Collection<TbReserva> tbReservaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMesa")
    private Collection<TbPedido> tbPedidoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMesa")
    private Collection<TbCliente> tbClienteCollection;

    public TbMesa() {
    }

    public TbMesa(Integer idMesa) {
        this.idMesa = idMesa;
    }

    public TbMesa(Integer idMesa, int nrLugares, boolean flOcupada, String dsObs,String nmMesa) {
        this.idMesa = idMesa;
        this.nrLugares = nrLugares;
        this.flOcupada = flOcupada;
        this.dsObs = dsObs;
        this.nmMesa = nmMesa;
    }

    public Integer getIdMesa() {
        return idMesa;
    }

    public String getNmMesa() {
        return nmMesa;
    }

    public void setNmMesa(String nmMesa) {
        this.nmMesa = nmMesa;
    }
    

    public void setIdMesa(Integer idMesa) {
        this.idMesa = idMesa;
    }

    public int getNrLugares() {
        return nrLugares;
    }

    public void setNrLugares(int nrLugares) {
        this.nrLugares = nrLugares;
    }

    public boolean getFlOcupada() {
        return flOcupada;
    }

    public void setFlOcupada(boolean flOcupada) {
        this.flOcupada = flOcupada;
    }

    public String getDsObs() {
        return dsObs;
    }

    public void setDsObs(String dsObs) {
        this.dsObs = dsObs;
    }

    @XmlTransient
    public Collection<TbReserva> getTbReservaCollection() {
        return tbReservaCollection;
    }

    public void setTbReservaCollection(Collection<TbReserva> tbReservaCollection) {
        this.tbReservaCollection = tbReservaCollection;
    }

    @XmlTransient
    public Collection<TbPedido> getTbPedidoCollection() {
        return tbPedidoCollection;
    }

    public void setTbPedidoCollection(Collection<TbPedido> tbPedidoCollection) {
        this.tbPedidoCollection = tbPedidoCollection;
    }

    @XmlTransient
    public Collection<TbCliente> getTbClienteCollection() {
        return tbClienteCollection;
    }

    public void setTbClienteCollection(Collection<TbCliente> tbClienteCollection) {
        this.tbClienteCollection = tbClienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMesa != null ? idMesa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbMesa)) {
            return false;
        }
        TbMesa other = (TbMesa) object;
        if ((this.idMesa == null && other.idMesa != null) || (this.idMesa != null && !this.idMesa.equals(other.idMesa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TbMesa[ idMesa=" + idMesa + " ]";
    }
    
}
