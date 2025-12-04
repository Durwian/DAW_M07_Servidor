package cat.xtec.ioc.domain;

import java.util.Objects;

public class Renda {

    private int any;
    
    public Renda(int any) { //afegir les altres propietats: homes, dones, total, origen
        this.any = any;

    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Renda)) {
            return false;
        }

        final Renda other = (Renda) o;
        return other.getAny() == this.any;

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.any);
    }

    @Override
    public String toString() {
        return "Renda {"
                + "any=" + any
                + '}';
    }

}
