import java.util.Properties;

public class TiendaVideoJuegos {

    public static void main(String[] args) {

        Properties prp = new Properties();
        Platform p = new Platform();
        Videojuego v = new VideojuegoDigital("The Legend Of Zelda", Console.NINTENDO, 50, 0.15, Genero.ACCION);
        p.loadCSV(prp, String.valueOf(v.plat));



        p.saveCSV(prp, String.valueOf(v.plat));
    }
}