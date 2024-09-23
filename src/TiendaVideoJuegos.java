import error.JuegoNoCompatibleException;

import java.util.ArrayList;
import java.util.List;

public class TiendaVideoJuegos {

    static final List<Videojuego> vdj = new ArrayList<>();
    static final Platform p = new Platform(Console.NINTENDO);
    static final VideojuegoDigital v = new VideojuegoDigital("The Legend Of Zelda", Console.NINTENDO, 50, Genero.AVENTURA);
    static final String archivoCSV = "D:/DAM2/01-Acceso a Datos/GestionVideoJuegos/" + v.getPlat().name() + ".txt";

    public static void main(String[] args) {
        p.loadCSV(vdj, archivoCSV);

        p.switchOn();
        try {
            p.installGame(v);
        } catch (JuegoNoCompatibleException e) {
            e.getMessage();
        }
        p.switchOff();

        p.saveCSV(vdj, archivoCSV);
    }
}