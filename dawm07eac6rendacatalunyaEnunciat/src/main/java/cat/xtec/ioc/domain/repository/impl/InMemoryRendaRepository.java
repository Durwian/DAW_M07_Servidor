package cat.xtec.ioc.domain.repository.impl;

import cat.xtec.ioc.domain.Renda;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import java.io.*;
import cat.xtec.ioc.domain.repository.RendaRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class InMemoryRendaRepository implements RendaRepository {

    @Autowired
    private List<Renda> rendes = new ArrayList<Renda>();

    public InMemoryRendaRepository() {
        //TODO
        Renda first = new Renda(2023, 14000, 15000, 14500, "Catalunya");
        Renda second = new Renda(2023, 15000, 16000, 15500, "Espanya");
        rendes.add(first);
        rendes.add(second);
    }
    
    @Override
    public List<Renda> getAll() {
        return rendes;
    }
    
    public Renda getRendaByAny(int any){
        for(Renda renda : rendes){
            if(renda.getAny() == any){
                return renda;
            }
        }
        return null;
    }
    
}
