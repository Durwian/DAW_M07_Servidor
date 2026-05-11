/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.xtec.ioc.service;

import cat.xtec.ioc.domain.Dentista;
import cat.xtec.ioc.domain.repository.DentistaRepository;
import cat.xtec.ioc.domain.repository.impl.InMemoryDentistaRepository;
import java.util.List;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author victor
 */
@Path("/dentistes")
@Singleton
public class DentistaJSONService {
    
    private DentistaRepository dentistaRepository = new InMemoryDentistaRepository();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dentista> getAllDentistes() {
        return this.dentistaRepository.getAllDentistes();
    }
    
    @GET
    @Path("{codi}")
    @Produces(MediaType.APPLICATION_JSON)
    public Dentista getDentistaByCodi(@PathParam("codi")String codi){
        return this.dentistaRepository.getDentistaByCodi(codi);
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Dentista updatePacientDentista(
            @QueryParam("codi") String codi, 
            @QueryParam("pacient") Boolean pacient, 
            @QueryParam("preuPeces") Double preuPeces){
        return this.dentistaRepository.updatePacientDentista(codi, pacient, preuPeces);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDentistaJSON(Dentista dentista){
        this.dentistaRepository.addDentistaJSON(dentista);
    }
}
