public class Casilla {
    private boolean estaTapada;
    private boolean tieneMina;
    private boolean tieneBandera;
    private int minasAdyacentes;

    public Casilla(){
        this.estaTapada = true;
        this.tieneMina = false;
        this.tieneBandera = false;
        this.minasAdyacentes = 0;
    }

    public boolean estaTapada(){
        return estaTapada;
    }

    public boolean tieneMina(){
        return tieneMina;
    }

    public boolean tieneBandera(){
        return tieneBandera;
    }

    public void ponerMina(){
        this.tieneMina = true;
    }

    public void ponerBandera(){
        this.tieneBandera = true;
    }

    public void quitarBandera() {
        this.tieneBandera = false;
    }

    public int getMinasAdyacentes(){
        return minasAdyacentes;
    }

    public void setMinasAdyacentes(int minasAdyacentes){
        this.minasAdyacentes = minasAdyacentes;
    }

    public void abrir(){
        this.estaTapada = false;
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
