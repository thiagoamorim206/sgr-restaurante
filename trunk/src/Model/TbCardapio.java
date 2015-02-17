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
    private double vlItem;
    @JoinColumn(name = "id_tipo_cardapio", referencedColumnName = "id_tipo_cardapio")
    @ManyToOne(optional = false)
    private int idTipoCardapio;
    @JoinColumn(name = "id_tipo_restaurante", referencedColumnName = "id_tipo_restaurante")
    @ManyToOne(optional = false)
    private int idTipoRestaurante;

    public TbCardapio() {
    }

    public TbCardapio(Integer idCardapio) {
        this.idCardapio = idCardapio;
    }

    public TbCardapio(Integer idCardapio, String nmItemCardapio, double vlItem) {
        this.idCardapio = idCardapio;
        this.nmItemCardapio = nmItemCardapio;
        this.vlItem = vlItem;
    }

    public TbCardapio(String nmItemCardapio, double vlItem, int idTipoCardapio, int idTipoRestaurante) {
        this.nmItemCardapio = nmItemCardapio;
        this.vlItem = vlItem;
        this.idTipoCardapio = idTipoCardapio;
        this.idTipoRestaurante = idTipoRestaurante;
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

    public double getVlItem() {
        return vlItem;
    }

    public void setVlItem(double vlItem) {
        this.vlItem = vlItem;
    }

    public int getIdTipoCardapio() {
        return idTipoCardapio;
    }

    public void setIdTipoCardapio(int idTipoCardapio) {
        this.idTipoCardapio = idTipoCardapio;
    }

    public int getIdTipoRestaurante() {
        return idTipoRestaurante;
    }

    public void setIdTipoRestaurante(int idTipoRestaurante) {
        this.idTipoRestaurante = idTipoRestaurante;
    }

//    public TbTipoCardapio getIdTipoCardapio() {
//        return idTipoCardapio;
//    }
//
//    public void setIdTipoCardapio(TbTipoCardapio idTipoCardapio) {
//        this.idTipoCardapio = idTipoCardapio;
//    }
//
//    public TbTipoRestaurante getIdTipoRestaurante() {
//        return idTipoRestaurante;
//    }
//
//    public void setIdTipoRestaurante(TbTipoRestaurante idTipoRestaurante) {
//        this.idTipoRestaurante = idTipoRestaurante;
//    }
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
