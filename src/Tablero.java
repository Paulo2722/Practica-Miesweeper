import java.util.Random;

public class Tablero {
    private char[][] tablero;
    private final int filas = 9;
    private final int columnas = 9;
    private char blanco = ' ';
    private char Mina = 'O';

    public Tablero() {

        tablero = new char[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = blanco;
            }
        }
    }

    public void imprimirTablero(){

    for (int i = 0; i < filas; i++){
        for (int j = 0; j < columnas; j++){
            System.out.print("[" + tablero[i][j] + "]");
        }
        System.out.println();
    }
    }

    public void ponerMinas(){

        int numeroMinas = 10;

        do{
            Random random = new Random();

            int filaAleatoria = random.nextInt(10);
            int columnaAleatoria = random.nextInt(10);

            tablero[filaAleatoria][columnaAleatoria] = Mina;
            numeroMinas--;

        }while (numeroMinas != 0);
    }

    public boolean hayMina(int posicionFila, int posicionColumna){

        if (tablero[posicionFila][posicionColumna] == Mina){
            return true;
        }else{
            return false;
        }
    }

    public void seleccionarOpcion(int opcion, int posicionFila, int posicionColumna, Ficha ficha){

        switch (opcion){
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
}