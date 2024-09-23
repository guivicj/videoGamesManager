import java.util.Locale;

public class VideojuegoFisico extends Videojuego {

    private static final double DEF_SEND = 3;

    public VideojuegoFisico(String name, Console plat, double cost, Genero genero) {
        super(name, plat, cost, genero);
    }

    private boolean validateSend(double send) {
        return send > 1.0;
    }

    @Override
    public double calculateCost() {
        return getCost() + DEF_SEND;
    }

    public boolean isCompatible(Console console) {
        return console.equals(getPlat());
    }

    @Override
    public String toString() {
        return super.toString() + String.format(Locale.ENGLISH, " %02.2f", calculateCost());
    }


}
