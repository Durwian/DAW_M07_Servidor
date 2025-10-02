package cat.xtec.ioc.service.impl;

import cat.xtec.ioc.domain.Article;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cat.xtec.ioc.domain.repository.ArticleRepository;
import cat.xtec.ioc.service.ArticleService;

/**
 *
 * @author Germán Flores
 */

@Service
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    private ArticleRepository articleRepository;
    
    @Override
    public Article getArticleByCodi(String codi) {
        return articleRepository.getArticleByCodi(codi);    
    }
   
    @Override
    public void addArticle(Article article) {
        articleRepository.addArticle(article);
    }
    
}
