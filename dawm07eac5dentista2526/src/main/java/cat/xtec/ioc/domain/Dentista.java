/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.xtec.ioc.domain;

import java.time.LocalDateTime;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author victor
 */
public class Dentista {
    private String codi;
    private Double pacientAcumulat;
    private Double preuPeces;
    private Boolean pacientActual;
    private LocalDateTime datePacient;

    public Dentista(String codi, Double pacientAcumulat, Double preuPeces, Boolean pacientActual, LocalDateTime datePacient) {
        this.codi = codi;
        this.pacientAcumulat = pacientAcumulat;
        this.preuPeces = preuPeces;
        this.pacientActual = pacientActual;
        this.datePacient = datePacient;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @XmlSchemaType(name = "dateTime")
    public Double getPacientAcumulat() {
        return pacientAcumulat;
    }

    public void setPacientAcumulat(Double pacientAcumulat) {
        this.pacientAcumulat = pacientAcumulat;
    }

    public Double getPreuPeces() {
        return preuPeces;
    }

    public void setPreuPeces(Double preuPeces) {
        this.preuPeces = preuPeces;
    }

    public Boolean getPacientActual() {
        return pacientActual;
    }

    public void setPacientActual(Boolean pacientActual) {
        this.pacientActual = pacientActual;
    }

    public LocalDateTime getDatePacient() {
        return datePacient;
    }

    public void setDatePacient(LocalDateTime datePacient) {
        this.datePacient = datePacient;
    }
    
    
    
}
