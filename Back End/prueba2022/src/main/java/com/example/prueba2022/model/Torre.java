
package com.example.prueba2022.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "torre")
public class Torre implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_torre")    
    private Integer id_torre;
    
    @ManyToOne
    @JoinColumn(name = "conjunto_id_conjunto")
    //@JoinColumn(foreignKey = @ForeignKey(name = "fk_conjunto_id"), name="conjunto_id_conjunto", referencedColumnName = "id_conjunto", columnDefinition = "int")
    private Conjunto conjunto;

    public Integer getId_torre() {
        return id_torre;
    }

    public void setId_torre(Integer id_torre) {
        this.id_torre = id_torre;
    }

    public Conjunto getConjunto() {
        return conjunto;
    }

    public void setConjunto(Conjunto conjunto) {
        this.conjunto = conjunto;
    }

   
    
}
