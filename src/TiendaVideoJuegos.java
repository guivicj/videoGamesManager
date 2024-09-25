import error.JuegoNoCompatibleException;

import java.util.ArrayList;
import java.util.List;

public class TiendaVideoJuegos {

    static final Platform p = new Platform(Console.PLAYSTATION);

    public static void main(String[] args) {
        p.switchOn();
        p.switchOff();
    }
}