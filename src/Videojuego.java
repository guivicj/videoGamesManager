import java.util.Locale;
import java.util.Objects;

public abstract class Videojuego {

    protected String name;
    private Console plat;
    protected double cost;
    private Genero genr;


    // Valores por Defecto
    private static final String DEF_NAME = "undefined";
    private static final String DEF_PLAT = "undefined";
    private static final double DEF_COST = 0.0;

    public Videojuego() {
        this.name = DEF_NAME;
        this.setPlat(Console.COMPUTER);
        this.cost = DEF_COST;
        this.setGenr(Genero.ACCION);
    }

    public Videojuego(String name, Console plat, double cost, Genero genr) {
        if (validateName(name)) {
            this.name = name;
        } else {
            this.name = DEF_NAME;
        }
        if (validateCost(cost)) {
            this.cost = cost;
        } else {
            this.cost = DEF_COST;
        }
        if (genr != null) {
            this.setGenr(genr);
        } else {
            this.setGenr(Genero.ACCION);
        }
        this.setPlat(plat);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (validateName(name)) {
            this.name = name;
        }
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if (validateCost(cost)) {
            this.cost = cost;
        }
    }

    public Console getPlat() {
        return plat;
    }

    public void setPlat(Console plat) {
        this.plat = plat;
    }

    public Genero getGenr() {
        return genr;
    }

    public void setGenr(Genero genr) {
        this.genr = genr;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Videojuego v && this.name.equals(v.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    private boolean validateName(String name) {
        return name != null && !name.isEmpty();
    }

    private boolean validateCost(double cost) {
        return cost >= 0;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "%-30s %-16s %.2f %s", name, getPlat(), cost, getGenr());
    }

    public abstract double calculateCost();

    public abstract boolean isCompatible(IConsole console);
}