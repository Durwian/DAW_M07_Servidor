 package cat.xtec.ioc.controller;

import cat.xtec.ioc.domain.Renda;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cat.xtec.ioc.domain.repository.RendaRepository;
import java.util.ArrayList;

@RestController
public class RendesController {

    @Autowired
    private RendaRepository rendaRepository;

    public RendesController() {
    }

    public RendesController(RendaRepository rendaRepository) {
        this.rendaRepository = rendaRepository;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/rendes")
    public List<Renda> getAllRendes() {
        return rendaRepository.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/rendes/{any}")
    public List<Renda> getRendesByAny(@PathVariable("any") int any) {
        List<Renda> filtrades = new ArrayList<>();
        for (Renda r : rendaRepository.getAll()) {
            if (r.getAny() == any) {
                filtrades.add(r);
            }
        }
        return filtrades;
    }
}
