import java.util.Locale;

public class VideojuegoFisico extends Videojuego {

    private final double DEF_SEND = 3;

    private final GameType gameType = GameType.PHYSICAL;

    public VideojuegoFisico(String name, Console plat, double cost, Genero genero) {
        super(name, plat, cost, genero);
    }

    public VideojuegoFisico(String[] gameInArray) {
        super(gameInArray);
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
        return name +
                "," + getPlat() +
                "," + cost +
                "," + getGenr() +
                "," + gameType + "\n";
    }


}
