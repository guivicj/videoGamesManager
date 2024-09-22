import java.util.ArrayList;
import java.util.List;

public class TiendaVideoJuegos {

    public static void main(String[] args) {

        List<Videojuego> vdj = new ArrayList<>();
        Platform p = new Platform();
        Videojuego v = new VideojuegoDigital("The Legend Of Zelda", Console.NINTENDO, 50, Genero.AVENTURA);
        vdj.add(v);
        String archivoCSV = "D:/DAM2/01-Acceso a Datos/GestionVideoJuegos/" + v.getPlat().name() + ".txt";

        p.loadCSV(vdj, archivoCSV);

        p.saveCSV(vdj, archivoCSV);
    }
}