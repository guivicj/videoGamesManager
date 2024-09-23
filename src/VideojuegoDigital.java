import java.util.Locale;

public class VideojuegoDigital extends Videojuego {

    private static final double DEF_DISC = 0.15;

    public VideojuegoDigital(String name, Console plat, double cost, Genero genero) {
        super(name, plat, cost, genero);
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
        return cost - (DEF_DISC * cost);
    }

    public boolean isCompatible(Console console) {
        return console.equals(getPlat());
    }

    @Override
    public String toString() {
        return super.toString() + String.format(Locale.ENGLISH, " %02.2f", calculateCost());
    }
}
