import java.util.Random;

public class Tablero {
    private char[][] tablero;
    private final int filas = 9;
    private final int columnas = 9;
    private char casillaTapada = '#';
    private char casillaRevelada = ' ';
    private char Mina = 'O';

    public Tablero() {

        tablero = new char[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = casillaTapada;
            }
        }
    }

    public void imprimirTablero() {

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("[" + tablero[i][j] + "]");
            }
            System.out.println();
        }
    }

    public void ponerMinas() {

        int numeroMinas = 10;

        do {
            Random random = new Random();

            int filaAleatoria = random.nextInt(9);
            int columnaAleatoria = random.nextInt(9);

            if (tablero[filaAleatoria][columnaAleatoria] == Mina)

                do {

                    filaAleatoria = random.nextInt(9);
                    columnaAleatoria = random.nextInt(9);

                } while (tablero[filaAleatoria][columnaAleatoria] == Mina);

            tablero[filaAleatoria][columnaAleatoria] = Mina;
            numeroMinas--;

        } while (numeroMinas != 0);
    }

    public boolean hayMina(int posicionFila, int posicionColumna) {

        return tablero[posicionFila][posicionColumna] == Mina;
    }

    public void seleccionarOpcion(int opcion, int posicionFila, int posicionColumna, Ficha ficha) {

        switch (opcion) {
            case 1:
                System.out.println("Seleccione una fila (0-8): ");
                System.out.println("Seleccione una columna (0-8) :");

            case 2:
                System.out.println("Seleccione una fila (0-8): ");
                System.out.println("Seleccione una columna (0-8) :");

                tablero[posicionFila][posicionColumna] = ficha.getBandera();

            case 3:
                System.out.println("Seleccione una fila (0-8): ");
                System.out.println("Seleccione una columna (0-8) :");

                tablero[posicionFila][posicionColumna] = ficha.getInterrogante();

                break;
        }
    }

    public int contarMinasAdyacentes(int posicionFila, int posicionColumna) {

        int[] filasAdyacentes = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] columnasAdyacentes = {-1, 0, 1, -1, 1, -1, 0, 1};

        int count = 0;

        for (int i = 0; i < 8; i++){

            int fila2 = posicionFila + filasAdyacentes[i];
            int columna2 = posicionColumna + columnasAdyacentes[i];

            if (fila2 != Mina && columna2 != Mina && fila2 <= filas && columna2 <= columnas){
                if (tablero[fila2][columna2] == Mina){
                    count++;
                }
            }
        }
        return count;
    }
}