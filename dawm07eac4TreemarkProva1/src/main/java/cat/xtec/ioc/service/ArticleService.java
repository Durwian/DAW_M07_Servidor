package cat.xtec.ioc.service;

import cat.xtec.ioc.domain.Article;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Germán Flores
 */
public interface ArticleService {
    
    void addArticle(Article recurs);
    
    Article getArticleByCodi(String codi);
    
}
