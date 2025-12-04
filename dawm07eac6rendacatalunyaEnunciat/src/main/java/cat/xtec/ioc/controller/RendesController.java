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

@RestController
public class RendesController {

    @Autowired
    private RendaRepository rendaRepository;

    public RendesController() {
    }

    public RendesController(RendaRepository rendaRepository) {
        this.rendaRepository = rendaRepository;
    }
}
