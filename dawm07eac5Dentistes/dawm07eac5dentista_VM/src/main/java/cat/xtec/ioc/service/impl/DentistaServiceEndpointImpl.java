/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.xtec.ioc.service.impl;

import cat.xtec.ioc.domain.Dentista;
import cat.xtec.ioc.repository.DentistaRepository;
import cat.xtec.ioc.repository.impl.InMemoryDentistaRepository;
import cat.xtec.ioc.service.DentistaServiceEndpoint;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author victor
 */
@WebService(serviceName= "DentistaService",
        endpointInterface = "cat.xtec.ioc.DentistaServiceEndpoint")
public class DentistaServiceEndpointImpl implements DentistaServiceEndpoint{

    private final DentistaRepository dentistaRepository = new InMemoryDentistaRepository();
    
    @Override
    public List<Dentista> initDentistes(String codisDentista) {
        return dentistaRepository.initDentistes(codisDentista);
    }

    @Override
    public List<Dentista> getAllDentistes() {
        return dentistaRepository.getAllDentistes();
    }

    @Override
    public Dentista getDentistaByCodi(String codi) {
        return dentistaRepository.getDentistaByCodi(codi);
    }

    @Override
    public Dentista updatePacientDentist(String codi, Boolean pacient, Double preuPeces) {
        return dentistaRepository.updatePacientDentist(codi, pacient, preuPeces);
    }
    
}
