/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.xtec.ioc.service;

import cat.xtec.ioc.domain.Dentista;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.junit.Before;
import org.junit.Test;
/**
 *
 * @author victor
 */



public class DentistaJSONServiceTest {

    private static final Client client = ClientBuilder.newClient();
    
    private Dentista dentista1;
    private Dentista dentista2;

    private final String BASE_URL =
        "http://localhost:8080/dawm07eac5dentista/dentistajson/dentistes";

    @Before
    public void testBefore() {
        dentista1 = new Dentista();
        dentista1.setCodi("D001");
        dentista1.setPacientAcumulat(10.0);
        dentista1.setPreuPeces(20.0);
        dentista1.setPacientActual(true);
        dentista2 = new Dentista();
        dentista2.setCodi("D002");
        dentista2.setPacientAcumulat(15.0);
        dentista2.setPreuPeces(30.0);
        dentista2.setPacientActual(false);

        WebTarget target = client.target(BASE_URL);

        target.request(MediaType.APPLICATION_JSON)
              .post(Entity.json(dentista1));

        target.request(MediaType.APPLICATION_JSON)
              .post(Entity.json(dentista2));
    }

    @Test
    public void getAllDentistes() {
        WebTarget target = client.target(BASE_URL);
        List<Dentista> list = target.request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Dentista>>() {});

        boolean foundD1 = false;
        boolean foundD2 = false;

        for (Dentista d : list) {
            if (d.getCodi().equals("D001")) foundD1 = true;
            if (d.getCodi().equals("D002")) foundD2 = true;
        }

        assertTrue(foundD1);
        assertTrue(foundD2);
    }

    @Test
    public void getDentistaByCodi() {

        WebTarget target = client.target(BASE_URL + "/D001");

        Dentista d = target.request(MediaType.APPLICATION_JSON)
                .get(Dentista.class);

        assertEquals("D001", d.getCodi());
    }

    @Test
    public void updatePacientDentista() {

        WebTarget targetGet = client.target(BASE_URL + "/D001");
        Dentista d = targetGet.request(MediaType.APPLICATION_JSON)
                .get(Dentista.class);
        d.setPacientActual(false);
        WebTarget targetPut = client.target(BASE_URL);
        targetPut.request(MediaType.APPLICATION_JSON)
                .put(Entity.json(d));
        Dentista updated = targetGet.request(MediaType.APPLICATION_JSON)
                .get(Dentista.class);

        assertEquals(false, updated.getPacientActual());
    }
}