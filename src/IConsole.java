import error.JuegoNoCompatibleException;

import java.io.IOException;

public interface IConsole {
    void switchOn();

    void switchOff() throws IOException;

    void installGame(Videojuego vdj) throws JuegoNoCompatibleException, IOException;

    void playGame(Videojuego vdj);

    Console getPlataforma();
}
