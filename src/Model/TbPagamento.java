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
@Table(name = "tb_pagamento")
@XmlRootElement
public class TbPagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pagamento")
    private Integer idPagamento;
    @Basic(optional = false)
    @Column(name = "dt_pagamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtPagamento;
    @Basic(optional = false)
    @Column(name = "vl_total_pago")
    private float vlTotalPago;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private TbCliente idCliente;
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    @ManyToOne(optional = false)
    private TbPedido idPedido;

    public TbPagamento() {
    }

    public TbPagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }

    public TbPagamento(Integer idPagamento, Date dtPagamento, float vlTotalPago) {
        this.idPagamento = idPagamento;
        this.dtPagamento = dtPagamento;
        this.vlTotalPago = vlTotalPago;
    }

    public Integer getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Date getDtPagamento() {
        return dtPagamento;
    }

    public void setDtPagamento(Date dtPagamento) {
        this.dtPagamento = dtPagamento;
    }

    public float getVlTotalPago() {
        return vlTotalPago;
    }

    public void setVlTotalPago(float vlTotalPago) {
        this.vlTotalPago = vlTotalPago;
    }

    public TbCliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(TbCliente idCliente) {
        this.idCliente = idCliente;
    }

    public TbPedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(TbPedido idPedido) {
        this.idPedido = idPedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPagamento != null ? idPagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPagamento)) {
            return false;
        }
        TbPagamento other = (TbPagamento) object;
        if ((this.idPagamento == null && other.idPagamento != null) || (this.idPagamento != null && !this.idPagamento.equals(other.idPagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TbPagamento[ idPagamento=" + idPagamento + " ]";
    }
    
}
