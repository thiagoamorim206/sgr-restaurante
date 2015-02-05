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
@Table(name = "tb_pessoa")
@XmlRootElement
public class TbPessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pessoa")
    private Integer idPessoa;
    @Basic(optional = false)
    @Column(name = "nm_nome")
    private String nmNome;
    @Basic(optional = false)
    @Column(name = "nr_telefone")
    private String nrTelefone;
    @Basic(optional = false)
    @Column(name = "nr_celular")
    private String nrCelular;
    @Basic(optional = false)
    @Column(name = "nm_sexo")
    private Character nmSexo;
    @Basic(optional = false)
    @Column(name = "nm_email")
    private String nmEmail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoa")
    private Collection<TbEmpregado> tbEmpregadoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoa")
    private Collection<TbCliente> tbClienteCollection;

    public TbPessoa() {
    }

    public TbPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public TbPessoa(Integer idPessoa, String nmNome, String nrTelefone, String nrCelular, Character nmSexo, String nmEmail) {
        this.idPessoa = idPessoa;
        this.nmNome = nmNome;
        this.nrTelefone = nrTelefone;
        this.nrCelular = nrCelular;
        this.nmSexo = nmSexo;
        this.nmEmail = nmEmail;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNmNome() {
        return nmNome;
    }

    public void setNmNome(String nmNome) {
        this.nmNome = nmNome;
    }

    public String getNrTelefone() {
        return nrTelefone;
    }

    public void setNrTelefone(String nrTelefone) {
        this.nrTelefone = nrTelefone;
    }

    public String getNrCelular() {
        return nrCelular;
    }

    public void setNrCelular(String nrCelular) {
        this.nrCelular = nrCelular;
    }

    public Character getNmSexo() {
        return nmSexo;
    }

    public void setNmSexo(Character nmSexo) {
        this.nmSexo = nmSexo;
    }

    public String getNmEmail() {
        return nmEmail;
    }

    public void setNmEmail(String nmEmail) {
        this.nmEmail = nmEmail;
    }

    @XmlTransient
    public Collection<TbEmpregado> getTbEmpregadoCollection() {
        return tbEmpregadoCollection;
    }

    public void setTbEmpregadoCollection(Collection<TbEmpregado> tbEmpregadoCollection) {
        this.tbEmpregadoCollection = tbEmpregadoCollection;
    }

    @XmlTransient
    public Collection<TbCliente> getTbClienteCollection() {
        return tbClienteCollection;
    }

    public void setTbClienteCollection(Collection<TbCliente> tbClienteCollection) {
        this.tbClienteCollection = tbClienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPessoa != null ? idPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPessoa)) {
            return false;
        }
        TbPessoa other = (TbPessoa) object;
        if ((this.idPessoa == null && other.idPessoa != null) || (this.idPessoa != null && !this.idPessoa.equals(other.idPessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TbPessoa[ idPessoa=" + idPessoa + " ]";
    }
    
}
