/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.xtec.ioc.domain.repository.impl;


import cat.xtec.ioc.domain.Article;
import cat.xtec.ioc.domain.repository.ArticleRepository;
import cat.xtec.ioc.domain.repository.impl.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;


/**
 *
 * @author victor
 */
@Repository
public class ArticleDAO{
    
    private DBConnection dBConnection;
    private Connection connection;
 
    
    public ArticleDAO(DBConnection dBConnection){
        this.dBConnection = dBConnection;
    }
    
    public DBConnection getDBConnection(){
        return dBConnection;
    }
    
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    
    public void addArticle(Article article) throws SQLException, Exception{
        String qry = "INSERT INTO articles(codi, numeroUnitats, numeroVendes, "
                + "titol, descripcio) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement pstmt = getPreparedStatement(qry);
            pstmt.setString(1, article.getCodi());
            pstmt.setInt(2, article.getNumeroUnitats());
            pstmt.setInt(3, article.getNumeroVendes());
            pstmt.setString(4, article.getTitol());
            pstmt.setString(5, article.getDescripcio());
            createOrUpdateArticle(article.getCodi(), pstmt);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
            
    public Article getArticleByCodi(String codi) throws SQLException, Exception{
        String qry =  "Select * from articles where codi = ? ";
        Article article = null;
        try{
            PreparedStatement pstmt = getPreparedStatement(qry);
            pstmt.setString(1, codi);
            article = findUniqueResult(pstmt);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return article;
    }
    
    public List<Article> getAllArticles() throws SQLException{   
        String qry = "Select codi, numeroUnitats, numeroVendes, titol, descripcio from articles";
        List<Article> articles = null;
        try{
            PreparedStatement pstmt = getPreparedStatement(qry);
            articles = executeQuery(pstmt);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return articles;
    }

    private PreparedStatement getPreparedStatement(String qry) throws SQLException{
        if (getConnection() == null) {
            try {
                setConnection(dBConnection.getConnection());
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
        return getConnection().prepareStatement(qry);
    }

    private Article findUniqueResult(PreparedStatement preparedStatement) throws Exception {
        List<Article> articles = executeQuery(preparedStatement);
        if (articles.isEmpty()) {
            return null;
        }
        if (articles.size() > 1) {
            throw new Exception("Compte! Nomes s'esperava un resutltat.");
        }
        return articles.get(0);
    }
    private List<Article> executeQuery(PreparedStatement pstmt){
        List<Article> articles = new ArrayList<>();

        try (
            ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Article article = buildArticleFromResultSet(rs);
                articles.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }
    private Article buildArticleFromResultSet(ResultSet rs) throws SQLException{
        String codi = rs.getString("codi");
        Integer numeroUnitats = rs.getInt("numeroUnitats");
        Integer numeroVendes = rs.getInt("numeroVendes");
        String titol = rs.getString("titol");
        String descripcio = rs.getString("descripcio");
        Article article = new Article(codi, numeroUnitats, numeroVendes, titol, descripcio);
        return article;
    }
    
    private Article createOrUpdateArticle(String codi, PreparedStatement pstmt) throws Exception {
        int result = executeUpdateQuery(pstmt);
        if(result == 0){
            throw new Exception("Error de creacio de l'article");
        }
        return getArticleByCodi(codi);
    }
    
    private int executeUpdateQuery(PreparedStatement preparedStatement) {
        int result = 0;
        if (getConnection() == null) {
            try {
                setConnection(dBConnection.getConnection());
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
        try {
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
