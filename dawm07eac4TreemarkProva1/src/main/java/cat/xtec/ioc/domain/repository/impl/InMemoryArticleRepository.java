package cat.xtec.ioc.domain.repository.impl;

import cat.xtec.ioc.domain.Article;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import cat.xtec.ioc.domain.repository.ArticleRepository;
import java.util.List;

/**
 *
 * @author Germán Flores
 */

public class InMemoryArticleRepository implements ArticleRepository {

    private List<Article> llista = new ArrayList<Article>();

    public InMemoryArticleRepository() {

        Integer codi = 0;

        for (Integer i = 0; i < 3; i++) {
            Article article = new Article(codi.toString(), 10, 0, "articleTitol" + codi, "articleDescripcio" + codi);
            llista.add(article);
            codi++;
        }
        
    }

    @Override
    public Article getArticleByCodi(String codi) {
        Article articleByCodi = null;
        for (Article r : llista) {
            if (r != null && r.getCodi() != null
                    && r.getCodi().equals(codi)) {
                articleByCodi = r;
                break;
            }
        }
        if (articleByCodi == null) {
            throw new IllegalArgumentException(
                    "No s'ha trobat l'article amb el codi: " + codi);
        }
        return articleByCodi;
    }

    @Override
    public void addArticle(Article recurs) {
        recurs.setNumeroVendes(0);
        this.llista.add(recurs);
    }

    @Override
    public List<Article> getAllArticles() {
        return llista; 
    }

}
