/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.xtec.ioc.domain.repository.impl;

import cat.xtec.ioc.domain.Dentista;
import cat.xtec.ioc.domain.LocalDateTimeAdapter;
import cat.xtec.ioc.domain.repository.DentistaRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author victor
 */
public class InMemoryDentistaRepository implements DentistaRepository{

    private List<Dentista> dentistes = new ArrayList<Dentista>();
    
    
    @Override
    public List<Dentista> initDentistes(String codisDentista) {
        String[] codis = codisDentista.split("##");
        
        for(String codiDentista : codis){
            addDentistaJSON(new Dentista(codiDentista, 0.0d, 0.0d, false, new Date().getTime()));
        }
        
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
            if(codi.equals(dentistaByCodi.getCodi())){
                return dentistaByCodi;
            }
        }
        return null;
    }

    @Override
    public Dentista updatePacientDentista(String codi, Boolean pacient, Double preuPeces) {
        Dentista updatedDentista = getDentistaByCodi(codi);
        if( updatedDentista!= null){
            
            if(!pacient){
                // (dataActual-datePacient) + pacientAcumulat
                updatedDentista.setPacientAcumulat(updatedDentista.getDatePacient() + updatedDentista.getPacientAcumulat());
            }else{
                if(preuPeces != null){
                    updatedDentista.setPreuPeces(updatedDentista.getPreuPeces() + preuPeces);
                }
                
            }
        }
    }
    
}
