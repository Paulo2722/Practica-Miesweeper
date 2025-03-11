public class Casilla {
    private boolean estaTapada;
    private boolean tieneMina;
    private boolean tieneBandera;


    public Casilla(boolean estaTapada, boolean tieneMina, boolean tieneBandera){

        this.estaTapada = true;
        this.tieneMina = false;
        this.tieneBandera = false;
    }

    public boolean getEstaTapada(){
        return estaTapada;
    }
    public boolean getTieneMina(){
        return tieneMina;
    }
    public boolean getTieneBandera(){
        return tieneBandera;
    }

    public void setEstaTapada(boolean estaTapada){
        this.estaTapada = true;
    }
    public void setTieneMina(boolean tieneMina){
        this.tieneMina = false;
    }
    public void setTieneBandera(boolean TieneBandera){
        this.tieneBandera = false;
    }

    public char Simbolo(){
        if (tieneBandera)
            return 'P';
        if (tieneMina)
            return 'O';
        if (estaTapada)
            return '#';

        return ' ';
    }

}
