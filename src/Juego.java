import java.util.Scanner;

public class Juego {

    public void iniciarJuego(){
        Scanner sc = new Scanner(System.in);

        Tablero tablero = new Tablero();
        tablero.ponerMinas();
        boolean partida = true;

        while (partida) {

            tablero.imprimirTablero();

            System.out.println("Seleccione su acción (1-3): ");
            System.out.println();
            System.out.println("1.Abrir casilla");
            System.out.println("2.Poner bandera");
            System.out.println("3.Quitar bandera");
            System.out.println("4.Finalizar partida");

            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:

                    int posicionFila = sc.nextInt();
                    int posicionColumna = sc.nextInt();

                    System.out.println("Seleccione una fila (0-8): " + posicionFila);
                    System.out.println("Seleccione una columna (0-8): " + posicionColumna);

                    tablero.revelarCasillas(posicionFila, posicionColumna);
                    tablero.comprobarVictoria();

                    if (tablero.comprobarVictoria()) {
                        partida = false;
                    }

                    break;

                case 2:

                    posicionFila = sc.nextInt();
                    posicionColumna = sc.nextInt();

                    System.out.println("Seleccione una fila (0-8): " + posicionFila);
                    System.out.println("Seleccione una columna (0-8): " + posicionColumna);

                    tablero.ponerBandera(posicionFila, posicionColumna);

                    break;

                case 3:

                    posicionFila = sc.nextInt();
                    posicionColumna = sc.nextInt();

                    System.out.println("Seleccione la fila de la bandera (0-8): " + posicionFila);
                    System.out.println("Seleccione la columna de la bandera (0-8): " + posicionColumna);

                    tablero.quitarBandera(posicionFila, posicionColumna);

                    break;

                case 4:

                    partida = false;

                default:
                    System.out.println("La opción seleccionada no es válida");
            }
        }
        System.out.println("Partida finalizada");
    }
}
