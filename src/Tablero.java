import java.util.Random;

public class Tablero {
    private Casilla[][] tablero;
    private final int filas = 9;
    private final int columnas = 9;
    private int numeroMinas = 10;

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

        int minasPorPoner = numeroMinas;

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
            minasPorPoner--;

        } while (minasPorPoner != 0);
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

    public void revelarCasillas(int posicionFila, int posicionColumna) {

        Casilla casilla = new Casilla();

        if (casilla.tieneMina() || casilla.estaTapada()) {
            return;
        }

        int minasAdyacentes = contarMinasAdyacentes(posicionFila, posicionColumna);
        casilla.abrir();

        if (minasAdyacentes > 0) {
            casilla.setMinasAdyacentes(minasAdyacentes);
        }

        if (minasAdyacentes <= 0) {
            int[] filasAdyacentes = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] columnasAdyacentes = {-1, 0, 1, -1, 1, -1, 0, 1};

            for (int i = 0; i < 8; i++) {
                revelarCasillas(posicionFila + filasAdyacentes[i],
                        posicionColumna + columnasAdyacentes[i]);
            }
        }
    }

    public boolean comprobarVictoria() {

        int cantidadMinas = numeroMinas;
        int numeroCasillasSinMinas = (filas * columnas) - cantidadMinas; //El 10 es el numero de minas
        int casillasAbiertas = 0;

        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                if (!tablero[i][j].estaTapada() && !tablero[i][j].tieneMina() && !tablero[i][j].tieneBandera()){
                    casillasAbiertas++;
                }
            }
        }

        if (numeroCasillasSinMinas == casillasAbiertas){
            return true;

        }

        return false;
    }
}