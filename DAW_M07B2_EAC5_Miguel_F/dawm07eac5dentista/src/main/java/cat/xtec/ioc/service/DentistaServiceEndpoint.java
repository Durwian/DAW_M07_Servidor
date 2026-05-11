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
    
    @WebMethod List<Dentista> initDentistes(String codisDentista);
    @WebMethod List<Dentista> getAllDentistes();
    @WebMethod Dentista getDentistaByCodi(String codi);
    @WebMethod Dentista updatePacientDentista(String codi, Boolean pacient, Double preuPeces);
}
