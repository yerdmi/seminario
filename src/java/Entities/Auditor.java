/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yerdmi
 */
@Entity
@Table(name = "AUDITOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auditor.findAll", query = "SELECT a FROM Auditor a"),
    @NamedQuery(name = "Auditor.findByIdAuditor", query = "SELECT a FROM Auditor a WHERE a.idAuditor = :idAuditor"),
    @NamedQuery(name = "Auditor.findByUsername", query = "SELECT a FROM Auditor a WHERE a.username = :username"),
    @NamedQuery(name = "Auditor.findByPassword", query = "SELECT a FROM Auditor a WHERE a.password = :password"),
    @NamedQuery(name = "Auditor.findByPrimerNombre", query = "SELECT a FROM Auditor a WHERE a.primerNombre = :primerNombre"),
    @NamedQuery(name = "Auditor.findBySegundoNombre", query = "SELECT a FROM Auditor a WHERE a.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "Auditor.findByTercerNombre", query = "SELECT a FROM Auditor a WHERE a.tercerNombre = :tercerNombre"),
    @NamedQuery(name = "Auditor.findByPrimerApellido", query = "SELECT a FROM Auditor a WHERE a.primerApellido = :primerApellido"),
    @NamedQuery(name = "Auditor.findBySegundoApellido", query = "SELECT a FROM Auditor a WHERE a.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Auditor.findByCorrecoElectronico", query = "SELECT a FROM Auditor a WHERE a.correcoElectronico = :correcoElectronico"),
    @NamedQuery(name = "Auditor.findByTelefono", query = "SELECT a FROM Auditor a WHERE a.telefono = :telefono")})
public class Auditor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_AUDITOR")
    private Integer idAuditor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PRIMER_NOMBRE")
    private String primerNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;
    @Size(max = 45)
    @Column(name = "TERCER_NOMBRE")
    private String tercerNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;
    @Size(max = 45)
    @Column(name = "CORRECO_ELECTRONICO")
    private String correcoElectronico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "TELEFONO")
    private String telefono;
    @JoinTable(name = "AUDITOR_PROYECTO", joinColumns = {
        @JoinColumn(name = "AUDITOR", referencedColumnName = "ID_AUDITOR")}, inverseJoinColumns = {
        @JoinColumn(name = "PROYECTO", referencedColumnName = "NOG")})
    @ManyToMany
    private Collection<Proyecto> proyectoCollection;

    public Auditor() {
    }

    public Auditor(Integer idAuditor) {
        this.idAuditor = idAuditor;
    }

    public Auditor(Integer idAuditor, String username, String password, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String telefono) {
        this.idAuditor = idAuditor;
        this.username = username;
        this.password = password;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
    }

    public Integer getIdAuditor() {
        return idAuditor;
    }

    public void setIdAuditor(Integer idAuditor) {
        this.idAuditor = idAuditor;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getTercerNombre() {
        return tercerNombre;
    }

    public void setTercerNombre(String tercerNombre) {
        this.tercerNombre = tercerNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCorrecoElectronico() {
        return correcoElectronico;
    }

    public void setCorrecoElectronico(String correcoElectronico) {
        this.correcoElectronico = correcoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public Collection<Proyecto> getProyectoCollection() {
        return proyectoCollection;
    }

    public void setProyectoCollection(Collection<Proyecto> proyectoCollection) {
        this.proyectoCollection = proyectoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAuditor != null ? idAuditor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auditor)) {
            return false;
        }
        Auditor other = (Auditor) object;
        if ((this.idAuditor == null && other.idAuditor != null) || (this.idAuditor != null && !this.idAuditor.equals(other.idAuditor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Auditor[ idAuditor=" + idAuditor + " ]";
    }
    
}
