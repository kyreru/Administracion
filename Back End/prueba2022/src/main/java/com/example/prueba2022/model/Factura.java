
package com.example.prueba2022.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "factura")
public class Factura implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "consecutivo")
    private Integer consecutivo;
    
    @Column(name = "periodo_facturado")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date periodo_facturado;
    
    @Column(name = "fecha_generacion")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_generacion;
    
    @Column(name = "total")
    private Integer total;
    
    @ManyToOne
    @JoinColumn(name = "apartamento_id_apartamento")
    private Apartamento apartamento;
    
    @ManyToOne
    @JoinColumn(name = "apartamento_residente_id_residente")
    private Residente residente;
    
    @ManyToOne
    @JoinColumn(name = "apartamento_torre_conjunto_id_conjunto")
    private Torre torre;

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Date getPeriodo_facturado() {
        return periodo_facturado;
    }

    public void setPeriodo_facturado(Date periodo_facturado) {
        this.periodo_facturado = periodo_facturado;
    }

    public Date getFecha_generacion() {
        return fecha_generacion;
    }

    public void setFecha_generacion(Date fecha_generacion) {
        this.fecha_generacion = fecha_generacion;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Apartamento getApartamento() {
        return apartamento;
    }

    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento;
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
