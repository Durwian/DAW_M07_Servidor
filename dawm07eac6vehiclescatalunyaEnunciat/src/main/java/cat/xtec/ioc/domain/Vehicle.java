package cat.xtec.ioc.domain;

import java.util.Objects;

public class Vehicle {

    private String data;
    private int turismes;
    private int total;
    private String origen;
    
    public Vehicle(String data, int turismes, int total, String origen) { //afegir les altres propietats: turismes, total, origen
        this.data = data;
        this.turismes = turismes;
        this.total = total;
        this.origen = origen;

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getTurismes() {
        return turismes;
    }

    public void setTurismes(int turismes) {
        this.turismes = turismes;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getOrgien() {
        return origen;
    }

    public void setOrgien(String orgien) {
        this.origen = orgien;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vehicle)) {
            return false;
        }

        final Vehicle other = (Vehicle) o;
        return other.getData().equals(this.data);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.data);
    }

    @Override
    public String toString() {
        return "Vehicle {"
                + "data=" + data
                + ", turismes=" + turismes
                + ", total=" + total
                + ", origen=" + origen
                + '}';
    }

}
