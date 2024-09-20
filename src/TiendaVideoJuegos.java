public class TiendaVideoJuegos {

    public static void main(String[] args) {
        System.out.println(
                """
                NOMBRE                         CONSOLA         PRECIO GÉNERO TOTAL
                ============================== =============== ====== ====== =====""");
        Videojuego videojuego = new VideojuegoFisico(
                "Thi Legend of Zelda", "playstation", 50.0, 5.0, Genero.ACCION);
        System.out.println(videojuego);

        Videojuego videojuego2 = new VideojuegoDigital(
                "Thi Legend of Zelda", "playstation", 50.0, 5.0, Genero.ACCION);
        System.out.println(videojuego2);

    }

}