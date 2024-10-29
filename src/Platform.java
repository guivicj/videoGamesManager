import error.JuegoNoCompatibleException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Platform implements IConsole {

    private Console plat;

    private List<Videojuego> videoGamesInstalled = new ArrayList<>();

    private static final String SEP_CSV = ",";

    private String archivoCSV;

    // Eliminado constructor predeterminado por falta de uso
    // Archivo csv inicializado y puesto private en su declaaración
    public Platform(Console plat) {
        this.plat = plat;
        this.archivoCSV = "./" + getPlataforma() + ".txt";
    }

    public void switchOn() {
        System.out.printf("Encendiendo %s%n", getPlataforma());
        try {
            BufferedReader bufferedReader = createStorage();
            loadCSV(bufferedReader);
        } catch (IOException e) {
            e.getMessage();
        }

    }

    private BufferedReader createStorage() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(archivoCSV)));
        return bufferedReader;
    }

    public void switchOff() {
        System.out.printf("Apagando %s%n", getPlataforma());
    }

    public void installGame(Videojuego vdj) throws IOException {
        if (vdj.isCompatible(getPlataforma()) && !videoGamesInstalled.contains(vdj)) {
            System.out.printf("Instalando %s en %s%n", vdj.getName(), getPlataforma());
            saveCSV(vdj);
            videoGamesInstalled.add(vdj);
        } else {
            System.out.println("VideoGame can't be installed");
        }
    }


    public Console getPlataforma() {
        return plat;
    }

    public void loadCSV(BufferedReader bufferedReader) throws IOException {

        // Simplificación del trycatch anterior mediante modularizacion
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] gameInArray = getArrayFromLine(line);
            installGameByType(gameInArray);
        }
    }

    // Metodo creado para diferenciar el tipo de videojuego antes de instalarlo
    private void installGameByType(String[] gameInArray) {
        GameType gameType = GameType.valueOf(gameInArray[4]);
        if (gameType.equals(GameType.DIGITAL)) {
            VideojuegoDigital videojuegoDigital = new VideojuegoDigital(gameInArray);
            videoGamesInstalled.add(videojuegoDigital);
        } else {
            VideojuegoFisico videojuegoFisico = new VideojuegoFisico(gameInArray);
            videoGamesInstalled.add(videojuegoFisico);
        }
    }

    // Metodo creado para separar la línea según el separador
    private String[] getArrayFromLine(String line) {
        return line.split(SEP_CSV);
    }

    public void saveCSV(Videojuego vdj) throws IOException {
        FileWriter fw = new FileWriter(new File(archivoCSV), true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(vdj.toString());
        bw.close();
    }

    public void playGame(Videojuego vdj) {
        System.out.printf("Iniciando %s en %s%n", vdj.getName(), getPlataforma());
    }
}
