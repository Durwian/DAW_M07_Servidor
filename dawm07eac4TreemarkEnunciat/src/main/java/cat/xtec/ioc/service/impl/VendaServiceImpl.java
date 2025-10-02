package cat.xtec.ioc.service.impl;

import cat.xtec.ioc.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cat.xtec.ioc.domain.repository.ArticleRepository;
import cat.xtec.ioc.service.VendaService;

/**
 *
 * @author Germán Flores
 */
@Service
public class VendaServiceImpl implements VendaService {

    @Autowired
    private ArticleRepository articleRepository;
    
    @Override
    public void processVenda(String codiArticle) {
        Article r = articleRepository.getArticleByCodi(codiArticle);
                
        int num = 1;
        if ((r.getNumeroVendes()+ num) > r.getNumeroUnitats()) {
            throw new IllegalArgumentException("No hi ha prou unitats. S'han reservat el total de: " + r.getNumeroVendes());
        }
        r.setNumeroVendes(r.getNumeroVendes() + num);
    }
    
}
