/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.xtec.ioc.repository;

import cat.xtec.ioc.domain.Dentista;
import java.util.List;

/**
 *
 * @author victor
 */
public interface DentistaRepository {
    public List<Dentista> initDentistes(String codisDentista);
    public void addDentistaJSON(Dentista dentista);
    public List<Dentista> getAllDentistes();
    public Dentista getDentistaByCodi(String codi);
    public Dentista updatePacientDentist(String codi, Boolean pacient, Double preuPeces);
}
