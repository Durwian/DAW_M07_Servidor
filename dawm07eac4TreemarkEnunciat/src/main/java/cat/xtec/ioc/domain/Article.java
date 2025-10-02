
package cat.xtec.ioc.domain;


/**
 *
 * @author Germán Flores
 */
public class Article {


    private String codi;
    private Integer numeroUnitats;
    private Integer numeroVendes;
    private String titol;
    private String descripcio;

    public Article(String codi, Integer numeroUnitats, Integer numeroVendes, String titol, String descripcio) {
        this.codi = codi;
        this.numeroUnitats = numeroUnitats;
        this.numeroVendes = numeroVendes;
        this.titol = titol;
        this.descripcio = descripcio;
    }

    public Article() {
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public Integer getNumeroUnitats() {
        return numeroUnitats;
    }

    public void setNumeroUnitats(Integer numeroUnitats) {
        this.numeroUnitats = numeroUnitats;
    }
    
    public Integer getNumeroVendes() {
        return numeroVendes;
    }

    public void setNumeroVendes(Integer numeroVendes) {
        this.numeroVendes = numeroVendes;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

   
    
}
