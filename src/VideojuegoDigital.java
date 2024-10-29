import java.util.Locale;

public class VideojuegoDigital extends Videojuego {

    private static final double DEF_DISC = 0.15;

    private final GameType gameType = GameType.DIGITAL;

    public VideojuegoDigital(String name, Console plat, double cost, Genero genr) {
        super(name, plat, cost, genr);
    }

    public VideojuegoDigital(String[] gameInArray){
        super(gameInArray);
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
        return name +
                "," + getPlat() +
                "," + cost +
                "," + getGenr() +
                "," + gameType + "\n";
    }
}
