/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "libros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libros.findAll", query = "SELECT l FROM Libros l"),
    @NamedQuery(name = "Libros.findByIdlibro", query = "SELECT l FROM Libros l WHERE l.idlibro = :idlibro"),
    @NamedQuery(name = "Libros.findByNombre", query = "SELECT l FROM Libros l WHERE l.nombre = :nombre"),
    @NamedQuery(name = "Libros.findByEditorial", query = "SELECT l FROM Libros l WHERE l.editorial = :editorial"),
    @NamedQuery(name = "Libros.findByAutor", query = "SELECT l FROM Libros l WHERE l.autor = :autor")})

public class Libros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlibro")
    private Integer idlibro;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "editorial")
    private String editorial;
    @Column(name = "autor")
    private String autor;
   
    @OneToMany(mappedBy = "idlibro")
    private Collection<Prestamo> prestamoCollection;

    public Libros() {
    }

    public Libros(Integer idlibro) {
        this.idlibro = idlibro;
    }

    public Integer getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(Integer idlibro) {
        this.idlibro = idlibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    
     

    @XmlTransient
    public Collection<Prestamo> getPrestamoCollection() {
        return prestamoCollection;
    }

    public void setPrestamoCollection(Collection<Prestamo> prestamoCollection) {
        this.prestamoCollection = prestamoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlibro != null ? idlibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libros)) {
            return false;
        }
        Libros other = (Libros) object;
        if ((this.idlibro == null && other.idlibro != null) || (this.idlibro != null && !this.idlibro.equals(other.idlibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
      //  return "com.entidades.Libros[ idlibro=" + idlibro + " ]";
        return String.valueOf(idlibro);
    }
    
}
