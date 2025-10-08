/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.xtec.ioc.domain.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.io.InputStream;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;


import java.util.Properties;
import javax.ejb.Stateful;
import org.springframework.stereotype.Repository;



/**
 *
 * @author victor
 */


@Repository
public class DBConnection {
    private String connectionFile;

    public DBConnection() {
        System.out.println(">>> DBConnection creat per Spring!");
    }

    public DBConnection(String connectionFile) {
        this.connectionFile = connectionFile;
    }

    public String getConnectionFile() {
        return connectionFile;
    }

    public void setConnectionFile(String connectionFile) {
        this.connectionFile = connectionFile;
    }
    
    public Connection getConnection() throws SQLException, IOException {
        Properties props = new Properties();
        InputStream resourceAsStream = null;
        Connection con = null;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            URL urlResource = classLoader.getResource(connectionFile);
            if (urlResource != null) {
                resourceAsStream = urlResource.openStream();
                props.load(resourceAsStream);
                Class.forName(props.getProperty("DB_DRIVER_CLASS"));
                con = DriverManager.getConnection(props.getProperty("DB_URL"),
                        props.getProperty("DB_USERNAME"),
                        props.getProperty("DB_PASSWORD"));
            }else{
                System.out.println("Intentant connectar a H2 amb fitxer: " + connectionFile);
                System.out.println("URL = " + props.getProperty("DB_URL"));
                System.out.println("Usuari = " + props.getProperty("DB_USERNAME"));
            }
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
        }
        return con;
    }
}
