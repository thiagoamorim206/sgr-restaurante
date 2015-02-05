/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thiago
 */
@MappedSuperclass
@Table(name = "tb_fila_pedido")
@XmlRootElement
public class TbFilaPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fila_pedido")
    private Integer idFilaPedido;
    @Basic(optional = false)
    @Column(name = "ds_status")
    private String dsStatus;
    @JoinColumn(name = "id_empregado", referencedColumnName = "id_empregado")
    @ManyToOne(optional = false)
    private TbEmpregado idEmpregado;
    @JoinColumn(name = "id_pedido_cardapio", referencedColumnName = "id_pedido_cardapio")
    @ManyToOne(optional = false)
    private TbPedidoCardapio idPedidoCardapio;

    public TbFilaPedido() {
    }

    public TbFilaPedido(Integer idFilaPedido) {
        this.idFilaPedido = idFilaPedido;
    }

    public TbFilaPedido(Integer idFilaPedido, String dsStatus) {
        this.idFilaPedido = idFilaPedido;
        this.dsStatus = dsStatus;
    }

    public Integer getIdFilaPedido() {
        return idFilaPedido;
    }

    public void setIdFilaPedido(Integer idFilaPedido) {
        this.idFilaPedido = idFilaPedido;
    }

    public String getDsStatus() {
        return dsStatus;
    }

    public void setDsStatus(String dsStatus) {
        this.dsStatus = dsStatus;
    }

    public TbEmpregado getIdEmpregado() {
        return idEmpregado;
    }

    public void setIdEmpregado(TbEmpregado idEmpregado) {
        this.idEmpregado = idEmpregado;
    }

    public TbPedidoCardapio getIdPedidoCardapio() {
        return idPedidoCardapio;
    }

    public void setIdPedidoCardapio(TbPedidoCardapio idPedidoCardapio) {
        this.idPedidoCardapio = idPedidoCardapio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFilaPedido != null ? idFilaPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFilaPedido)) {
            return false;
        }
        TbFilaPedido other = (TbFilaPedido) object;
        if ((this.idFilaPedido == null && other.idFilaPedido != null) || (this.idFilaPedido != null && !this.idFilaPedido.equals(other.idFilaPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TbFilaPedido[ idFilaPedido=" + idFilaPedido + " ]";
    }
    
}
