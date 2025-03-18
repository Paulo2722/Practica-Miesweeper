import java.util.Random;

public class Tablero {
    private Casilla[][] tablero;
    private final int filas = 9;
    private final int columnas = 9;
    private final int numeroMinas = 10;

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

    public void ponerBandera(int posicionFila, int posicionColumna){
        tablero[posicionFila][posicionColumna].ponerBandera();
    }

    public void quitarBandera(int posicionFila, int posicionColumna){

        if (tablero[posicionFila][posicionColumna].tieneBandera())
            tablero[posicionFila][posicionColumna].quitarBandera();
    }

    public boolean tieneMina(int posicionFila, int posicionColumna) {
        return tablero[posicionFila][posicionColumna].tieneMina();
    }

    public int contarMinasAdyacentes(int posicionFila, int posicionColumna) {

        int[] filasAdyacentes = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] columnasAdyacentes = {-1, 0, 1, -1, 1, -1, 0, 1};

        int count = 0;

        for (int i = 0; i < 8; i++){

            int fila2 = posicionFila + filasAdyacentes[i];
            int columna2 = posicionColumna + columnasAdyacentes[i];

            if (fila2 < filas && columna2 < columnas && fila2 >= 0 && columna2 >= 0){
                if (tablero[fila2][columna2].tieneMina()){
                    count++;
                }
            }
        }
        return count;
    }

    public void revelarCasillas(int posicionFila, int posicionColumna) {

        if (posicionFila < 0 || posicionFila >= filas || posicionColumna < 0 || posicionColumna >= columnas) {
            return;
        }

        Casilla casilla = tablero[posicionFila][posicionColumna];

        if (casilla.tieneMina() || !casilla.estaTapada() || casilla.tieneBandera()) {
            return;
        }

        casilla.abrir();
        int minasAdyacentes = contarMinasAdyacentes(posicionFila, posicionColumna);

        if (minasAdyacentes > 0) {
            casilla.setMinasAdyacentes(minasAdyacentes);
        } else {
            int[] filasAdyacentes = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] columnasAdyacentes = {-1, 0, 1, -1, 1, -1, 0, 1};

            for (int i = 0; i < 8; i++) {
                int filaAdyacente = posicionFila + filasAdyacentes[i];
                int columnaAdyacente = posicionColumna + columnasAdyacentes[i];

                revelarCasillas(filaAdyacente, columnaAdyacente);
                }
            }
        }

    public boolean comprobarVictoria() {

        int numeroCasillasSinMinas = (filas * columnas) - numeroMinas;
        int casillasAbiertas = 0;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!tablero[i][j].estaTapada() && !tablero[i][j].tieneMina()) {
                    casillasAbiertas++;
                }
            }
        }
        return numeroCasillasSinMinas == casillasAbiertas;
    }
}