/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.xtec.ioc.repository.impl;

import cat.xtec.ioc.domain.Article;
import cat.xtec.ioc.domain.repository.impl.ArticleDAO;

import cat.xtec.ioc.domain.repository.impl.DBConnection;

import java.sql.SQLException;
import java.util.List;
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
    
    @Before
    public void setUp(){
    dBConnection = new DBConnection(connectionFile);
    }

    @Test
    public void getAllArticles() throws SQLException{
        ArticleDAO articleDAO = new ArticleDAO(dBConnection);
        List<Article> articles = articleDAO.getAllArticles();
        Assert.assertEquals("Articles no hauria destar buit", 6, articles.size());
    }
    
}
