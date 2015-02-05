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
@Table(name = "tb_tipo_cardapio")
@XmlRootElement
public class TbTipoCardapio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_cardapio")
    private Integer idTipoCardapio;
    @Basic(optional = false)
    @Column(name = "nm_tipo")
    private String nmTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoCardapio")
    private Collection<TbCardapio> tbCardapioCollection;

    public TbTipoCardapio() {
    }

    public TbTipoCardapio(Integer idTipoCardapio) {
        this.idTipoCardapio = idTipoCardapio;
    }

    public TbTipoCardapio(Integer idTipoCardapio, String nmTipo) {
        this.idTipoCardapio = idTipoCardapio;
        this.nmTipo = nmTipo;
    }

    public Integer getIdTipoCardapio() {
        return idTipoCardapio;
    }

    public void setIdTipoCardapio(Integer idTipoCardapio) {
        this.idTipoCardapio = idTipoCardapio;
    }

    public String getNmTipo() {
        return nmTipo;
    }

    public void setNmTipo(String nmTipo) {
        this.nmTipo = nmTipo;
    }

    @XmlTransient
    public Collection<TbCardapio> getTbCardapioCollection() {
        return tbCardapioCollection;
    }

    public void setTbCardapioCollection(Collection<TbCardapio> tbCardapioCollection) {
        this.tbCardapioCollection = tbCardapioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCardapio != null ? idTipoCardapio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTipoCardapio)) {
            return false;
        }
        TbTipoCardapio other = (TbTipoCardapio) object;
        if ((this.idTipoCardapio == null && other.idTipoCardapio != null) || (this.idTipoCardapio != null && !this.idTipoCardapio.equals(other.idTipoCardapio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TbTipoCardapio[ idTipoCardapio=" + idTipoCardapio + " ]";
    }
    
}
