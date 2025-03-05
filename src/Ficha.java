public class Ficha {
    private char bandera;
    private char interrogante;

    public Ficha(char bandera, char interrogante){
        this.bandera = bandera;
        this.interrogante = interrogante;
    }

    public char getBandera(){
        return bandera;
    }

    public char getInterrogante(){
        return interrogante;
    }

    public void setBandera(char bandera){
        this.bandera = bandera;
    }

    public void setInterrogante(char interrogante){
        this.interrogante = interrogante;
    }
}
