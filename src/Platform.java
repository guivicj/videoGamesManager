import error.JuegoNoCompatibleException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Platform implements IConsole {

    private String plat;

    public Platform() {
        this.plat = Console.COMPUTER.toString();
    }

    public Platform(String plat) {
        this.plat = plat;
    }

    public void switchOn() {
        System.out.printf("Encendiendo %s%n", getPlataforma());
    }

    public void switchOff() {
        System.out.printf("Apagando %s%n", getPlataforma());
    }

    public void installGame(Videojuego vdj) throws JuegoNoCompatibleException {
        System.out.printf("Instalando %s en %s%n", vdj.getName(), getPlataforma());
    }

    public void playGame(Videojuego vdj) {
        System.out.printf("Iniciando %s en %s%n", vdj.getName(), getPlataforma());
    }

    public String getPlataforma() {
        return plat;
    }

    public void loadCSV(Properties prp, String consola) {

        try (FileReader fr = new FileReader(consola)) {
            prp.load(fr);

        } catch (IOException e) {
            System.out.println("Fichero no Cargado");
        }
    }

    public void saveCSV(Properties prp, String consola) {
        try (FileWriter fw = new FileWriter(consola)) {
            prp.store(fw, null);
        } catch (IOException e) {
            System.out.println("Fichero no Cargado");
        }
    }
}
