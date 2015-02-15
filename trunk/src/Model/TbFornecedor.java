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
@Table(name = "tb_fornecedor")
@XmlRootElement
public class TbFornecedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fornecedor")
    private Integer idFornecedor;
    @Basic(optional = false)
    @Column(name = "nm_fornecedor")
    private String nmFornecedor;
    @Basic(optional = false)
    @Column(name = "nr_celular")
    private String nrCelular;
    @Basic(optional = false)
    @Column(name = "nr_telefone")
    private String nrTelefone;
    @Basic(optional = false)
    @Column(name = "nm_email")
    private String nmEmail;
    @Basic(optional = false)
    @Column(name = "ds_obs")
    private String dsObs;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFornecedor")
    private Collection<TbCompraProduto> tbCompraProdutoCollection;

    public TbFornecedor() {
    }

    public TbFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public TbFornecedor(Integer idFornecedor, String nmFornecedor) {
        this.idFornecedor = idFornecedor;
        this.nmFornecedor = nmFornecedor;
    }

    public TbFornecedor(Integer idFornecedor, String nmFornecedor, String nrCelular, String nrTelefone, String nmEmail, String dsObs) {
        this.idFornecedor = idFornecedor;
        this.nmFornecedor = nmFornecedor;
        this.nrCelular = nrCelular;
        this.nrTelefone = nrTelefone;
        this.nmEmail = nmEmail;
        this.dsObs = dsObs;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNmFornecedor() {
        return nmFornecedor;
    }

    public void setNmFornecedor(String nmFornecedor) {
        this.nmFornecedor = nmFornecedor;
    }

    public String getNrCelular() {
        return nrCelular;
    }

    public void setNrCelular(String nrCelular) {
        this.nrCelular = nrCelular;
    }

    public String getNrTelefone() {
        return nrTelefone;
    }

    public void setNrTelefone(String nrTelefone) {
        this.nrTelefone = nrTelefone;
    }

    public String getNmEmail() {
        return nmEmail;
    }

    public void setNmEmail(String nmEmail) {
        this.nmEmail = nmEmail;
    }

    public String getDsObs() {
        return dsObs;
    }

    public void setDsObs(String dsObs) {
        this.dsObs = dsObs;
    }

    @XmlTransient
    public Collection<TbCompraProduto> getTbCompraProdutoCollection() {
        return tbCompraProdutoCollection;
    }

    public void setTbCompraProdutoCollection(Collection<TbCompraProduto> tbCompraProdutoCollection) {
        this.tbCompraProdutoCollection = tbCompraProdutoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFornecedor != null ? idFornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFornecedor)) {
            return false;
        }
        TbFornecedor other = (TbFornecedor) object;
        if ((this.idFornecedor == null && other.idFornecedor != null) || (this.idFornecedor != null && !this.idFornecedor.equals(other.idFornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TbFornecedor[ idFornecedor=" + idFornecedor + " ]";
    }

}
