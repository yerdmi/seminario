/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yerdmi
 */
@Entity
@Table(name = "ENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ente.findAll", query = "SELECT e FROM Ente e"),
    @NamedQuery(name = "Ente.findByIdEnte", query = "SELECT e FROM Ente e WHERE e.idEnte = :idEnte"),
    @NamedQuery(name = "Ente.findByNombre", query = "SELECT e FROM Ente e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Ente.findByDireccion", query = "SELECT e FROM Ente e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Ente.findByTipo", query = "SELECT e FROM Ente e WHERE e.tipo = :tipo")})
public class Ente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ENTE")
    private Integer idEnte;
    @Size(max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 45)
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "TIPO")
    private Character tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enteEjecutor")
    private Collection<Proyecto> proyectoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enteRector")
    private Collection<Proyecto> proyectoCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enteSupervisor")
    private Collection<Proyecto> proyectoCollection2;

    public Ente() {
    }

    public Ente(Integer idEnte) {
        this.idEnte = idEnte;
    }

    public Integer getIdEnte() {
        return idEnte;
    }

    public void setIdEnte(Integer idEnte) {
        this.idEnte = idEnte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<Proyecto> getProyectoCollection() {
        return proyectoCollection;
    }

    public void setProyectoCollection(Collection<Proyecto> proyectoCollection) {
        this.proyectoCollection = proyectoCollection;
    }

    @XmlTransient
    public Collection<Proyecto> getProyectoCollection1() {
        return proyectoCollection1;
    }

    public void setProyectoCollection1(Collection<Proyecto> proyectoCollection1) {
        this.proyectoCollection1 = proyectoCollection1;
    }

    @XmlTransient
    public Collection<Proyecto> getProyectoCollection2() {
        return proyectoCollection2;
    }

    public void setProyectoCollection2(Collection<Proyecto> proyectoCollection2) {
        this.proyectoCollection2 = proyectoCollection2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEnte != null ? idEnte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ente)) {
            return false;
        }
        Ente other = (Ente) object;
        if ((this.idEnte == null && other.idEnte != null) || (this.idEnte != null && !this.idEnte.equals(other.idEnte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Ente[ idEnte=" + idEnte + " ]";
    }
    
}
