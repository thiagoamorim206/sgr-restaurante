/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thiago
 */
@MappedSuperclass
@Table(name = "tb_pedido")
@XmlRootElement
public class TbPedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pedido")
    private Integer idPedido;
    @Basic(optional = false)
    @Column(name = "dt_pedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtPedido;

    @Basic(optional = false)
    @Column(name = "vl_total_consumo")
    private double vlTotalConsumo;

    @Basic(optional = false)
    @Column(name = "ds_pago")
    private boolean dsPago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPedido")
    private Collection<TbPedidoCardapio> tbPedidoCardapioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPedido")
    private Collection<TbPagamento> tbPagamentoCollection;
    @JoinColumn(name = "id_mesa", referencedColumnName = "id_mesa")
    @ManyToOne(optional = false)
    private int idMesa;

    public TbPedido() {
        vlTotalConsumo = 0;
    }

    public TbPedido(Integer idPedido) {
        this.idPedido = idPedido;
        vlTotalConsumo = 0;
    }

    public TbPedido(Date dtPedido, double vlTotalConsumo, String nmMesa, boolean dsPago) {
        this.dtPedido = dtPedido;
        this.vlTotalConsumo = vlTotalConsumo;
        this.dsPago = dsPago;

    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Date getDtPedido() {
        return dtPedido;
    }

    public void setDtPedido(Date dtPedido) {
        this.dtPedido = dtPedido;
    }

    public double getVlTotalConsumo() {
        return vlTotalConsumo;
    }

    public void setVlTotalConsumo(double vlTotalConsumo) {
        this.vlTotalConsumo = vlTotalConsumo;
    }

    public boolean getDsPago() {
        return dsPago;
    }

    public void setDsPago(boolean dsPago) {
        this.dsPago = dsPago;
    }

    public double coust() {
        return 0;
    }

    @XmlTransient
    public Collection<TbPedidoCardapio> getTbPedidoCardapioCollection() {
        return tbPedidoCardapioCollection;
    }

    public void setTbPedidoCardapioCollection(Collection<TbPedidoCardapio> tbPedidoCardapioCollection) {
        this.tbPedidoCardapioCollection = tbPedidoCardapioCollection;
    }

    @XmlTransient
    public Collection<TbPagamento> getTbPagamentoCollection() {
        return tbPagamentoCollection;
    }

    public void setTbPagamentoCollection(Collection<TbPagamento> tbPagamentoCollection) {
        this.tbPagamentoCollection = tbPagamentoCollection;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPedido)) {
            return false;
        }
        TbPedido other = (TbPedido) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TbPedido[ idPedido=" + idPedido + " ]";
    }

}
