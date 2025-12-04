package cat.xtec.ioc.domain.repository.impl;

import cat.xtec.ioc.domain.Renda;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import java.io.*;
import cat.xtec.ioc.domain.repository.RendaRepository;

@Repository
public class InMemoryRendaRepository implements RendaRepository {

    private List<Renda> rendes = new ArrayList<Renda>();

    public InMemoryRendaRepository() {
        //TODO
    }
    
    @Override
    public List<Renda> getAll() {
        return rendes;
    }
    
}
