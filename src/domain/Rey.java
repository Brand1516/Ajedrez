package domain;

public class Rey extends Pieza{

    public Rey (int movX, int movY, String color, String tipo){
        super(movX, movY, color, tipo);
    }

    public String toString(){
        return getTipo();
    }
}
