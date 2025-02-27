public class Tablero {
    private char[][] tablero;
    private final int filas = 9;
    private final int columnas = 9;

    public void imprimirTablero(){
        Tablero tablero = new Tablero();

        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                System.out.print("[" + ' ' + "]");
            }
            System.out.println();
        }
    }
}
