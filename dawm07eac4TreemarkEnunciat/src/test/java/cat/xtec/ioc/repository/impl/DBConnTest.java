/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.xtec.ioc.repository.impl;

import cat.xtec.ioc.domain.repository.impl.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author victor
 */
public class DBConnTest {

    private DBConnection dBConnection;
    private Connection connection;
    private String connectionFile = "db_test.properties";

    @Before
    public void setUp(){
        dBConnection = new DBConnection(connectionFile);
    }

    @After
    public void cleanUp() throws SQLException {
        if(connection != null){
            connection.close();
        }   
    }

    @Test
    public void connectarAmbLaBaseDeDades() throws IOException, SQLException {
        connection = dBConnection.getConnection();
        Assert.assertEquals("H2 JDBC Driver", connection.getMetaData().getDriverName());
        Assert.assertEquals("ARTICLES_DB", connection.getCatalog());
    }
    
    @Test
    public void connexioErroniaBaseDeDades() throws IOException, SQLException {
        dBConnection = new DBConnection("db_wrong_driver.properties");
        connection = dBConnection.getConnection();
        Assert.assertNull(connection);
    }


   
}

