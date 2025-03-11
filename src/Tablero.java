import java.util.Random;

public class Tablero {
    private Casilla[][] tablero;
    private final int filas = 9;
    private final int columnas = 9;

    public Tablero() {

        tablero = new Casilla[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = new Casilla();
            }
        }
    }

    public void imprimirTablero() {

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("[" + tablero[i][j].Simbolo() + "]");
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

            if (tablero[filaAleatoria][columnaAleatoria].tieneMina())

                do {

                    filaAleatoria = random.nextInt(9);
                    columnaAleatoria = random.nextInt(9);

                } while (tablero[filaAleatoria][columnaAleatoria].tieneMina());

            tablero[filaAleatoria][columnaAleatoria].ponerMina();
            numeroMinas--;

        } while (numeroMinas != 0);
    }

    public void seleccionarOpcion(int opcion, int posicionFila, int posicionColumna, Ficha ficha) {

        switch (opcion) {
            case 1:
                System.out.println("Seleccione una fila (0-8): ");
                System.out.println("Seleccione una columna (0-8) :");

            case 2:
                System.out.println("Seleccione una fila (0-8): ");
                System.out.println("Seleccione una columna (0-8) :");

            case 3:
                System.out.println("Seleccione una fila (0-8): ");
                System.out.println("Seleccione una columna (0-8) :");

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

            if (fila2 <= filas && columna2 <= columnas && fila2 >= 0 && columna2 >= 0){
                if (tablero[fila2][columna2].tieneMina()){
                    count++;
                }
            }
        }
        return count;
    }
}