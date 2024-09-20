import java.util.Locale;

public class VideojuegoFisico extends Videojuego {
    private double send;

    private static final double DEF_SEND = 0.0;

    public VideojuegoFisico(String name, String plat, double cost, double send, Genero genero) {
        super(name, plat, cost, genero);
        if (validateSend(send)) {
            this.send = send;
        } else {
            this.send = DEF_SEND;
        }
    }

    private boolean validateSend(double send) {
        return send >= 0.0;
    }

    public double getSend() {
        return send;
    }

    public void setSend(double send) {
        if (validateSend(send)) {
            this.send = send;
        }
    }

    @Override
    public double calculateCost() {
        return getCost() + send;
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
