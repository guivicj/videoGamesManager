import java.util.Locale;
import java.util.Objects;

public abstract class Videojuego {

    protected String name;
    private Console plat;
    protected double cost;
    private Genero genr;


    public Videojuego(String name, Console plat, double cost, Genero genr) {
        this.name = name;
        this.plat = plat;
        this.cost = cost;
        this.genr = genr;
    }

    public Videojuego(String[] line) {
        this.name = line[0];
        this.plat = Console.valueOf(line[1]);
        this.cost = Double.parseDouble(line[2]);
        this.genr = Genero.valueOf(line[3]);
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public Console getPlat() {
        return plat;
    }

    public Genero getGenr() {
        return genr;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Videojuego v && this.name.equals(v.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public abstract double calculateCost();

    public abstract boolean isCompatible(Console console);
}