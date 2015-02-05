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
@Table(name = "tb_cliente")
@XmlRootElement
public class TbCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Integer idCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<TbPagamento> tbPagamentoCollection;
    @JoinColumn(name = "id_mesa", referencedColumnName = "id_mesa")
    @ManyToOne(optional = false)
    private TbMesa idMesa;
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
    @ManyToOne(optional = false)
    private TbPessoa idPessoa;

    public TbCliente() {
    }

    public TbCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    @XmlTransient
    public Collection<TbPagamento> getTbPagamentoCollection() {
        return tbPagamentoCollection;
    }

    public void setTbPagamentoCollection(Collection<TbPagamento> tbPagamentoCollection) {
        this.tbPagamentoCollection = tbPagamentoCollection;
    }

    public TbMesa getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(TbMesa idMesa) {
        this.idMesa = idMesa;
    }

    public TbPessoa getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(TbPessoa idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCliente)) {
            return false;
        }
        TbCliente other = (TbCliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TbCliente[ idCliente=" + idCliente + " ]";
    }
    
}
