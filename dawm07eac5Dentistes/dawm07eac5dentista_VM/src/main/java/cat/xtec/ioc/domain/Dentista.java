/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.xtec.ioc.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;



/**
 *
 * @author victor
 */
public class Dentista {
    private String codi; //(codi del dentista)
    private Double preuPeces; //(preu acumulat de les pròtesis comprades per a les operacions fetes per aquell dentistsa)
    private Double pacientAcumulat; //(temps d’operacions acumulat pel dentista)
    private Boolean pacientActual; //(és true si el dentista està visitant un pacient en aquest moment)
    private LocalDateTime datePacient;
    
    public Dentista(){
        
    }

    public Dentista(String codi, Double preuPeces, Double pacientAcumulat, Boolean pacientActual, LocalDateTime datePacient) {
        this.codi = codi;
        this.preuPeces = preuPeces;
        this.pacientAcumulat = pacientAcumulat;
        this.pacientActual = pacientActual;
        this.datePacient = datePacient;
    }
    
    public Dentista(String codi, String preuPeces, String pacientAcumulat, String pacientActual, String datePacient) {
        this.codi = codi;
        this.preuPeces = Double.valueOf(preuPeces);
        this.pacientAcumulat = Double.valueOf(pacientAcumulat);
        this.pacientActual = Boolean.valueOf(pacientActual);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.datePacient = LocalDateTime.parse(codi, formatter);
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public Double getPreuPeces() {
        return preuPeces;
    }

    public void setPreuPeces(Double preuPeces) {
        this.preuPeces = preuPeces;
    }

    public Double getPacientAcumulat() {
        return pacientAcumulat;
    }

    public void setPacientAcumulat(Double pacientAcumulat) {
        this.pacientAcumulat = pacientAcumulat;
    }

    public Boolean getPacientActual() {
        return pacientActual;
    }

    public void setPacientActual(Boolean pacientActual) {
        this.pacientActual = pacientActual;
    }
    
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @XmlSchemaType(name = "dateTime")
    public LocalDateTime getDatePacient() {
        return datePacient;
    }

    public void setDatePacient(LocalDateTime datePacient) {
        this.datePacient = datePacient;
    }
    
    
    
    public Boolean donaAltaOperacio(){
        return true;
    }
    
    public void actualitzaPacientActual(){
        this.pacientActual = true;
        this.datePacient = LocalDateTime.now();
    }
    
    public Double acumulatPreuPeces(String codi){
        return 0.0;
    }
}
