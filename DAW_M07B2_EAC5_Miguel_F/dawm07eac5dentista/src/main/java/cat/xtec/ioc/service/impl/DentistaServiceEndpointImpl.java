/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.xtec.ioc.service.impl;

import cat.xtec.ioc.service.DentistaServiceEndpoint;
import cat.xtec.ioc.domain.Dentista;
import cat.xtec.ioc.domain.repository.DentistaRepository;
import cat.xtec.ioc.domain.repository.impl.InMemoryDentistaRepository;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

/**
 *
 * @author victor
 */
@WebService(serviceName = "DentistaService",
endpointInterface = "cat.xtec.ioc.service.DentistaServiceEndpoint")
public class DentistaServiceEndpointImpl implements DentistaServiceEndpoint {

    private final DentistaRepository dentistaRepository = new InMemoryDentistaRepository();
    
    @Override
    public List<Dentista> initDentistes(String codisDentista) {
        return this.dentistaRepository.initDentistes(codisDentista);
    }

    @Override
    public List<Dentista> getAllDentistes() {
        return new ArrayList<Dentista>(this.dentistaRepository.getAllDentistes());
    }

    @Override
    public Dentista getDentistaByCodi(String codi) {
        return this.dentistaRepository.getDentistaByCodi(codi);
    }

    @Override
    public Dentista updatePacientDentista(String codi, Boolean pacient, Double preuPeces) {
        return this.dentistaRepository.updatePacientDentista(codi, pacient, preuPeces);
    }
    
}
