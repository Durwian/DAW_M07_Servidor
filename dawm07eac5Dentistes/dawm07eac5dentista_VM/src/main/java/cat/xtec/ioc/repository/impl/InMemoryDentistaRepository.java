/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.xtec.ioc.repository.impl;

import cat.xtec.ioc.domain.Dentista;
import cat.xtec.ioc.repository.DentistaRepository;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 *
 * @author victor
 */
@Repository
public class InMemoryDentistaRepository implements DentistaRepository{
    
    
    List<Dentista> dentistes = new ArrayList<>();
    
    @Override
    public List<Dentista> initDentistes(String codisDentista){
        for(String codi : codisDentista.split("##")){
            dentistes.add(new Dentista(codi, 0.0, 0.0, false, LocalDateTime.now()));
        }
        return dentistes;
        
    }

    @Override
    public void addDentistaJSON(Dentista dentista) {
        dentistes.add(dentista);
    }

    @Override
    public List<Dentista> getAllDentistes() {
        return dentistes;
    }

    @Override
    public Dentista getDentistaByCodi(String codi) {
        for(Dentista dentistaByCodi : dentistes){
            if(dentistaByCodi.getCodi().equalsIgnoreCase(codi)){
                return dentistaByCodi;
            }
        }
        return null;
    }

    @Override
    public Dentista updatePacientDentist(String codi, Boolean pacient, Double preuPeces) {
        Dentista dentistaUpdate = getDentistaByCodi(codi);
        if(pacient == false){
            Duration durada = Duration.between(dentistaUpdate.getDatePacient(),  LocalDateTime.now());
            dentistaUpdate.setPacientAcumulat(dentistaUpdate.getPacientAcumulat() + durada.getSeconds());
            
            if(preuPeces != null){
                dentistaUpdate.setPreuPeces(dentistaUpdate.getPreuPeces() + preuPeces);
            }
        }
        dentistaUpdate.setPacientActual(pacient);
        dentistaUpdate.setDatePacient(LocalDateTime.now());
       
        return dentistaUpdate;
    }
}
