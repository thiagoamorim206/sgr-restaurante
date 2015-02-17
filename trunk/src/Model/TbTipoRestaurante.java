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
@Table(name = "tb_tipo_restaurante")
@XmlRootElement
public class TbTipoRestaurante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_restaurante")
    private Integer idTipoRestaurante;
    @Basic(optional = false)
    @Column(name = "nm_tipo")
    private String nmTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoRestaurante")
    private Collection<TbCardapio> tbCardapioCollection;

    public TbTipoRestaurante() {
    }

    public TbTipoRestaurante(Integer idTipoRestaurante) {
        this.idTipoRestaurante = idTipoRestaurante;
    }

    public TbTipoRestaurante(Integer idTipoRestaurante, String nmTipo) {
        this.idTipoRestaurante = idTipoRestaurante;
        this.nmTipo = nmTipo;
    }

    public TbTipoRestaurante(String nmTipo) {

        this.nmTipo = nmTipo;
    }

    public Integer getIdTipoRestaurante() {
        return idTipoRestaurante;
    }

    public void setIdTipoRestaurante(Integer idTipoRestaurante) {
        this.idTipoRestaurante = idTipoRestaurante;
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
        hash += (idTipoRestaurante != null ? idTipoRestaurante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTipoRestaurante)) {
            return false;
        }
        TbTipoRestaurante other = (TbTipoRestaurante) object;
        if ((this.idTipoRestaurante == null && other.idTipoRestaurante != null) || (this.idTipoRestaurante != null && !this.idTipoRestaurante.equals(other.idTipoRestaurante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TbTipoRestaurante[ idTipoRestaurante=" + idTipoRestaurante + " ]";
    }

}
