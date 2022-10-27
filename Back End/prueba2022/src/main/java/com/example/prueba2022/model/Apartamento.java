package com.example.prueba2022.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "apartamento")
public class Apartamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_apartamento")
    private Integer id_apartamento;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "mensualidad")
    private Integer mensualidad;

    @ManyToOne
    @JoinColumn(name = "residente_id_residente")
    private Residente residente;

    @ManyToOne
    @JoinColumn(name = "torre_conjunto_id_conjunto")
    private Torre torre;

    public Integer getId_apartamento() {
        return id_apartamento;
    }

    public void setId_apartamento(Integer id_apartamento) {
        this.id_apartamento = id_apartamento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getMensualidad() {
        return mensualidad;
    }

    public void setMensualidad(Integer mensualidad) {
        this.mensualidad = mensualidad;
    }

    public Residente getResidente() {
        return residente;
    }

    public void setResidente(Residente residente) {
        this.residente = residente;
    }

    public Torre getTorre() {
        return torre;
    }

    public void setTorre(Torre torre) {
        this.torre = torre;
    }

    

}
