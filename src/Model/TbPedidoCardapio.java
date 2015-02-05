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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tb_pedido_cardapio")
@XmlRootElement
public class TbPedidoCardapio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pedido_cardapio")
    private Integer idPedidoCardapio;
    @JoinColumn(name = "id_cardapio", referencedColumnName = "id_cardapio")
    @ManyToOne(optional = false)
    private int idCardapio;
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    @ManyToOne(optional = false)
    private int idPedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPedidoCardapio")
    private Collection<TbFilaPedido> tbFilaPedidoCollection;

    public TbPedidoCardapio() {
    }

    public TbPedidoCardapio(Integer idPedidoCardapio) {
        this.idPedidoCardapio = idPedidoCardapio;
    }

    public Integer getIdPedidoCardapio() {
        return idPedidoCardapio;
    }

    public void setIdPedidoCardapio(Integer idPedidoCardapio) {
        this.idPedidoCardapio = idPedidoCardapio;
    }

    public int getIdCardapio() {
        return idCardapio;
    }

    public void setIdCardapio(int idCardapio) {
        this.idCardapio = idCardapio;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    

//    public TbCardapio getIdCardapio() {
//        return idCardapio;
//    }
//
//    public void setIdCardapio(TbCardapio idCardapio) {
//        this.idCardapio = idCardapio;
//    }
//
//    public TbPedido getIdPedido() {
//        return idPedido;
//    }
//
//    public void setIdPedido(TbPedido idPedido) {
//        this.idPedido = idPedido;
//    }

    @XmlTransient
    public Collection<TbFilaPedido> getTbFilaPedidoCollection() {
        return tbFilaPedidoCollection;
    }

    public void setTbFilaPedidoCollection(Collection<TbFilaPedido> tbFilaPedidoCollection) {
        this.tbFilaPedidoCollection = tbFilaPedidoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedidoCardapio != null ? idPedidoCardapio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPedidoCardapio)) {
            return false;
        }
        TbPedidoCardapio other = (TbPedidoCardapio) object;
        if ((this.idPedidoCardapio == null && other.idPedidoCardapio != null) || (this.idPedidoCardapio != null && !this.idPedidoCardapio.equals(other.idPedidoCardapio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TbPedidoCardapio[ idPedidoCardapio=" + idPedidoCardapio + " ]";
    }
    
}
