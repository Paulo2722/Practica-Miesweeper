public class Jugador {
    private String nombre;

    public Jugador(String nombre, char ficha){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

}
