package cat.xtec.ioc.domain.repository;

import cat.xtec.ioc.domain.Article;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 *
 * @author Germán Flores
 */


public interface ArticleRepository {
    
    void addArticle(Article article);
            
    Article getArticleByCodi(String codi);
    
    List<Article> getAllArticles();
    
}
