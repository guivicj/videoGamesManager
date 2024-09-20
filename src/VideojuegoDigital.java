import java.util.Locale;

public class VideojuegoDigital extends Videojuego {

    private double disc;
    private static final double DEF_DISC = 0.15;

    public VideojuegoDigital(String name, String plat, double cost, double disc, Genero genero) {
        super(name, plat, cost, genero);
        if (validateDisc(disc)) {
            this.disc = disc;
        } else {
            this.disc = DEF_DISC;
        }
    }

    private boolean validateGenero(Genero genero) {
        boolean generoOK;
        try {
            Genero g = Genero.valueOf(genero.toString());
            generoOK = true;
        } catch (Exception e) {
            generoOK = false;
        }

        return generoOK;
    }

    private boolean validateDisc(double disc) {
        return disc >= 0.0 && disc <= 1.0;
    }

    @Override
    public double calculateCost() {
        return cost - (disc * cost);
    }

    @Override
    public boolean isCompatible(IConsole console) {
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(Locale.ENGLISH, " %02.2f", calculateCost());
    }
}