/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.xtec.ioc.service;

import cat.xtec.ioc.domain.Dentista;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author victor
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface DentistaServiceEndpoint {
    @WebMethod public List<Dentista> initDentistes(String codisDentista);
    @WebMethod public List<Dentista> getAllDentistes();
    @WebMethod public Dentista getDentistaByCodi(String codi);
    @WebMethod public Dentista updatePacientDentist(String codi, Boolean pacient, Double preuPeces);

}
