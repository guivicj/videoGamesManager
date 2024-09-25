import error.JuegoNoCompatibleException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Platform implements IConsole {

    private Console plat;

    private static final String SEP_CSV = ",";
    VideojuegoDigital v = new VideojuegoDigital("Spiderman", Console.PLAYSTATION, 50, Genero.ACCION);
    String FILE_CSV = "D:/DAM2/01-Acceso a Datos/GestionVideoJuegos/" + v.getPlat().name() + ".txt";
    List<Videojuego> LST_VDJ = new ArrayList<>();

    public Platform() {
        this.plat = Console.PLAYSTATION;
    }

    public Platform(Console plat) {
        this.plat = plat;
    }

    public void switchOn() {
        System.out.printf("Encendiendo %s%n", getPlataforma());
        loadCSV(LST_VDJ, FILE_CSV);
        try {
            installGame(v);
        } catch (JuegoNoCompatibleException e) {
            e.getMessage();
        }

    }

    public void switchOff() {
        saveCSV(LST_VDJ, FILE_CSV);
        System.out.printf("Apagando %s%n", getPlataforma());
    }

    public void installGame(Videojuego vdj) throws JuegoNoCompatibleException {
        if (vdj.isCompatible(getPlataforma()) && !LST_VDJ.contains(vdj)) {
            System.out.printf("Instalando %s en %s%n", vdj.getName(), getPlataforma());
            LST_VDJ.add(v);
        } else {
            throw new JuegoNoCompatibleException();
        }
    }

    public void playGame(Videojuego vdj) {
        System.out.printf("Iniciando %s en %s%n", vdj.getName(), getPlataforma());
    }

    public Console getPlataforma() {
        return plat;
    }

    public void loadCSV(List<Videojuego> vdj, String consola) {

        try (FileReader fr = new FileReader(consola); BufferedReader br = new BufferedReader(fr)) {

            String line;
            do {
                line = br.readLine();

                try {

                    if (line != null) {
                        String[] parts = line.split(",");

                        String name = parts[0];
                        Console plat = Console.valueOf(parts[1]);
                        double cost = Double.parseDouble(parts[2]);
                        Genero genr = Genero.valueOf(parts[3]);

                        Videojuego v = new VideojuegoDigital(name, plat, cost, genr);

                        vdj.add(v);
                    }
                } catch (Exception e) {
                    System.out.println("ERROR EN EL FICHERO");
                }
            } while (line != null);
        } catch (IOException e) {
            System.out.println("Fichero no Cargado");
        }
    }

    public void saveCSV(List<Videojuego> vdj, String consola) {
        try (FileWriter fw = new FileWriter(consola)) {

            for (Videojuego v : vdj) {
                String line =
                        v.getName() + SEP_CSV
                                + v.getPlat().name() + SEP_CSV
                                + v.getCost() + SEP_CSV
                                + v.getGenr();
                fw.write(line + "\n");
            }

        } catch (IOException e) {
            System.out.println("Fichero no Cargado");
        }
    }
}