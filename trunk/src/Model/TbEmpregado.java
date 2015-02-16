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
@Table(name = "tb_empregado")
@XmlRootElement
public class TbEmpregado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empregado")
    private Integer idEmpregado;
    @Basic(optional = false)
    @Column(name = "ds_funcao_restaurante")
    private String dsFuncaoRestaurante;
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
    @ManyToOne(optional = false)
    private int idPessoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpregado")
    private Collection<TbReserva> tbReservaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpregado")
    private Collection<TbCompraProduto> tbCompraProdutoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpregado")
    private Collection<TbFilaPedido> tbFilaPedidoCollection;

    public TbEmpregado() {
    }

    public TbEmpregado(Integer idEmpregado) {
        this.idEmpregado = idEmpregado;
    }

    public TbEmpregado(String dsFuncaoRestaurante) {
        this.dsFuncaoRestaurante = dsFuncaoRestaurante;
    }

    public TbEmpregado(Integer idEmpregado, String dsFuncaoRestaurante) {
        this.idEmpregado = idEmpregado;
        this.dsFuncaoRestaurante = dsFuncaoRestaurante;
    }

    public Integer getIdEmpregado() {
        return idEmpregado;
    }

    public void setIdEmpregado(Integer idEmpregado) {
        this.idEmpregado = idEmpregado;
    }

    public String getDsFuncaoRestaurante() {
        return dsFuncaoRestaurante;
    }

    public void setDsFuncaoRestaurante(String dsFuncaoRestaurante) {
        this.dsFuncaoRestaurante = dsFuncaoRestaurante;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    @XmlTransient
    public Collection<TbReserva> getTbReservaCollection() {
        return tbReservaCollection;
    }

    public void setTbReservaCollection(Collection<TbReserva> tbReservaCollection) {
        this.tbReservaCollection = tbReservaCollection;
    }

    @XmlTransient
    public Collection<TbCompraProduto> getTbCompraProdutoCollection() {
        return tbCompraProdutoCollection;
    }

    public void setTbCompraProdutoCollection(Collection<TbCompraProduto> tbCompraProdutoCollection) {
        this.tbCompraProdutoCollection = tbCompraProdutoCollection;
    }

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
        hash += (idEmpregado != null ? idEmpregado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEmpregado)) {
            return false;
        }
        TbEmpregado other = (TbEmpregado) object;
        if ((this.idEmpregado == null && other.idEmpregado != null) || (this.idEmpregado != null && !this.idEmpregado.equals(other.idEmpregado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TbEmpregado[ idEmpregado=" + idEmpregado + " ]";
    }

}
