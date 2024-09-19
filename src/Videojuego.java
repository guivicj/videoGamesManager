import java.util.Locale;
import java.util.Objects;

public abstract class Videojuego {

    protected String name;
    protected String plat;
    protected double cost;
    protected Genero genr;


    // Valores por Defecto
    private static final String DEF_NAME = "undefined";
    private static final String DEF_PLAT = "undefined";
    private static final double DEF_COST = 0.0;
    private static final String DEF_GENR = "undefined";

    // Valores Predeterminados
    private static final String PLAT_PLAY = "playstation";
    private static final String PLAT_NINT = "nintendo";
    private static final String PLAT_COMP = "ordenador";
    private static final String PLAT_XBOX = "xbox";


    public Videojuego() {
        this.name = DEF_NAME;
        this.plat = DEF_PLAT;
        this.cost = DEF_COST;
        this.genr = Genero.ACCION;
    }

    public Videojuego(String name, String plat, double cost, Genero genr) {
        if (validateName(name)) {
            this.name = name;
        } else {
            this.name = DEF_NAME;
        }
        if (validatePlat(plat)) {
            this.plat = plat;
        } else {
            this.plat = DEF_PLAT;
        }
        if (validateCost(cost)) {
            this.cost = cost;
        } else {
            this.cost = DEF_COST;
        }
        if (genr != null) {
            this.genr = genr;
        } else {
            this.genr = Genero.ACCION;
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (validateName(name)) {
            this.name = name;
        }
    }

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        if (validatePlat(plat)) {
            this.plat = plat;
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

    private boolean validatePlat(String plat) {
        return plat.equalsIgnoreCase(PLAT_PLAY) || plat.equalsIgnoreCase(PLAT_NINT)
                || plat.equalsIgnoreCase(PLAT_COMP) || plat.equalsIgnoreCase(PLAT_XBOX);
    }

    private boolean validateCost(double cost) {
        return cost >= 0;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "%-30s %-16s %.2f %s", name, plat, cost, genr);
    }

    public abstract double calculateCost();

    public abstract boolean isCompatible(IConsole console);
}