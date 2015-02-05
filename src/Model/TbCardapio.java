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
@Table(name = "tb_cardapio")
@XmlRootElement
public class TbCardapio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cardapio")
    private Integer idCardapio;
    @Basic(optional = false)
    @Column(name = "nm_item_cardapio")
    private String nmItemCardapio;
    @Basic(optional = false)
    @Column(name = "vl_item")
    private float vlItem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCardapio")
    private Collection<TbPedidoCardapio> tbPedidoCardapioCollection;
    @JoinColumn(name = "id_tipo_cardapio", referencedColumnName = "id_tipo_cardapio")
    @ManyToOne(optional = false)
    private TbTipoCardapio idTipoCardapio;
    @JoinColumn(name = "id_tipo_restaurante", referencedColumnName = "id_tipo_restaurante")
    @ManyToOne(optional = false)
    private TbTipoRestaurante idTipoRestaurante;

    public TbCardapio() {
    }

    public TbCardapio(Integer idCardapio) {
        this.idCardapio = idCardapio;
    }

    public TbCardapio(Integer idCardapio, String nmItemCardapio, float vlItem) {
        this.idCardapio = idCardapio;
        this.nmItemCardapio = nmItemCardapio;
        this.vlItem = vlItem;
    }

    public Integer getIdCardapio() {
        return idCardapio;
    }

    public void setIdCardapio(Integer idCardapio) {
        this.idCardapio = idCardapio;
    }

    public String getNmItemCardapio() {
        return nmItemCardapio;
    }

    public void setNmItemCardapio(String nmItemCardapio) {
        this.nmItemCardapio = nmItemCardapio;
    }

    public float getVlItem() {
        return vlItem;
    }

    public void setVlItem(float vlItem) {
        this.vlItem = vlItem;
    }

    @XmlTransient
    public Collection<TbPedidoCardapio> getTbPedidoCardapioCollection() {
        return tbPedidoCardapioCollection;
    }

    public void setTbPedidoCardapioCollection(Collection<TbPedidoCardapio> tbPedidoCardapioCollection) {
        this.tbPedidoCardapioCollection = tbPedidoCardapioCollection;
    }

    public TbTipoCardapio getIdTipoCardapio() {
        return idTipoCardapio;
    }

    public void setIdTipoCardapio(TbTipoCardapio idTipoCardapio) {
        this.idTipoCardapio = idTipoCardapio;
    }

    public TbTipoRestaurante getIdTipoRestaurante() {
        return idTipoRestaurante;
    }

    public void setIdTipoRestaurante(TbTipoRestaurante idTipoRestaurante) {
        this.idTipoRestaurante = idTipoRestaurante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCardapio != null ? idCardapio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCardapio)) {
            return false;
        }
        TbCardapio other = (TbCardapio) object;
        if ((this.idCardapio == null && other.idCardapio != null) || (this.idCardapio != null && !this.idCardapio.equals(other.idCardapio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TbCardapio[ idCardapio=" + idCardapio + " ]";
    }
    
}
