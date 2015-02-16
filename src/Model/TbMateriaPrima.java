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
@Table(name = "tb_materia_prima")
@XmlRootElement
public class TbMateriaPrima implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_materia_prima")
    private Integer idMateriaPrima;
    @Basic(optional = false)
    @Column(name = "nm_produto")
    private String nmProduto;
    @Basic(optional = false)
    @Column(name = "nr_qtd_estoque")
    private int nrQtdEstoque;
    @Basic(optional = false)
    @Column(name = "vl_produto")
    private double vlProduto;
    @Basic(optional = false)
    @Column(name = "ds_obs")
    private String dsObs;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMateriaPrima")
    private Collection<TbCompraProduto> tbCompraProdutoCollection;

    public TbMateriaPrima() {
    }

    public TbMateriaPrima(Integer idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    public TbMateriaPrima(Integer idMateriaPrima, String nmProduto) {
        this.idMateriaPrima = idMateriaPrima;
        this.nmProduto = nmProduto;
    }

    public TbMateriaPrima(Integer idMateriaPrima, String nmProduto, int nrQtdEstoque, float vlProduto, String dsObs) {
        this.idMateriaPrima = idMateriaPrima;
        this.nmProduto = nmProduto;
        this.nrQtdEstoque = nrQtdEstoque;
        this.vlProduto = vlProduto;
        this.dsObs = dsObs;
    }
    public TbMateriaPrima( String nmProduto, int nrQtdEstoque, double vlProduto, String dsObs) {
       
        this.nmProduto = nmProduto;
        this.nrQtdEstoque = nrQtdEstoque;
        this.vlProduto = vlProduto;
        this.dsObs = dsObs;
    }

    public Integer getIdMateriaPrima() {
        return idMateriaPrima;
    }

    public void setIdMateriaPrima(Integer idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    public String getNmProduto() {
        return nmProduto;
    }

    public void setNmProduto(String nmProduto) {
        this.nmProduto = nmProduto;
    }

    public int getNrQtdEstoque() {
        return nrQtdEstoque;
    }

    public void setNrQtdEstoque(int nrQtdEstoque) {
        this.nrQtdEstoque = nrQtdEstoque;
    }

    public double getVlProduto() {
        return vlProduto;
    }

    public void setVlProduto(double vlProduto) {
        this.vlProduto = vlProduto;
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
        hash += (idMateriaPrima != null ? idMateriaPrima.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbMateriaPrima)) {
            return false;
        }
        TbMateriaPrima other = (TbMateriaPrima) object;
        if ((this.idMateriaPrima == null && other.idMateriaPrima != null) || (this.idMateriaPrima != null && !this.idMateriaPrima.equals(other.idMateriaPrima))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TbMateriaPrima[ idMateriaPrima=" + idMateriaPrima + " ]";
    }

}
