public class Tablero {
    private char[][] tablero;
    private final int filas = 9;
    private final int columnas = 9;
    private final int numeroMinas = 10;
    private char blanco = ' ';

    public Tablero() {

        tablero = new char[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = blanco;
            }
        }
    }
}