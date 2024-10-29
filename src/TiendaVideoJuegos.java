import error.JuegoNoCompatibleException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TiendaVideoJuegos {


    public static void main(String[] args) throws JuegoNoCompatibleException, IOException {
        VideojuegoDigital redDeadDigital = new VideojuegoDigital("RedDead", Console.COMPUTER, 35.0, Genero.ACCION);
        System.out.println(redDeadDigital.toString());


        Platform p = new Platform(Console.COMPUTER);
        p.switchOn();
        p.installGame(redDeadDigital);
        p.switchOff();
    }
}