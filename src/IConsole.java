import error.JuegoNoCompatibleException;

public interface IConsole {
    void switchOn();

    void switchOff();

    void installGame(Videojuego vdj) throws JuegoNoCompatibleException;

    void playGame(Videojuego vdj);

    String getPlataforma();
}
