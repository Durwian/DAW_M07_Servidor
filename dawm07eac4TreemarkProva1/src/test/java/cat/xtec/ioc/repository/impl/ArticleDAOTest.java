/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.xtec.ioc.repository.impl;

import cat.xtec.ioc.domain.Article;
import cat.xtec.ioc.domain.repository.impl.ArticleDAO;

import cat.xtec.ioc.domain.repository.impl.DBConnection;
import java.io.IOException;

import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author victor
 */
public class ArticleDAOTest {
    private DBConnection dBConnection;
    private String connectionFile = "db_test.properties";
    ArticleDAO articleDAO;
    
    @Before
    public void setUp(){
        dBConnection = new DBConnection(connectionFile);
        articleDAO = new ArticleDAO(dBConnection);
    }
    
    @After
    public void tearDown() throws IOException, SQLException {
        articleDAO.getConnection().close();
    }

    @Test
    public void getAllArticles() throws SQLException{
        List<Article> articles = articleDAO.getAllArticles();
        Assert.assertEquals("Articles no hauria destar buit", 6, articles.size());
    }
    
    @Test
    public void getArticleByCodi() throws Exception{
         String codiExistent = "1";
         String codiDesconegut = "AAA";
         Article article = articleDAO.getArticleByCodi(codiExistent);
         Assert.assertNotNull(article);
         article = articleDAO.getArticleByCodi(codiDesconegut);
         Assert.assertNull(article);
    }
    
    @Test
    public void addArticle() throws Exception{
        String codi = "6";
        Integer numeroUnitats = 4;
        Integer numeroVendes = 1;
        String titol = "hola";
        String descripcio = "Boles arbre de Nadal";
        Article article = new Article(codi,numeroUnitats,numeroVendes, titol, descripcio);
        articleDAO.addArticle(article);
        Article recuperat = articleDAO.getArticleByCodi(codi);
        Assert.assertNotNull("L'article hauria d'haver-se afegit correctament", recuperat);
        Assert.assertEquals("El títol hauria de coincidir", titol, recuperat.getTitol());
        Assert.assertEquals("La descripció hauria de coincidir", descripcio, recuperat.getDescripcio());
    }
    
}
