/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thiago
 */
@MappedSuperclass
@Table(name = "tb_compra_produto")
@XmlRootElement
public class TbCompraProduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_compra_produto")
    private Integer idCompraProduto;
    @Basic(optional = false)
    @Column(name = "dt_compra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCompra;
    @Basic(optional = false)
    @Column(name = "nr_qtd_compra")
    private int nrQtdCompra;
    @Basic(optional = false)
    @Column(name = "ds_obs")
    private String dsObs;
    @JoinColumn(name = "id_empregado", referencedColumnName = "id_empregado")
    @ManyToOne(optional = false)
    private int idEmpregado;
    @JoinColumn(name = "id_fornecedor", referencedColumnName = "id_fornecedor")
    @ManyToOne(optional = false)
    private int idFornecedor;
    @JoinColumn(name = "id_materia_prima", referencedColumnName = "id_materia_prima")
    @ManyToOne(optional = false)
    private int idMateriaPrima;

    public TbCompraProduto() {
    }

    public TbCompraProduto(Integer idCompraProduto) {
        this.idCompraProduto = idCompraProduto;
    }

    public TbCompraProduto(Integer idCompraProduto, Date dtCompra, int nrQtdCompra, String dsObs) {
        this.idCompraProduto = idCompraProduto;
        this.dtCompra = dtCompra;
        this.nrQtdCompra = nrQtdCompra;
        this.dsObs = dsObs;
    }

    public Integer getIdCompraProduto() {
        return idCompraProduto;
    }

    public void setIdCompraProduto(Integer idCompraProduto) {
        this.idCompraProduto = idCompraProduto;
    }

    public Date getDtCompra() {
        return dtCompra;
    }

    public void setDtCompra(Date dtCompra) {
        this.dtCompra = dtCompra;
    }

    public int getNrQtdCompra() {
        return nrQtdCompra;
    }

    public void setNrQtdCompra(int nrQtdCompra) {
        this.nrQtdCompra = nrQtdCompra;
    }

    public String getDsObs() {
        return dsObs;
    }

    public void setDsObs(String dsObs) {
        this.dsObs = dsObs;
    }

    public int getIdEmpregado() {
        return idEmpregado;
    }

    public void setIdEmpregado(int idEmpregado) {
        this.idEmpregado = idEmpregado;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public int getIdMateriaPrima() {
        return idMateriaPrima;
    }

    public void setIdMateriaPrima(int idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompraProduto != null ? idCompraProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCompraProduto)) {
            return false;
        }
        TbCompraProduto other = (TbCompraProduto) object;
        if ((this.idCompraProduto == null && other.idCompraProduto != null) || (this.idCompraProduto != null && !this.idCompraProduto.equals(other.idCompraProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TbCompraProduto[ idCompraProduto=" + idCompraProduto + " ]";
    }

}
